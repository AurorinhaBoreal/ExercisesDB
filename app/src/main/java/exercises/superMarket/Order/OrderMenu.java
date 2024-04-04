package exercises.superMarket.Order;

import java.util.Scanner;

import exercises.superMarket.Menu;
import exercises.superMarket.Product;
import exercises.superMarket.Stock.Stock;

public class OrderMenu {
    Scanner scanner = new Scanner(System.in);
    public void orderMenu() {
        int orderAction;
        System.out.println("Escolha a ação desejada:");
        System.out.println("| 1 - Calcular Valor \t 2 - Adicionar Item \n"+
        " 3 - Mostrar Pedido \t 4 - Mostrar Valor Total \n"+
        " 5 - Limpar Carrinho \t 6 - Retornar ");
        
        orderAction = scanner.nextInt();

        orderCase(orderAction);
    }

    private void orderCase(int orderAction) {
        switch (orderAction) {
            case 1:
                Order.calcTotalValue();
                orderMenu();
                break;
            case 2:
                addItem();
                orderMenu();
                break;
            case 3:
                printOrder();
                orderMenu();
                break;
            case 4:
                printTotalValue();
                orderMenu();
                break;
            case 5:
                Order.clearCart();
                orderMenu();
            case 6:
                Menu menu = new Menu();
                menu.menuController();
                break;
            default:
                System.out.println("Opção Inválida");
                orderMenu();
        }
    }

    public void addItem() {
        int prodID;
        Product prod;
        int itemQtt;
        double itemValue;
        boolean addVerify;
        System.out.println("Para adicionar o Item insira as informações:");
        Stock.showStockCatalog();
        System.out.println("Informe o ID do produto para ser inserido:");
        prodID = scanner.nextInt();

        prod = Stock.findProduct(prodID);

        System.out.println("Informe a quantidade do item desejados:");
        itemQtt = scanner.nextInt();

        itemValue = prod.getPrice();

        addVerify = Order.addItem(prod, itemQtt, itemValue);

        String message = (addVerify == true ? "O item foi inserido no pedido" : "Algo deu errado, verifique as informações inseridas!");

        System.out.println(message);
    }

    public void printOrder() {
        String message;
        message = Order.getOrder();

        System.out.println(message);
    }

    public void printTotalValue() {
        String message;
        message = Order.getTotalOrderValue();

        System.out.println(message);
    }
}
