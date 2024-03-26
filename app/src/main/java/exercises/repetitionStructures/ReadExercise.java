package exercises.repetitionStructures;

import java.util.Scanner;

public class ReadExercise {
    Scanner scanner = new Scanner(System.in);
    int number;
    int i;
    public void showNumber() {
        System.out.println("Digite um numero ai!");
        while (number != 10) {
            number = scanner.nextInt();
        System.out.println("Um passarinho me contou que você digitou o número "+number+"!");
        }
        System.out.println("Você descobriu que numero secreto era 10! Parabens!");
    }
}
