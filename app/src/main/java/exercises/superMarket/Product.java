package exercises.superMarket;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stockQtt;

    public Product(int id, String name, double price, int stockQtt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQtt = stockQtt;
    }

    public String getProduct() {
        return " | "+this.id+" | "+this.name+" | "+this.price+" | "+this.stockQtt+" |"; 
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void stockUpdate(int qtt) {
        this.stockQtt += qtt;
    }

    public void setStock(int stockQtt) {
        this.stockQtt = stockQtt;
    }

    public int getStock() {
        return this.stockQtt;
    }
}
