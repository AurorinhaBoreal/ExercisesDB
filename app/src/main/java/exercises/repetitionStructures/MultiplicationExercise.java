package exercises.repetitionStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiplicationExercise {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> results = new ArrayList<>();
    int multiplicand;
    public void choosingNumber() {
        System.out.println("Quer calcular a tabuada de qual numero?");
        multiplicand = scanner.nextInt();
        Multiplication(multiplicand);
        CreatingTable(results, multiplicand);
    }

    private void Multiplication(int multiplicand) {
        for (int i = 1; i <= 100; i++) {
            results.add(multiplicand*i);
        }
    }

    private void CreatingTable(ArrayList<Integer> results, int multiplicand) {
        int remainder;
        System.out.printf("||================>\n||");
        for (int i = 1; i <= results.size(); i++) {
            remainder = i%5;
            System.out.printf(String.format(" %d x %d = %d |", i, multiplicand, results.get(i-1)));
            if (remainder == 0) System.out.printf("\n||");
        }
        System.out.println("================>");
    }
}
