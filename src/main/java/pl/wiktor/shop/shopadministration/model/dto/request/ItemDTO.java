package pl.wiktor.shop.shopadministration.model.dto.request;

import pl.wiktor.shop.shopadministration.model.entity.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

public class ItemDTO {
    private int id;
    private String name;
    private BigDecimal basicPrice;
    private Discount discount;
    private Set<Category> categories;
    private Set<Tag> tags;
    private Stock stock;
    private Set<Author> authors;

    public ItemDTO() {
    }

    public ItemDTO(BigDecimal basicPrice, Discount discount, Set<Category> categories, Set<Tag> tags, String name, Stock stock, Set<Author> authors) {
        this.name = name;
        this.basicPrice = basicPrice;
        this.discount = discount;
        this.categories = categories;
        this.tags = tags;
        this.stock = stock;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(BigDecimal basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> author) {
        this.authors = author;
    }
}
