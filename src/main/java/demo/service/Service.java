package demo.service;

import demo.entity.Product;
import demo.repository.ProductRepoImp;
import demo.utils.Constants;
import demo.utils.IdValidator;
import demo.utils.PriceValidator;
import demo.utils.Rounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Service {
    @Autowired
    ProductRepoImp repo;

    Map<String, String> errors = new HashMap<>();

    public String create(Product product){
    validateData(product);
    if(!errors.isEmpty()){
        try{
            throw new RuntimeException("Check inputs");
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    if(repo.create(product)){
        return Constants.DATA_INSERT_MSG;
    } else {
        return Constants.SMTH_WRONG_MSG;
    }
    }

    public String getAll(){
        Optional<List<Product>> optional = repo.showAll();
        if(optional.isEmpty()){
            return Constants.DATA_ABSENT_MSG;
        } else {
            AtomicInteger counter = new AtomicInteger(1);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < optional.get().size(); i++) {
                stringBuilder.append(counter).append(") ").append((optional.get()).get(i));
                counter.getAndIncrement();
            }
            return stringBuilder.toString();
        }
    }

    public String getById(String id){

        validateId(id);
        if(!errors.isEmpty()){
            try{
                throw new RuntimeException("wrong id format or not exist");
            }catch (RuntimeException e){
                return e.getMessage();
            }
        }
        Optional<Product> optional = repo.getOneById(Integer.valueOf(id));
        if(optional.isEmpty()){
            return Constants.DATA_ABSENT_MSG;
        } else {
            return optional.get().toString();
        }
    }

    public String update(String id, String price) {
        validatePrice(price);
        validateId(id);
        if (!errors.isEmpty()) {
            try {
                throw new RuntimeException("Check inputs");
            } catch (RuntimeException e) {
                return e.getMessage();
            }
        }
        Optional<Product> optional = repo.getOneById(Integer.valueOf(id));
        if (!optional.isEmpty()) {
            if(repo.update(Integer.valueOf(id), Rounder.round(Double.parseDouble(price))))
            return Constants.DATA_UPDATE_MSG;
            else return Constants.SMTH_WRONG_MSG;
        } else {
            return Constants.SMTH_WRONG_MSG;
        }
    }

    public String delete(String id){
        validateId(id);
        if (!errors.isEmpty()) {
            try {
                throw new RuntimeException("Check inputs");
            } catch (RuntimeException e) {
                return e.getMessage();
            }
        }
        Optional<Product> optional = repo.getOneById(Integer.valueOf(id));

        if(optional.isEmpty()){
            return Constants.SMTH_WRONG_MSG;
        } else {
            if (repo.delete(Integer.valueOf(id)))
            return Constants.DATA_DELETE_MSG;
            else return Constants.SMTH_WRONG_MSG;
        }
    }

    private void validateData(Product product){
        if(product.getName().isEmpty()) errors.put("name", Constants.INPUT_REQ_MSG);

        if(product.getQuote() <= 0 || product.getQuote() == null) errors.put("quote", Constants.INPUT_REQ_MSG);

        if(PriceValidator.isPriceValid(Rounder.round(product.getPrice()))) errors.put("price", Constants.INPUT_REQ_MSG);
    }

    private void validateId(String id){
        if(IdValidator.isIdValid(id))
            errors.put("id",Constants.ID_ERR_MSG);
    }
    private void validatePrice(String price){
        if(PriceValidator.isPriceValid(Double.valueOf(price)))
            errors.put("price", Constants.PRICE_ERR);
    }
}
