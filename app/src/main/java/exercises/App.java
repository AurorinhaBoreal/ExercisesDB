import exercises.logic.Age;
import java.util.Scanner;


public class App {
    
    public static void main(String[] args) {
        String exercise;
        Scanner sExercise = new Scanner(System.in);

        System.out.println("Escolha o exercicio que deseja executar:");
        System.out.printf("1 - Age");

        exercise = sExercise.nextLine();
        switch (exercise) {
            case "1":
                System.out.println("Você escolheu o exercicio 1...");
                Age idade = new Age();
                break;
        
            default:
                break;
        }
    }
}
