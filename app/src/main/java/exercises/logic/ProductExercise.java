package exercises.logic;

import java.util.ArrayList;
import java.util.Scanner;

// EU VOU REFATORAR!! PROMETO MATHEUS!!!
public class ProductExercise {
    
    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void productArray() {
        products.add(new Product(1, "Batata", 20f));
        products.add(new Product(2, "Boneca", 32.80f));
        products.add(new Product(3, "Caneca", 8.40f));
        choice();
    }
    
    public void choice() {
        System.out.println("O que você quer fazer?");
        System.out.println("1 - Adicionar Produto \t 2 - Comprar Produto \t 3 - Sair");
        int chosenAction = scanner.nextInt();

        switch (chosenAction) {
            case 1:
                addProduct();
                break;
            case 2:
                buyProduct();
                break;
            case 3:
                System.out.println("Tchau tchau!");
                break;
    
            default:
                System.err.println("Ação Inválida!");
                break;
        }
    }
    
    private void buyProduct() {
        System.out.println("LISTA DE PRODUTOS:");
        for (Product product: products) {
            System.out.println(product.toString());
        }
        System.out.println("Insira o ID do produto que deseja comprar:");

        int chosenProduct = (scanner.nextInt() - 1);
        
        try {
            System.out.println(products.get(chosenProduct));
        } catch (Exception e) {
            System.err.println(String.format("O ID %d é inválido! \nVoltando para o ínicio...", chosenProduct));
            choice();
        }

        System.out.println("Quantas unidades deseja comprar?");
        int quantityProduct = scanner.nextInt();
        
        // Captura o próximo espaço que é lançado ao final do scanner.nextInt
        // Dessa forma, não vai permitir que o scanner.nextLine capture 
        // o espaço como String vazia
        scanner.nextLine();

        double totalPrice = calcPrice(chosenProduct, quantityProduct);
        String purchaseConfirmation;

        System.out.println(String.format("Comprando %d unidades do item %s, o valor total será R$%.2f", quantityProduct, products.get(chosenProduct).name, totalPrice));
        System.out.println("Confirma sua compra? S/N");

        purchaseConfirmation = scanner.nextLine();

        if (purchaseConfirmation.equals("S")) {
            System.out.println("Compra finalizada!");
        }
        else if (purchaseConfirmation.equals("N"))  {
            System.out.println("Compra Cancelada.");
        }
       
        System.out.println("Voltando para o Ínicio...");
        choice();
    }

    private double calcPrice(int chosenProduct, int quantityProduct) {
        double discountPercentage;
        double totalPrice;

        if (quantityProduct > 10) discountPercentage = 10;
        else if (quantityProduct > 20) discountPercentage = 20;
        else discountPercentage = 25;

        double priceProduct = products.get(chosenProduct).price;
        totalPrice = (quantityProduct * priceProduct) * ((100 - discountPercentage)/100);

        return totalPrice;
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

        @Override
        public String toString() {
            return this.productID+" - "+this.name+" |\t R$"+this.price;
        }
    }
}
