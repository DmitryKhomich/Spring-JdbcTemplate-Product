package demo.controller;
import demo.entity.Product;
import demo.service.Service;
import demo.utils.Constants;
import demo.utils.Starter;
import demo.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductController {
    @Autowired
    MenuView menuView;
    @Autowired
    AllProductView allProductView;
    @Autowired
    CreateView createView;
    @Autowired
    DeleteView deleteView;
    @Autowired
    GetByIDView getByIDView;
    @Autowired
    UpdateView updateView;
    @Autowired
    Service service;

    public void create(){
        String[] data = createView.getData();
        createView.getOutput(service.create(new Product(data[0],Integer.valueOf(data[1]),Double.valueOf(data[2]))));
        Starter.runThisApp();
    }
    public void readAll(){
        allProductView.getOutput(service.getAll());
        Starter.runThisApp();
    }
    public void readById(){
        String id = getByIDView.getData();
        getByIDView.getOutput(service.getById(id));
        Starter.runThisApp();
    }
    public void update(){
        String[] data = updateView.getData();
        updateView.getOutput(service.update(data[0],data[1]));
        Starter.runThisApp();
    }
    public void delete(){
        String id = deleteView.getData();
        deleteView.getOutput(service.delete(id));
        Starter.runThisApp();
    }
    public void option(){
        int option = Integer.parseInt(menuView.getOption());
        switch (option){
            case 1 -> create();
            case 2 -> readAll();
            case 3 -> readById();
            case 4 -> update();
            case 5 -> delete();
            case 0 -> menuView.getOutput(Constants.APP_CLOSE_MSG);
        }
    }
}
