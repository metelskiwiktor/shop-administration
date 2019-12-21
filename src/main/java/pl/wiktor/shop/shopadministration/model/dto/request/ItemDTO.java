package pl.wiktor.shop.shopadministration.model.dto.request;

import pl.wiktor.shop.shopadministration.model.entity.Discount;
import pl.wiktor.shop.shopadministration.model.entity.Stock;
import pl.wiktor.shop.shopadministration.model.entity.Tag;
import pl.wiktor.shop.shopadministration.model.entity.Category;

import java.math.BigDecimal;
import java.util.List;

public class ItemDTO {
    private int id;
    private BigDecimal basicPrice;
    private Discount discount;
    private Category category;
    private List<Tag> tags;
    private String name;
    private Stock stock;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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
