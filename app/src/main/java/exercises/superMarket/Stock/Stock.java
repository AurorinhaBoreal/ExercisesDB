package exercises.superMarket.Stock;

import java.util.ArrayList;

import exercises.superMarket.Product;
public class Stock {
    static private int id = 1;
    static protected ArrayList<Product> productsList = new ArrayList<>();

    public static void startStock() {
        productsList.add(new Product(productsList.size()+1, "Cadeira", 70.65, 30));
        productsList.add(new Product(productsList.size()+1, "Mesa", 145.60, 10));
        productsList.add(new Product(productsList.size()+1, "Porta", 110.90, 18));
        productsList.add(new Product(productsList.size()+1, "Sofá", 270.30, 12));
        productsList.add(new Product(productsList.size()+1, "Armário", 137.55, 24));
    }

    public static Product findProduct(String name) {
        int[] productFounded = {-1};
        productsList.forEach((product) -> {
            if ((productsList.get(productsList.indexOf(product)).getName()).equals(name)) {
                productFounded[0] = productsList.indexOf(product);
            }
        });
        return productsList.get(productFounded[0]);
    }

    public static Product findProduct(int id) {
        int[] productFounded = {-1};
        productsList.forEach((product) -> {
            if ((productsList.get(productsList.indexOf(product)).getId()) == id) {
                productFounded[0] = productsList.indexOf(product);
            }
        });
        return productsList.get(productFounded[0]);
    }

    public static boolean registerProduct(Product product) {
        boolean registerVerify;

        try {
            productsList.add(product);
            registerVerify = true;
        } catch (Exception e) {
            registerVerify = false;
        }
        
        return registerVerify;
    }

    public static void showStockCatalog() {
        System.out.println("Stock ID: "+id);
        System.out.println("|---------|");
        productsList.forEach((product) -> {
            System.out.println("| "+product.getName()+" |");
        });
        System.out.println("|---------|");
    }

    public boolean updateStock(String name, int qtt) {
        boolean updateVerify;
        int productIndex[] = {0};
        productsList.forEach((product) -> {
            if ((productsList.get(productsList.indexOf(product)).getName()).equals(name)) {
                productIndex[0] = productsList.indexOf(product);
            }
        });

        try {
            productsList.get(productIndex[0]).stockUpdate(qtt);
            updateVerify = true;
        } catch (Exception e) {
            updateVerify = false;
        }
        return updateVerify;
    }

    public boolean updateStock(int id, int qtt) {
        boolean updateVerify;
        int productIndex[] = {0};
        productsList.forEach((product) -> {
            if ((productsList.get(productsList.indexOf(product)).getId()) == id) {
                productIndex[0] = productsList.indexOf(product);
            }
        });

        try {
            productsList.get(productIndex[0]).stockUpdate(qtt);
            updateVerify = true;
        } catch (Exception e) {
            updateVerify = false;
        }
        return updateVerify;
    }

    public int stockLatestQtt(Product product) {
        int productQtt = 0;

        return productQtt;
    }

    public int productListPosition(Product product) {
        int prodIndex;
        prodIndex = productsList.indexOf(product);
        return prodIndex;
    }

    public boolean hasStock(Product product, int qtt) {
        boolean stockVerify;
        int prodIndex;
        prodIndex = productsList.indexOf(product);

        if (productsList.get(prodIndex).getStock() <= qtt) stockVerify = false;
        else {
            productsList.get(prodIndex).stockUpdate(qtt);
            stockVerify = true;
        }

        return stockVerify;
    }

    public void getStock() {
        System.out.println("ID do Estoque: "+this.id);
        productsList.forEach((prod) -> {
            System.out.println(productsList.get(productsList.indexOf(prod)).getProduct());
        });
    }
}
