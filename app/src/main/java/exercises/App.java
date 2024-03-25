package exercises;


import java.util.Scanner;

import exercises.logic.*;

public class App {
    
    public static void main(String[] args) {
        int exercise;
        Scanner sExercise = new Scanner(System.in);

        System.out.println("Escolha o exercicio que deseja executar:");
        System.out.printf("1 - Idade \t 2 - Produto \t 3 - Jokenpo \t 4 - Calculadora \t 5 - Tabuada\n");
    System.out.println("6 - Numeros Aleatórios");

        exercise = sExercise.nextInt();
        switch (exercise) {
            case 1:
                System.out.println("Você escolheu o exercicio Age...");
                AgeExercise idade = new AgeExercise();
                idade.VerifyingAge();
                break;
            case 2:
                System.out.println("Você escolheu o exercicio Product...");
                ProductExercise produto = new ProductExercise();
                produto.productArray();
                break;
            case 3:
                System.out.println("Você escolheu o exercicio Jokenpo...");
                JokenpoExercise jokenpo = new JokenpoExercise();
                jokenpo.game();
                break;
            case 4:
                System.out.println("Você escolheu o exercicio Calculadora...");
                CalculatorExercise calculator = new CalculatorExercise();
                calculator.chooseCalc();
                break;
            case 5:
                System.out.println("Você escolheu o exercicio Tabuada...");
                MultiplicationExercise multiplication = new MultiplicationExercise();
                multiplication.choosingNumber();
                break;
            case 6:
                System.out.println("Você escolheu o exercicio Números Aleatórios...");
                RandomExercise random = new RandomExercise();
                random.randomNumbers();
                break;
            default:
                System.out.println("Esse não é um exercicio válido.");
                break;
        }
        sExercise.close();
    }
}
