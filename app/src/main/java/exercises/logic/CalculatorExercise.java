package exercises.logic;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorExercise {
    double result;
    char calculation;
    ArrayList<Double> numbers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void chooseCalc() {
        System.out.println("Qual calculo deseja fazer? \n");
        System.out.println("A - Adição (+) | S - Subtração (-) | D - Divisão (÷) |");
        System.out.println("M - Multiplicação (x) | R - Radiciação (√) | P - Potenciação (^) |");

        calculation = scanner.nextLine().charAt(0);

        switch (calculation) {
            case 'A':
                getNumbers();
                result = Addition(numbers);
                System.out.println("O resultado de "+numbers.get(0)+" + "+numbers.get(1)+" é "+result);
                break;
            case 'S':
                getNumbers();
                result = Subtraction(numbers);
                System.out.println("O resultado de "+numbers.get(0)+" - "+numbers.get(1)+" é "+result);

                break;
            case 'D':
                getNumbers();
                result = Division(numbers);
                System.out.println("O resultado de "+numbers.get(0)+" ÷ "+numbers.get(1)+" é "+result);

                break;
            case 'M':
                getNumbers();
                result = Multiplication(numbers);
                System.out.println("O resultado de "+numbers.get(0)+" x "+numbers.get(1)+" é "+result);
                break;
            case 'R':
                getNumberRoot();
                result = Rooting(numbers);
                System.out.println("O resultado de "+numbers.get(0)+" + "+numbers.get(1)+" é "+result);
                break;
            case 'P':
                getNumbers();
                result = Potentiation(numbers);
                System.out.println("O resultado de "+numbers.get(0)+" elevado à "+numbers.get(1)+" é "+result);
                break;
            default:
                System.out.println("Caractere inválido.");
                chooseCalc();
                break;
        }
    }

    private void getNumberRoot() {
        System.out.println("Informe o número para o cálculo:");

        double number = scanner.nextInt();
        numbers.add(0, number);

        System.out.println(numbers);
    }
    
    private void getNumbers() {
        
        System.out.println("Informe 2 números para o cálculo:");

        for (int i = 0; i < 2; i++) {
            double number = scanner.nextInt();
            numbers.add(i, number);
        }

        System.out.println(numbers.toString());
    }

    private double Addition(ArrayList<Double> numbers) {
        double result;

        result = numbers.get(0) + numbers.get(1);
        return result;
    }

    private double Subtraction(ArrayList<Double> numbers) {
        double result;

        result = numbers.get(0) - numbers.get(1);
        return result;
    }

    private double Division(ArrayList<Double> numbers) {
        double result;

        result = numbers.get(0) / numbers.get(1);
        return result;
    }

    private double Multiplication(ArrayList<Double> numbers) {
        double result;

        result = numbers.get(0) * numbers.get(1);
        return result;
    }

    private double Potentiation(ArrayList<Double> numbers) {
        double result;

        result = Math.pow(numbers.get(0), numbers.get(1));
        return result;
    }

    private double Rooting(ArrayList<Double> numbers) {
        double result;

        result = Math.sqrt(numbers.get(0));
        return result;
    }
}
