package exercises.superMarket.Stock;

import java.util.Scanner;

import exercises.superMarket.Product;

public class StockMenu {
    Scanner scanner = new Scanner(System.in);
    public void startStock() {
        Stock.startStock();
        stockMenu();
    }

    public void stockMenu() {
        int stockAction;
        System.out.println("Escolha a ação desejada:");
        System.out.println("| 1 - Encontrar Produto \t 2 - Cadastrar Produto \t 3 - Mostrar Catálogo \n"+
        "4 - Atualizar Estoque \t 5 - Estoque de Produto \t 6 - Posição do Produto ");
        
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
                break;
            case 3:
                showCatalog();
                stockMenu();
                break;
            case 4:
                stockUpdate();
                stockMenu();
                break;
            case 5:
                getProductStock();
                stockMenu();
                break;
            case 6:
                productPosition();
                stockMenu();
                break;
            default:
                System.out.println("Opção Inválida");
                stockMenu();
            
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

        Product prod = setProduct();
        addVerify = Stock.registerProduct(prod);

        if (addVerify == true) System.out.println("O Produto foi registrado com sucosse!");
        else System.out.println("Falha no registro, verifique o terminal e tente novamente!");
    }

    private Product setProduct() {
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

    private void showCatalog() {
        Stock.showStockCatalog();
    }

    private void stockUpdate() {
        Product product;
        String prodTemp;
        String prodName;
        int prodId;
        int qttUpdate;
        Stock.showStockCatalog();
        System.out.println("Informe o Nome ou ID do produto que deseja atualizar o estoque:");
        prodTemp = scanner.nextLine();
        System.out.println("Informe a quantidade de items que quer adicionar ou quer remover:");
        qttUpdate = scanner.nextInt();
        scanner.nextLine();
        // Captura a linha

        boolean isName = nameVerify(prodTemp);

        if (isName == true) {
            prodName = prodTemp;
            product = Stock.findProduct(prodName);
        } else {
            prodId = Integer.valueOf(prodTemp);
            product = Stock.findProduct(prodId);
        }

        boolean updateVerify = Stock.hasStock(product, qttUpdate);

        String statusMessage = (updateVerify == true ? "O estoque foi atualizado" : "Verifique o estoque do produto e tente novamente!");

        System.out.println(statusMessage);
    }

    private void getProductStock() {
        int prodId;
        Product prod;
        int prodStock;
        Stock.showStockCatalog();
        System.out.println("Informe o ID do Produto que deseja checar o Estoque:");
        prodId = scanner.nextInt();

        prod = Stock.findProduct(prodId);
        prodStock = Stock.stockLatestQtt(prod);

        System.out.println("| Produto: "+prod.getName()+" | Estoque: "+prodStock);
    }

    private void productPosition() {
        Product prod;
        String prodName;
        Stock.showStockCatalog();
        System.out.println("Informe o Nome do produto que você deseja ver a posição:");
        prodName = scanner.nextLine();
        prod = Stock.findProduct(prodName);

        System.out.println("A posição do produto "+prod.getName()+" é: "+Stock.productsList.indexOf(prod));

    }
}
