package exercises;


import java.util.Scanner;

import exercises.arrays.*;
import exercises.logic.*;
import exercises.methods.StudentExercise;
import exercises.repetitionStructures.*;

public class App {
    
    public static void main(String[] args) {
        int exercise;
        Scanner sExercise = new Scanner(System.in);

        System.out.println("Escolha o exercicio que deseja executar:");
        System.out.println("1 - Idade \t 2 - Produto \t 3 - Jokenpo \t 4 - Calculadora");
        System.out.println("5 - Tabuada \t 6 - Numeros Aleatórios \t 7 - Fibonacci \t 8 - Leitura");
        System.out.println("9 - Limite de Fibonacci \t 10 - Soma de Matriz11 \t 11 - Organização de Array \t 12 - Mesclagem de Arrays");
        System.out.println("13 - Media do Aluno");
        exercise = sExercise.nextInt();
        switch (exercise) {
            case 1:
                System.out.println("Você escolheu o exercicio Age...");
                AgeExercise idade = new AgeExercise();
                idade.VerifyingAge();
                break;
            case 2:
                System.out.println("Você escolheu o exercicio Product...");
                ProductExercise produto = new ProductExercise();
                produto.productArray();
                break;
            case 3:
                System.out.println("Você escolheu o exercicio Jokenpo...");
                JokenpoExercise jokenpo = new JokenpoExercise();
                jokenpo.game();
                break;
            case 4:
                System.out.println("Você escolheu o exercicio Calculadora...");
                CalculatorExercise calculator = new CalculatorExercise();
                calculator.chooseCalc();
                break;
            case 5:
                System.out.println("Você escolheu o exercicio Tabuada...");
                MultiplicationExercise multiplication = new MultiplicationExercise();
                multiplication.choosingNumber();
                break;
            case 6:
                System.out.println("Você escolheu o exercicio Números Aleatórios...");
                RandomExercise random = new RandomExercise();
                random.randomNumbers();
                break;
            case 7:
                System.out.println("Você escolheu o exercicio Fibonacci,,,");
                FibonacciExercise fibonacci = new FibonacciExercise();
                fibonacci.FibonacciCalculation();
                break;
            case 8:
                System.out.println("Você escolheu o exercicio Leitura...");
                ReadExercise read = new ReadExercise();
                read.showNumber();
                break;
            case 9:
                System.out.println("Você escolheu o exercicio Limite de Fibonacci...");
                FibonacciLimitExercise fibonacciLimit = new FibonacciLimitExercise();
                fibonacciLimit.FibonacciCalculation();
                break;
            case 10:
                System.out.println("Você escolheu o exercicio Soma de Matriz...");
                MatrixSumExercise matrix = new MatrixSumExercise();
                matrix.Matrix();
                break;
            case 11:
                System.out.println("Você escolheu o exercicio Organizaçao de Array...");
                RandomArrayExercise array = new RandomArrayExercise();
                array.Array();
                break;
            case 12:
                System.out.println("Você escolheu o exercicio Organizaçao de Dois Arrays...");
                TwoArraysExercise twoArrays = new TwoArraysExercise();
                twoArrays.mergeArrays();
                break;
            case 13:
                System.out.println("Você escolheu o exercicio de Media do Aluno...");
                StudentExercise student = new StudentExercise();
                student.studentInfo();
                break;
            default:
                System.out.println("Esse não é um exercicio válido.");
                break;
        }
        sExercise.close();
    }
}
