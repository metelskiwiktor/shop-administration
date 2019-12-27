package pl.wiktor.shop.shopadministration.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Table(name = "item")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String name;
    @Column
    private BigDecimal basicPrice;
    @OneToOne(cascade = CascadeType.ALL)
    private Discount discount;
    @ManyToMany
    private Set<Category> categories;
    @ManyToMany
    private Set<Tag> tags;
    @OneToOne(cascade = CascadeType.ALL)
    private Stock stock;


    public Item() {
    }

    public Item(BigDecimal basicPrice, Set<Category> categories, Set<Tag> tags, String name, Stock stock) {
        this.basicPrice = basicPrice;
        this.categories = categories;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public String getName() {
        return name;
    }

    public Stock getStock() {
        return stock;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBasicPrice(BigDecimal basicPrice) {
        this.basicPrice = basicPrice;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", basicPrice=" + basicPrice +
                ", discount=" + discount +
                ", categories=" + categories +
                ", tags=" + tags +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
