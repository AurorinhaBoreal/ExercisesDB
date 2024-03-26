package exercises.repetitionStructures;

import java.util.Scanner;

public class FibonacciExercise {
    Scanner scanner = new Scanner(System.in);
    int[] fibonacciArray = {0,1};
    int fibonacciEnd;
    public void FibonacciCalculation() {
        getEnd();
        System.out.printf("A sequência de Fibonacci com "+fibonacciEnd+" números é a seguinte: \n[ 0");
        calculatingSequence();
    }

    private void getEnd() {
        System.out.println("Informe quantos digitos de Fibonacci deseja calcular:");
        fibonacciEnd = scanner.nextInt();
    }

    private void calculatingSequence() {
        for (int i = 0; i < fibonacciEnd; i++) {
            if (i%2 != 0) {
                fibonacciArray[0] = fibonacciArray[0] + fibonacciArray[1];
                System.out.printf(" | "+fibonacciArray[0]);
            } else {
                fibonacciArray[1] = fibonacciArray[0] + fibonacciArray[1];
                System.out.printf(" | "+fibonacciArray[1]);
            }
        }
        System.out.printf(" ]");
    }
}