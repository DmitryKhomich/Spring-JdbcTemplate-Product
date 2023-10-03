package demo.repository;
import demo.entity.Product;
import demo.entity.ProductMapper;
import demo.utils.Rounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
@Component
public class ProductRepoImp implements ProductRepo<Product> {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductRepoImp(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<List<Product>> showAll() {
        String sql = "SELECT * FROM products";
        Optional<List<Product>> optional;
        try{
            optional = Optional.of(jdbcTemplate.query(sql, new ProductMapper()));
        }catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }

    @Override
    public Optional<Product> getOneById(Integer id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        Optional<Product> optional;
        try {
            optional = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new ProductMapper(),id));
        } catch (Exception e){
            optional = Optional.empty();
        }
        return optional;
    }

    @Override
    public boolean update(Integer id, Double price) {
        Optional<Product> optional = getOneById(id);
        if(optional.isEmpty()) return false;
        else {
            String sql = "UPDATE products SET price = ? WHERE id = ?";
            return jdbcTemplate.update(sql,Rounder.round(price),id) > 0;
        }
    }

    @Override
    public boolean create(Product product) {
        Optional<Product> optional = Optional.ofNullable(product);
        if(optional.isEmpty()) return false;
        else{
            String sql = "INSERT INTO products (name, quote, price) VALUES (?,?,?)";
            return jdbcTemplate.update(sql, product.getName(), product.getQuote(), Rounder.round(product.getPrice())) > 0;
        }
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Product> optionalProduct = getOneById(id);
        if(optionalProduct.isEmpty()) return false;
        else {
            String sql = "DELETE FROM products WHERE id = ?";
            return jdbcTemplate.update(sql, id) > 0;
        }
    }
}
