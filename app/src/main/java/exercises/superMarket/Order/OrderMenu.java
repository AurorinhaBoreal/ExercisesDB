package exercises.superMarket.Order;

import java.util.Scanner;

import exercises.superMarket.Product;
import exercises.superMarket.Stock.Stock;

public class OrderMenu {
    Scanner scanner = new Scanner(System.in);
    public void orderMenu() {
        int orderAction;
        System.out.println("Escolha a ação desejada:");
        System.out.println("| 1 - Calcular Valor \t 2 - Adicionar Item \n"+
        " 3 - Mostrar Pedido \t 4 - Mostrar Valor Total ");
        
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
                // addItem();
                orderMenu();
                break;
            case 3:
                
                orderMenu();
                break;
            case 4:
                
                orderMenu();
                break;
            default:
                System.out.println("Opção Inválida");
                orderMenu();
        }
    }
}
