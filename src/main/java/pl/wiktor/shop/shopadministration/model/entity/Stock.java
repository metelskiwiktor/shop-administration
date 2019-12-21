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
    @Column
    private int stockLeft;

    public Stock(int stocks) {
        this.stocks = stocks;
        stockLeft = stocks;
    }

    public Stock() {
    }


    public int getStocks() {
        return stocks;
    }

    public int getStockLeft() {
        return stockLeft;
    }
}
