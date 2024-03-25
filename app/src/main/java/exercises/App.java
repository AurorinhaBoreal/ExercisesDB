package exercises;


import java.util.Scanner;
import exercises.logic.*;

public class App {
    
    public static void main(String[] args) {
        int exercise;
        Scanner sExercise = new Scanner(System.in);

        System.out.println("Escolha o exercicio que deseja executar:");
        System.out.printf("1 - Age \t 2 - Product \t 3 - Jokenpo \t 4 - Calculadora");

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
            default:
                System.out.println("Esse não é um exercicio válido.");
                break;
        }
        sExercise.close();
    }
}
