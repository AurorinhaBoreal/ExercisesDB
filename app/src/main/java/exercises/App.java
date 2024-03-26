package exercises;


import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

import exercises.arrays.*;
import exercises.logic.*;
import exercises.methods.*;
import exercises.oop.*;
import exercises.repetitionStructures.*;

public class App {
    
    public static void main(String[] args) {
        int chooseExercise;
        List<String> exercises = Arrays.asList("Idade", "Produto", "Jokenpo", "Calculadora", "Tabuada", "Numeros Aleatórios", "Fibonacci", "Leitura", "Limite de Fibonacci", "Soma de Matriz", "Organização de Array", "Mesclagem de Array", "Média de Aluno", "Conversão de Segundos", "Calculadora Estática", "Empréstimo de Livros", "Árvore Genealógica", "Automóveis", "Agenda Telefônica", "Super Mercado");
        Scanner sExercise = new Scanner(System.in);

        for (int i = 0; i < exercises.size(); i++) {
            System.out.printf("| "+((exercises.indexOf(exercises.get(i)))+1)+" - "+exercises.get(i)+" |");
            if (i > 1) {
                if (i%2 == 0) System.out.println("\n");    
            }
        }
        chooseExercise = sExercise.nextInt();
        switch (chooseExercise) {
            case 1:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                AgeExercise idade = new AgeExercise();
                idade.VerifyingAge();
                break;
            case 2:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                ProductExercise produto = new ProductExercise();
                produto.productArray();
                break;
            case 3:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                JokenpoExercise jokenpo = new JokenpoExercise();
                jokenpo.game();
                break;
            case 4:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                CalculatorExercise calculator = new CalculatorExercise();
                calculator.chooseCalc();
                break;
            case 5:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                MultiplicationExercise multiplication = new MultiplicationExercise();
                multiplication.choosingNumber();
                break;
            case 6:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                RandomExercise random = new RandomExercise();
                random.randomNumbers();
                break;
            case 7:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                FibonacciExercise fibonacci = new FibonacciExercise();
                fibonacci.FibonacciCalculation();
                break;
            case 8:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                ReadExercise read = new ReadExercise();
                read.showNumber();
                break;
            case 9:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                FibonacciLimitExercise fibonacciLimit = new FibonacciLimitExercise();
                fibonacciLimit.FibonacciCalculation();
                break;
            case 10:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                MatrixSumExercise matrix = new MatrixSumExercise();
                matrix.Matrix();
                break;
            case 11:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                RandomArrayExercise array = new RandomArrayExercise();
                array.Array();
                break;
            case 12:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                TwoArraysExercise twoArrays = new TwoArraysExercise();
                twoArrays.mergeArrays();
                break;
            case 13:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                StudentExercise student = new StudentExercise();
                student.studentInfo();
                break;
            case 14:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                SecondsConversionExercise seconds = new SecondsConversionExercise();
                seconds.getSeconds();
                break;
            case 15:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                StaticCalculatorExercise.chooseCalc();
                break;
            case 16:
                System.out.println("Você escolheu o exercicio "+exercises.get(chooseExercise-1)+"...");
                BookLoanExercise bookLoan = new BookLoanExercise();
                bookLoan.BookListPopulate();
                break;
            default:
                System.out.println("Esse não é um exercicio válido.");
                break;
        }
        sExercise.close();
    }
}
