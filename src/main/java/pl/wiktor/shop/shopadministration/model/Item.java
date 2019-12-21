package pl.wiktor.shop.shopadministration.model;

import pl.wiktor.shop.shopadministration.model.entity.Category;

import java.math.BigDecimal;
import java.util.List;

public class Item {
    private BigDecimal basicPrice;
    private Discount discount;
    private Category category;
    private List<Tag> tags;
    private String name;
    private Stock stock;

    public Item(BigDecimal basicPrice, Category category, List<Tag> tags, String name, Stock stock) {
        this.basicPrice = basicPrice;
        this.category = category;
        this.tags = tags;
        this.name = name;
        this.stock = stock;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public BigDecimal getBasicPrice() {
        return basicPrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Stock getStock() {
        return stock;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
