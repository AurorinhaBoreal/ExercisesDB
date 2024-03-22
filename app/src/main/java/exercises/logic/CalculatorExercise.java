package exercises.logic;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorExercise {
    char calculation;
    ArrayList<Integer> numbers = new ArrayList();
    Scanner scanner = new Scanner(System.in);

    public void chooseCalc() {
        System.out.println("Qual calculo deseja fazer? \n");
        System.out.println("A - Adição (+) | S - Subtração (-) | D - Divisão (÷) |");
        System.out.println("M - Multiplicação (x) | R - Radiciação (√) | P - Potenciação (^) |");

        calculation = scanner.nextLine().charAt(0);

        getNumbers();

        switch (calculation) {
            case 'A':
                
                break;
            case 'S':
                
                break;
            case 'D':
                
                break;
            case 'M':
                
                break;
            case 'R':
                
                break;
            case 'P':
                
                break;
            default:
                System.out.println("Caractere inválido.");
                chooseCalc();
                break;
        }
    }

    private void getNumbers() {
        
        System.out.println("Informe 2 números para o cálculo:");

        for (int i = 0; i < 2; i++) {
            int number = scanner.nextInt();
            numbers.add(number);
        }

        System.out.println(numbers.toString());
    }
    private void Addition() {

    }

    private void Subtraction() {
        
    }

    private void Division() {
        
    }

    private void Multiplication() {
        
    }

    private void Potentiation() {
        
    }

    private void Rooting() {
        
    }
}
