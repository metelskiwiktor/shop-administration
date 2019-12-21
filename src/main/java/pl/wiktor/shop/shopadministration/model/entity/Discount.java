package pl.wiktor.shop.shopadministration.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int discountPercent;
    @Column
    private BigDecimal discountPrice;

    public Discount() {
    }

    public Discount(int discountPercent, BigDecimal discountPrice) {
        this.discountPercent = discountPercent;
        this.discountPrice = discountPrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
}
