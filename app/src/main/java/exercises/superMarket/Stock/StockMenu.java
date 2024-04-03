package exercises.superMarket.Stock;

import java.util.Scanner;

public class StockMenu {
    public void stockMenu(Scanner scanner) {
        int stockAction;
        System.out.println("Escolha a ação desejada:");
        System.out.println("| 1 - Encontrar Produto \t 2 - Cadastrar Produto \t 3 - Mostrar Estoque \n"+
        "4 - Atualizar Estoque \t 5 - Estoque de Produto \t 6 - Posição do Produto "+
        "\n7 - Possui Estoque?");
        
        stockAction = scanner.nextInt();
        stockCase(stockAction);
    }
    
    private void stockCase(int stockAction) {
        switch (stockAction) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }
}
