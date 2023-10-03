package demo.entity;

import demo.utils.Rounder;
import org.springframework.stereotype.Component;

@Component
public class Product {
    Integer id;
    String name;
    Integer quote;
    Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuote() {
        return quote;
    }

    public void setQuote(Integer quote) {
        this.quote = quote;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product(){}

    public Product(Integer id, String name, Integer quote, Double price) {
        this.id = id;
        this.name = name;
        this.quote = quote;
        this.price = price;
    }

    public Product(String name, Integer quote, Double price){
        this.name = name;
        this.quote = quote;
        this.price = price;
    }
    @Override
    public String toString() {
        return "id - " + this.getId() +
                ", " + this.getName() +
            ", quote: " + this.getQuote() +
                ", price: " + Rounder.round(this.getPrice()) + "\n";
    }
}
