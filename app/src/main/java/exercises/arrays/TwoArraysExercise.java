package exercises.logic;

import java.util.Random;

public class TwoArraysExercise {
    Random random = new Random();
    int[] array1 = new int[50];
    int[] array2 = new int[50];
    public void mergeArrays() {
        populatingArray(array1);
        populatingArray(array2);
        System.out.println("Arrays Desorganizados:");
        System.out.println("Array 1:");
        showingArrays(array1);
        System.out.println("\nArray 2:");
        showingArrays(array2);

        sortingArray(array1);
        sortingArray(array2);
        
        System.out.println("\n Arrays Organizados:");
        System.out.println("Array 1:");
        showingArrays(array1);
        System.out.println("\nArray 2:");
        showingArrays(array2);

        int[] array3 = mergingArrays(array1, array2);
        System.out.println("\n Arrays Mesclados Desorganizados");
        showingArrays(array3);
        System.out.println("\n Arrays Mesclados Organizados");
        sortingArray(array3);
        showingArrays(array3);
    }

    private void populatingArray(int[] array) {
        for (int i = 0; i < 50; i++) {
            array[i] = random.nextInt(101);

        }
    }

    private void sortingArray(int[] array) {
        int indexN1, indexN2;
        int n1, n2;
        int temp = 0;
        // Bubble Sort - Se o numero seguinte for maior que o seguinte, inverter posições
        for (int i = 0; i < array.length; i++) {
            indexN1 = i;
            n1 = array[indexN1];
            for (int j = 0; j < i; j++) {
                indexN2 = j;
                n2 = array[indexN2];
            // Na minha cabeça era pra isso ser ao contrário, revisar depois!
                if (n1 < n2) {
                    swappingNumbers(array, n1, n2, indexN1, indexN2, temp);
                }
            }
        }
    }

    private void swappingNumbers(int[] array, int n1, int n2, int indexN1, int indexN2, int temp) {
        // temp Armazena o valor de n1, mudamos o valor de n1 para n2
        // Nesse ponto no array temos n1 e n2 com o mesmo valor
        // Em seguida, atribuimos n2 como temp
        // Que esta armazenando o valor de n1
        temp = array[indexN1];
        array[indexN1] = n2;
        array[indexN2] = temp;
    }
    
    private int[] mergingArrays(int[] array1, int[] array2) {
        int a1Length = array1.length;
        int a2Length = array2.length;
        int a3Length = a1Length + a2Length;

        int[] array3 = new int[a3Length];

        // Explicações de cada Parametro
        // array1 - srcArray - O array de onde as informações serão copiadas
        // 0 - srcIndex - Posição Inicial no qual as informações serão retiradas
        // array3 - destArray - Array para onde as informações serão copiadas
        // 0 - destIndex - Posição Inicial na qual as informações serão copiadas
        // a1Length - length - Quantidade de itens do array que serão copiadas
        System.arraycopy(array1, 0, array3, 0, a1Length);
        System.arraycopy(array2, 0, array3, a1Length, a2Length);
        
        return array3;
    }

    private void showingArrays(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i]+"|");
        }
    }
}
