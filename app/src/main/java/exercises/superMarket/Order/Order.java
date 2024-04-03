package exercises.superMarket.Order;

import java.util.ArrayList;

import exercises.superMarket.Item;
import exercises.superMarket.Product;

public class Order {
    private ArrayList<Item> itemList = new ArrayList<>();
    private double totalOrderValue = 0;

    public void calcTotalValue() {
        double calcOrderValue[] = {0};
        itemList.forEach((item) -> {
            calcOrderValue[0] += itemList.get(itemList.indexOf(item)).totalValue();
        });
        this.totalOrderValue = calcOrderValue[0];
    }

    public boolean addItem(Product product, int qtt, double itemValue) {
        boolean AddVerify;
        if (itemList.add(new Item(product, qtt, itemValue))) AddVerify = true;
        else AddVerify = false;
        return AddVerify;
    }

    public String toString() {
        itemList.forEach((item)-> {
            System.out.println("| "+itemList.get(itemList.indexOf(item)).getItem()+" |");
        });
        System.out.println("| TOTAL: "+this.totalOrderValue+" |");
        return "a";
    };

    public String getTotalOrderValue() {
        return "| "+this.totalOrderValue+" |";
    }

    public void clearCart() {
        itemList.clear();
        this.totalOrderValue = 0;
    }
}
