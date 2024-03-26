package exercises.repetitionStructures;

import java.util.Scanner;

// REFAZER LÓGICA CASO SOBRE TEMPO
public class FibonacciLimitExercise {
    Scanner scanner = new Scanner(System.in);
    int[] fibonacciArray = {0,1};
    int fibonacciSum;
    boolean fibonacciStop = false;
    int fibonacciEnd;
    public void FibonacciCalculation() {
        getEnd();
        System.out.printf("A sequência de Fibonacci que para anytes do número"+fibonacciEnd+" é a seguinte: \n[ 0");
        calculatingSequence();
    }

    private void getEnd() {
        System.out.println("Informe até qual número a sequência deve ir:");
        fibonacciEnd = scanner.nextInt();
    }

    private void calculatingSequence() {
        System.out.printf(" | "+fibonacciArray[1]);
        while (fibonacciStop == false) {
            stopFibonacci();
            if (fibonacciStop == false) {
                fibonacciArray[0] = fibonacciArray[0] + fibonacciArray[1];
                System.out.printf(" | "+fibonacciArray[0]);
            }
            stopFibonacci();
            if (fibonacciStop == false) {
                fibonacciArray[1] = fibonacciArray[0] + fibonacciArray[1];
                System.out.printf(" | "+fibonacciArray[1]);
            }
            stopFibonacci();
        }
        System.out.printf(" ]");
    }

    private void stopFibonacci() {
        fibonacciSum = fibonacciArray[0] + fibonacciArray[1];
        if (fibonacciSum > fibonacciEnd || fibonacciSum > fibonacciEnd) fibonacciStop = true;
    }
}
