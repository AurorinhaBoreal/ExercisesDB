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
            System.err.println("O ID do Produto é inválido! \nVoltando para o ínicio...");
            choice();
        }

        System.out.println("Quantas unidades deseja comprar?");
        int quantityProduct = scanner.nextInt();

        calcPrice(chosenProduct, quantityProduct);

        System.out.println("Compra Finalizada!");
       
    }

    private void calcPrice(int chosenProduct, int quantityProduct) {
        int discountPercentage;
        float totalPrice;

        if (quantityProduct > 10) discountPercentage = 10;
        else if (quantityProduct > 20) discountPercentage = 20;
        else discountPercentage = 50;

        float priceProduct = products.get(chosenProduct).price;
        totalPrice = (quantityProduct * priceProduct) * ((100 - discountPercentage)/100);
        System.out.println( ((100 - discountPercentage)/100));

        System.out.println(String.format("Comprando %d unidades do item %s, o valor total será R$%e", quantityProduct, products.get(chosenProduct).name, totalPrice));
        System.out.println("Confirma sua compra? S/N");

        String purchaseConfirmation = scanner.nextLine();

        if (purchaseConfirmation == "S") System.out.println("Compra finalizada!");
        else if (purchaseConfirmation == "N")  {
            System.out.println("Compra Cancelada. \nVoltando para o Ínicio...");
            choice();
        }
        else {
            System.out.println("Respota Inválida. Cancelando e voltando ao Ínicio..."); 
            choice();
        }
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
