package exercises.superMarket;

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
        return "| "+this.product+" | "+this.qtt+" | "+this.itemValue+" |";
    }

    public double totalValue() {
        double totalValue = qtt*itemValue;
        return totalValue;
    }

    public void changeQtt(int qtt) {
        this.qtt = qtt;
    }
}
