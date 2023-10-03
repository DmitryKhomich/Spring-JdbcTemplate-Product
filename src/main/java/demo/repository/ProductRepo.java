package demo.repository;
import demo.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepo<T> {

    Optional<List<T>> showAll();
    Optional<T> getOneById(Integer id);
    boolean update(Integer id, Double price);
    boolean create(Product product);
    boolean delete(Integer id);

}
