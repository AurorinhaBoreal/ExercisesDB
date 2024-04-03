package exercises.superMarket.Order;

import java.util.Scanner;

public class OrderMenu {
    Scanner scanner = new Scanner(System.in);
    public void orderMenu() {
        int orderAction;
        System.out.println("Escolha a ação desejada:");

        orderAction = scanner.nextInt();
    }

    private void orderCase(int orderAction) {
        switch (orderAction) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }
}
