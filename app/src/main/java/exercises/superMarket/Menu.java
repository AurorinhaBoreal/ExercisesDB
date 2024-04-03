package exercises.superMarket;

import java.util.Scanner;

import exercises.superMarket.Order.OrderMenu;
import exercises.superMarket.Stock.StockMenu;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void menuController() {
        int action;
        System.out.println("Olá, bem vindo ao Super Mercado Estelar! Escolha a categoria de ações que deseja fazer?");
        System.out.println("1 - Estoque | 2 - Pedido");

        action = scanner.nextInt();

        menuCase(action);
    }

    private void menuCase(int action) {
        switch (action) {
            case 1:
                StockMenu sm = new StockMenu();
                sm.startStock();
                break;
            case 2:
                OrderMenu om = new OrderMenu();
                om.orderMenu();
                break;
            default:
                break;
        }
    }
    
}
