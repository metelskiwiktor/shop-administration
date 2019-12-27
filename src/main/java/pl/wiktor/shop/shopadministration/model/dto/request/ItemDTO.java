package pl.wiktor.shop.shopadministration.model.dto.request;

import pl.wiktor.shop.shopadministration.model.entity.Discount;
import pl.wiktor.shop.shopadministration.model.entity.Stock;
import pl.wiktor.shop.shopadministration.model.entity.Tag;
import pl.wiktor.shop.shopadministration.model.entity.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ItemDTO {
    private int id;
    private BigDecimal basicPrice;
    private Discount discount;
    private Set<Integer> idCategories;
    private Set<Integer> idTags;
    private String name;
    private Stock stock;

    public ItemDTO(BigDecimal basicPrice, Set<Integer> idCategories, Set<Integer> idTags, String name, Stock stock) {
        this.id = id;
        this.basicPrice = basicPrice;
        this.idCategories = idCategories;
        this.idTags = idTags;
        this.name = name;
        this.stock = stock;
    }

    public ItemDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Integer> getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Set<Integer> idCategories) {
        this.idCategories = idCategories;
    }

    public Set<Integer> getIdTags() {
        return idTags;
    }

    public void setIdTags(Set<Integer> idTags) {
        this.idTags = idTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
