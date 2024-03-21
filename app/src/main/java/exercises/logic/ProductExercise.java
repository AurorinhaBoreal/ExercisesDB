package exercises.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductExercise {
    
    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void choice() {
        products.add(new Product(1, "Batata", 20f));
        products.add(new Product(2, "Doll", 32.80f));
        products.add(new Product(3, "Jigsaw Puzzle", 38.40f));
        System.out.println("O que você quer fazer?");
        System.err.println(products);
        System.out.println("1 - Adicionar Produto \t 2 - Comprar Produto");
    }
    
    private void buyProduct() {
        System.out.println("Qual produto deseja comprar:");
        for (Product product: products) {
            System.out.println(product.productID+" | "+product.name+"\t"+product.price);
        }
        switch (products) {
            case value:
                
                break;
        
            default:
                break;
        }



        // createProduct prod1 = new createProduct();
        // prod1.setProduct("Batata", 30.50f);
        // System.out.println("Quantos produtos você quer adicionar?");
        // int p = scanner.nextInt();

        // for (int i = 0; i < p; i++) {
        //     listTest.add(prod1);
        //     System.out.println("Added");
        // }
        // System.out.println(listTest.toString().format("O objeto é %s seu preço é %e", listTest[]));
    }

    private void addProduct() {

    }

    public class Product {
        private int productID;
        private String name;
        private float price;

        public Product(int productID, String name, float price) {
            this.productID = productID;
            this.name = name;
            this.price = price;
        }
        public String getProduct() {
            return "O produto "+this.name+" custa R$"+this.price;
        }

        public void setProduct(String newName, float newPrice) {
            this.name = newName;
            this.price = newPrice;
        }
    }
}
