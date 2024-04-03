package exercises.superMarket.Stock;

import java.util.Scanner;

import exercises.superMarket.Product;

public class StockMenu {
    Scanner scanner = new Scanner(System.in);
    public void stockMenu() {
        Stock.startStock();
        int stockAction;
        System.out.println("Escolha a ação desejada:");
        System.out.println("| 1 - Encontrar Produto \t 2 - Cadastrar Produto \t 3 - Mostrar Estoque \n"+
        "4 - Atualizar Estoque \t 5 - Estoque de Produto \t 6 - Posição do Produto "+
        "\n7 - Possui Estoque?");
        
        stockAction = scanner.nextInt();
        scanner.nextLine();
        // Captura Nova Linha

        stockCase(stockAction);
    }
    
    private void stockCase(int stockAction) {
        switch (stockAction) {
            case 1:
                findProduct();   
                stockMenu();             
                break;
            case 2:
                addProduct();
                stockMenu();
            case 3:
                showStock();
                stockMenu();
                break;
            default:
            
        }
    }

    private void findProduct() {
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

    private void addProduct() {
        boolean addVerify;
        System.out.println("Insira as informações para cadastro do Produto:");

        Product prod = getProduct();
        addVerify = Stock.registerProduct(prod);

        if (addVerify == true) System.out.println("O Produto foi registrado com sucosse!");
        else System.out.println("Falha no registro, verifique o terminal e tente novamente!");
    }

    private Product getProduct() {
        int id = Stock.productsList.size()+1;
        String name;
        double price;
        int stockQtt;

        System.out.println("Informe o nome do produto:");
        name = scanner.nextLine();
        System.out.println("Informe o preço do produto:");
        price = scanner.nextDouble();
        System.out.println("Informe a quantidade do produto em estoque:");
        stockQtt = scanner.nextInt();

        Product prod = new Product(id, name, price, stockQtt);
        return prod;
    }

    private void showStock() {
        Stock.showStockCatalog();
    }


}
