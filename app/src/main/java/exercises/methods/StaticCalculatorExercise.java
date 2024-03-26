package exercises.methods;

import java.util.Scanner;

// VOLTAR E REVISAR MÉTODOS E VARIAVEIS ESTÁTICAS
public class StaticCalculatorExercise {
    static String calculation;
    static int n1, n2;
    static double result;
    public static void chooseCalc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual calculo deseja fazer? \n");
        System.out.println("A - Adição (+) | S - Subtração (-) | D - Divisão (÷) |");
        System.out.println("M - Multiplicação (x) | P - Potenciação (^) |");

        calculation = scanner.nextLine().toUpperCase();

        getNumbers(scanner);
        System.out.println(n1+", "+n2);

        switch (calculation) {
            case "A":
                result = Addition(n1, n2);
                System.out.println("O resultado de "+n1+" + "+n2+" é "+result);
                break;
            case "S":
                result = Subtraction(n1, n2);
                System.out.println("O resultado de "+n1+" - "+n2+" é "+result);

                break;
            case "D":
                result = Division(n1, n2);
                System.out.println("O resultado de "+n1+" ÷ "+n2+" é "+result);

                break;
            case "M":
                result = Multiplication(n1, n2);
                System.out.println("O resultado de "+n1+" x "+n2+" é "+result);
                break;
            case "P":
                result = Potentiation(n1, n2);
                System.out.println("O resultado de "+n1+" elevado à "+n2+" é "+result);
                break;
            default:
                System.out.println("Caractere inválido.");
                chooseCalc();
                break;
        }
    }

    private static void getNumbers(Scanner scanner) {
        
        System.out.println("Informe o 1° número para o cálculo:");
        n1 = scanner.nextInt();
        System.out.println("Informe o 2° número para o cálculo:");
        n2 = scanner.nextInt();        
    }

    private static double Addition(int n1, int n2) {
        double result;

        result = n1 + n2;

        return result;
    }

    private static double Subtraction(int n1, int n2) {
        double result;

        result = n1 - n2;
        return result;
    }

    private static double Division(int n1, int n2) {
        double result;

        result = n1 / n2;
        return result;
    }

    private static double Multiplication(int n1, int n2) {
        double result;

        result = n1 * n2;
        return result;
    }

    private static double Potentiation(int n1, int n2) {
        double result;

        result = Math.pow(n1, n2);
        return result;
    }
}
