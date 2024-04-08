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
        System.out.println("| 1 - Adicionar Item \t 2 - Mostrar Pedido \n"+
        " 3 - Mostrar Valor Total \t 4 - Fechar Pedido \n"+
        " 5 - Limpar Carrinho \t 6 - Retornar ");
        
        orderAction = scanner.nextInt();

        orderCase(orderAction);
    }

    private void orderCase(int orderAction) {
        switch (orderAction) {
            case 1:
                addItem();
                orderMenu();
                break;
            case 2:
                printOrder();
                orderMenu();
                break;
            case 3:
                printTotalValue();
                orderMenu();
                break;
            case 4:
                closeOrder();
                orderMenu();
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

    private void addItem() {
        int prodID;
        Product prod;
        int itemQtt;
        double itemValue;
        boolean addVerify;
        System.out.println("Para adicionar o Item insira as informações:");
        Stock.showCatalog();
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

    private void printOrder() {
        String message;
        message = Order.getOrder();

        System.out.println(message);
    }

    private void printTotalValue() {
        String message;
        message = Order.showTotalOrderValue();

        System.out.println(message);
    }

    private void closeOrder() {
        int userAnswer;
        double payment;
        double change = 666; // ₒ ₜᵣₒ𝒸ₒ ₘₐₗᵢ𝓰ₙₒ
        System.out.println("Seu pedido atual é: \n");
        printOrder();
        System.out.println("\nDeseja fechar o pedido e proceder para o pagamento? \n1 - Sim | 2 - Não");

        userAnswer = scanner.nextInt();

        if (userAnswer == 1) {
            System.out.println("Certo! Informe quanto irá entregar em dinheiro:");
            payment = scanner.nextDouble();
            paymentProcess(payment, change);
        } else {
            System.out.println("Okkay.");
        }
    }

    public void paymentProcess(double payment, double change) {
        String[] possibleStatus = {"Dinheiro entregue insuficiente. Passa mais ai!", "Pagamento efetuado com sucesso!"};
        String paymentStatus;
        double totalPrice = Order.showTotalValue();

        if (payment < totalPrice) paymentStatus = possibleStatus[0];
        else if (payment == totalPrice) {
            System.out.println("Você não deu dinheiro a mais! Por isso, sem troco!");
            paymentStatus = possibleStatus[1];
        } else {
            change = (payment - totalPrice);
            System.out.println(String.format("O seu troco vai ser de: %.2f", change));
            paymentStatus = possibleStatus[1];
            Order.stockRemoval();
            Order.clearCart();
        }
        System.out.println(paymentStatus);
    }
}
