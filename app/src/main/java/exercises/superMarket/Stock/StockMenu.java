package exercises.superMarket.Stock;

import java.util.Scanner;

import exercises.logic.ProductExercise.Product;

public class StockMenu {
    public void stockMenu(Scanner scanner) {
        Stock.startStock();
        int stockAction;
        System.out.println("Escolha a ação desejada:");
        System.out.println("| 1 - Encontrar Produto \t 2 - Cadastrar Produto \t 3 - Mostrar Estoque \n"+
        "4 - Atualizar Estoque \t 5 - Estoque de Produto \t 6 - Posição do Produto "+
        "\n7 - Possui Estoque?");
        
        stockAction = scanner.nextInt();
        scanner.nextLine();
        // Captura Nova Linha

        stockCase(stockAction, scanner);
    }
    
    private void stockCase(int stockAction, Scanner scanner) {
        switch (stockAction) {
            case 1:
                findProduct(scanner);                
                break;
            case 2:
                addProduct(scanner);
            default:
                break;
        }
    }

    private void findProduct(Scanner scanner) {
        String searchProduct;
        String nameProduct;
        int idProduct;
        System.out.println("Insira o nome ou ID do Produto que deseja encontrar:");

        searchProduct = scanner.nextLine();

        boolean isName = nameVerify(searchProduct);

        if (isName == true) {
            nameProduct = searchProduct;
            System.out.println(Stock.findProduct(nameProduct).getProduct());
        } else {
            idProduct = Integer.valueOf(searchProduct);
            System.out.println(Stock.findProduct(idProduct).getProduct());
        }
    }

    private boolean nameVerify(String searchProduct) {
        char firstChar;
        firstChar = searchProduct.charAt(0);

        if (Character.isDigit(firstChar)) return false;
        return true;
    }

    private void addProduct(Scanner scanner) {
        System.out.println("Insira as informações para cadastro do Produto:");

        Product prod = getProduct(scanner);
    }

    private Product getProduct(Scanner scanner) {
        Product prod;
        int id = Stock.productsList.size()+1;
        String name;
        double price;
        int stockQtt;

        System.out.printf("Informe o nome do produto:");
        name = scanner.nextLine();
        System.out.printf("Informe o preço do produto:");
        price = scanner.nextDouble();
        System.out.printf("Informe a quantidade do produto em estoque:");
        stockQtt = scanner.nextInt();

        prod = new Product(id, name, price, stockQtt);
    }
}
