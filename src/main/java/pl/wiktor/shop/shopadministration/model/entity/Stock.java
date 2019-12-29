package pl.wiktor.shop.shopadministration.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int stocks;

    public Stock(int stocks) {
        this.stocks = stocks;
    }

    public Stock() {
    }


    public int getStocks() {
        return stocks;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", stocks=" + stocks +
                '}';
    }
}
