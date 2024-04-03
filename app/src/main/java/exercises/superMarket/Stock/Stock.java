package exercises.superMarket.Stock;

import java.util.ArrayList;

import exercises.superMarket.Product;
public class Stock {
    private int id = 1;
    private ArrayList<Product> productsList = new ArrayList<>();

    public void startStock() {

    }

    public Product findProduct(String name) {
        int[] productFounded = {-1};
        productsList.forEach((product) -> {
            if ((productsList.get(productsList.indexOf(product)).getName()).equals(name)) {
                productFounded[0] = productsList.indexOf(product);
            }
        });
        return productsList.get(productFounded[0]);
    }

    public Product findProduct(int id) {
        int[] productFounded = {-1};
        productsList.forEach((product) -> {
            if ((productsList.get(productsList.indexOf(product)).getId()) == id) {
                productFounded[0] = productsList.indexOf(product);
            }
        });
        return productsList.get(productFounded[0]);
    }

    // public boolean registerProduct(Product product) {
    //     boolean registerVerify;
    //     if (registerVerify) registerVerify = true;
    //     else registerVerify = false;
    //     return registerVerify;
    // }

    public void showStockCatalog() {
        System.out.println("Stock ID:"+this.id);
        productsList.forEach((product) -> {
            System.out.println(product.getName());
        });
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
