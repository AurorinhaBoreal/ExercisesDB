package exercises;


import java.util.Scanner;
import exercises.logic.AgeExercise;
import exercises.logic.ProductExercise;

public class App {
    
    public static void main(String[] args) {
        String exercise;
        Scanner sExercise = new Scanner(System.in);

        System.out.println("Escolha o exercicio que deseja executar:");
        System.out.printf("1 - Age \t 2 - Product");

        exercise = sExercise.nextLine();
        switch (exercise) {
            case "1":
                System.out.println("Você escolheu o exercicio Age...");
                AgeExercise idade = new AgeExercise();
                idade.VerifyingAge();
                break;
            case "2":
                System.out.println("Você escolheu o exercicio Product...");
                ProductExercise produto = new ProductExercise();
                produto.productArray();
                break;

            default:
                System.out.println("Esse não é um exercicio válido.");
                break;
        }
        sExercise.close();
    }
}
