package exercises.repetitionStructures;

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
        int numberMin[] = {randomList.get(0)};

        randomList.forEach((number) -> {
            if (randomList.get(randomList.indexOf(number)) < numberMin[0]) {
                numberMin[0] = randomList.get(randomList.indexOf(number));
            }
        });

        return numberMin[0];
    }

    public int getMax(ArrayList<Integer> randomList) {

        int numberMax[] = {randomList.get(0)};

        randomList.forEach((number) -> {
            if (randomList.get(randomList.indexOf(number)) > numberMax[0]) {
                numberMax[0] = randomList.get(randomList.indexOf(number));
            }
        });

        return numberMax[0];
    }
}
