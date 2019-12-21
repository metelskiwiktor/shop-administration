package pl.wiktor.shop.shopadministration.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "item")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private BigDecimal basicPrice;
    @OneToOne(cascade = CascadeType.ALL)
    private Discount discount;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Tag> tags;
    @Column(unique = true)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Stock stock;


    public Item() {
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setBasicPrice(BigDecimal basicPrice) {
        this.basicPrice = basicPrice;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
