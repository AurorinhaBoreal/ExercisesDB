package exercises.superMarket;

import exercises.superMarket.Order.Order;

public class Item {
    private Product product;
    private int qtt;
    private double itemValue;

    public Item(Product product, int qtt, double itemValue) {
        this.product = product;
        this.qtt = qtt;
        this.itemValue = itemValue;
    }

    public void setItem(Product product, int qtt, double itemValue) {
        this.product = product;
        this.qtt = qtt;
        this.itemValue = itemValue;
    }

    public String getItem() {
        itemValue = this.qtt * this.itemValue;
        return String.format("| %s | %d | %.2f |", this.product.getName(), this.qtt, itemValue);
    }

    public double totalValue() {
        int totalValue[] = {0};
        Order.itemList.forEach((item) -> {
            totalValue[0] += item.itemValue;
        });
        return totalValue[0];
    }

    public void changeQtt(int qtt) {
        this.qtt = qtt;
    }
}
