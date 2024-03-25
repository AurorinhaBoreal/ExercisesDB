package exercises.logic;

import java.util.Random;

public class MatrixSumExercise {
    Random random = new Random();
    int[][] matrix = new int[10][10];
    int sum = 0;
    int diagonalNumber;
    public void Matrix() {
        matrixCreation(matrix);
        diagonalSum(matrix);
        System.out.println(String.format("A soma da diagonal principal da matriz %d por %d gerada aleatóriamente é %d", matrix.length, matrix[0].length, sum));
    }

    private void matrixCreation(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(51);
            }
        }
    }

    private void diagonalSum(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    diagonalNumber = matrix[i][j];
                    sum = sum + diagonalNumber;
                }
            }
        }
    }
}
