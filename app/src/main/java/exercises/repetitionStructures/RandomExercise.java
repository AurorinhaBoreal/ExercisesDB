package exercises.logic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class RandomExercise {
    ArrayList<Integer> randomList = new ArrayList<>();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int quantity;
    int min;
    int max;
    public void randomNumbers() {
        System.out.println("Quantos números aleatórios deseja gerar?");
        quantity = scanner.nextInt();
    
        generateNumbers(randomList, quantity);
        min = getMin(randomList);
        max = getMax(randomList);

        System.out.println(String.format("\nDentre %d numeros gerados. Em um intervalo de 0 até 100. \nO menor numero gerado foi %d e o maior foi %d", quantity, min, max));
    }

    public void generateNumbers(ArrayList<Integer> randomList, int quantity) {
        for (int i = 0; i < quantity; i++) {
            randomList.add(random.nextInt(101));
        }
    }

    public int getMin(ArrayList<Integer> randomList) {
        int numberMin = randomList.get(0);

        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i) < numberMin) numberMin = randomList.get(i);
        }

        return numberMin;
    }

    public int getMax(ArrayList<Integer> randomList) {
        int numberMax = randomList.get(0);

        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i) > numberMax) numberMax = randomList.get(i);
        }

        return numberMax;
    }
}
