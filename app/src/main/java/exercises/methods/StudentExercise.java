package exercises.methods;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentExercise {
    ArrayList<Float> scores = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String studentName;
    int testQuantity;
    float finalScore;
    String studentStatus;
    public void studentInfo() {
        System.out.println("Olá, por favor informe seu nome:");
        studentName = scanner.nextLine();

        System.out.println("\n Informe quantas notas deseja inserir");
        testQuantity = scanner.nextInt();

        scorePopulation(testQuantity);
        finalScore = mediaCalculation(scores);
        studentStatus = studentStatus(finalScore);

        String message = String.format("%s após avaliarmos as notas de seus %d testes, sua media final ficou como %.2f. \nDessa forma sua situação está como: %s", studentName, testQuantity, finalScore, studentStatus);
        System.out.println(message);
    }

    private void scorePopulation(int testQuantity) {
        float testScore;
        for (int i = 0; i < testQuantity; i++) {
            System.out.println("Informe a nota do "+(i+1)+"° teste:");
            testScore = scanner.nextFloat();
            scores.add(testScore);
        }
    }

    private float mediaCalculation(ArrayList<Float> array) {
        float testSum = 0;
        float finalScore;
        for (int i = 0; i < array.size(); i++) {
            testSum = testSum + array.get(i);
        }

        finalScore = testSum/array.size();
        return finalScore;
    }

    private String studentStatus(float score) {
        String status;

        if (score > 6) {
            status = "Aprovado";
        } else if (score > 4) {
            status = "Verificação Suplementar";
        } else {
            status = "Reprovado";
        }

        return status;
    }
}
