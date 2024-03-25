package exercises.logic;

import java.util.Random;

public class RandomArrayExercise {
    Random random = new Random();
    int[] randomArray = new int[100];
    public void Array() {
        populatingArray(randomArray);
        System.out.printf("Desorganizado:\n| ");
        showingArray();
        sortingArray(randomArray);
        System.out.printf("\nOrganizado:\n| ");
        showingArray();
    }

    private void populatingArray(int[] randomArray) {
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(101);
        }
    }

    private void sortingArray(int[] randomArray) {
        int indexN1, indexN2;
        int n1, n2;
        int temp = 0;
        // Bubble Sort - Se o numero seguinte for maior que o seguinte, inverter posições
        for (int i = 0; i < randomArray.length; i++) {
            indexN1 = i;
            n1 = randomArray[indexN1];
            for (int j = 0; j < i; j++) {
                indexN2 = j;
                n2 = randomArray[indexN2];
            // Na minha cabeça era pra isso ser ao contrário, revisar depois!
                if (n1 < n2) {
                    swappingNumbers(n1, n2, indexN1, indexN2, temp);
                }
            }
        }
    }    

    private void showingArray() {
        for (int i = 0; i < randomArray.length; i++) {
            System.out.printf(randomArray[i]+" | ");
        }
    }

    private void swappingNumbers(int n1, int n2, int indexN1, int indexN2, int temp) {
        // temp Armazena o valor de n1, mudamos o valor de n1 para n2
        // Nesse ponto no array temos n1 e n2 com o mesmo valor
        // Em seguida, atribuimos n2 como temp
        // Que esta armazenando o valor de n1
        temp = randomArray[indexN1];
        randomArray[indexN1] = n2;
        randomArray[indexN2] = temp;
    }
}
