package pl.wiktor.shop.shopadministration.model;

public class Stock {
    private int stocks;
    private int stockLeft;

    public Stock(int stocks) {
        this.stocks = stocks;
    }

    public int getStocks() {
        return stocks;
    }

    public int getStockLeft() {
        return stockLeft;
    }
}
