package exercises.superMarket.Order;

import java.util.ArrayList;

import exercises.superMarket.Item;
import exercises.superMarket.Product;
import exercises.superMarket.Stock.Stock;

public class Order {
    static public ArrayList<Item> itemList = new ArrayList<>();
    static private double totalOrderValue = 0;
    static private double calcOrderValue = 0;

    public static void calcTotalValue(double addedItemPrice) {

        calcOrderValue += addedItemPrice;

        totalOrderValue = calcOrderValue;
    }

    public static double showTotalValue() {
        return totalOrderValue;
    }

    public static boolean addItem(Product product, int qtt, double itemValue) {
        boolean AddVerify;
        if (itemList.add(new Item(product, qtt, itemValue))) {
            int[] itemAddedIndex = {-1};
            int actualItemQtt;
            double actualItemPrice;
            double finalItemPrice;
            int i = 0;
            while (itemAddedIndex[0] == -1) {
                itemAddedIndex[0] = itemList.indexOf(itemList.get(i));
                i++;
            }
            actualItemQtt = itemList.get(itemAddedIndex[0]).getQtt();
            actualItemPrice = itemList.get(itemAddedIndex[0]).getPrice();
            finalItemPrice = actualItemPrice * actualItemQtt;

            calcTotalValue(finalItemPrice);

            AddVerify = true;
            
        }
        else AddVerify = false;
        return AddVerify;
    }

    public static String getOrder() {
        itemList.forEach((item)-> {
            System.out.println(itemList.get(itemList.indexOf(item)).getItem());
        });
        String totalValue = (String.format("| TOTAL: %.2f |", totalOrderValue));
        return totalValue;
    };

    public static String showTotalOrderValue() {
        return String.format("| VALOR DO PEDIDO: %.2f |", totalOrderValue);
    }

    public static void clearCart() {
        itemList.clear();
        totalOrderValue = 0;
    }

    public static void stockRemoval() {
        itemList.forEach((item) -> {
            int itemIndex = itemList.indexOf(item);
            int itemId = itemList.get(itemIndex).getId();
            int itemQtt = -itemList.get(itemIndex).getQtt();
            Stock.updateStock(itemId, itemQtt);
        });
    }
}
