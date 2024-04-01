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
        String defaultMsg = "Você escolheu o exercicio";
        List<String> exercises = Arrays.asList("Idade", "Produto", "Jokenpo", "Calculadora", "Tabuada", "Numeros Aleatórios", "Fibonacci", "Leitura", "Limite de Fibonacci", "Soma de Matriz", "Organização de Array", "Mesclagem de Array", "Média de Aluno", "Conversão de Segundos", "Calculadora Estática", "Empréstimo de Livros", "Árvore Genealógica", "Automóveis", "Agenda Telefônica");
        Scanner sExercise = new Scanner(System.in);

        showExercise(exercises);

        chooseExercise = sExercise.nextInt();
        
        showChoosenExercise(defaultMsg, exercises, chooseExercise);
        switch (chooseExercise) {
            case 1:
                AgeExercise age = new AgeExercise();
                age.VerifyingAge();
                break;
            case 2:
                ProductExercise product = new ProductExercise();
                product.productArray();
                break;
            case 3:
                JokenpoExercise jokenpo = new JokenpoExercise();
                jokenpo.game();
                break;
            case 4:
                CalculatorExercise calculator = new CalculatorExercise();
                calculator.chooseCalc();
                break;
            case 5:
                MultiplicationExercise multiplication = new MultiplicationExercise();
                multiplication.choosingNumber();
                break;
            case 6:
                RandomExercise random = new RandomExercise();
                random.randomNumbers();
                break;
            case 7:
                FibonacciExercise fibonacci = new FibonacciExercise();
                fibonacci.FibonacciCalculation();
                break;
            case 8:
                ReadExercise read = new ReadExercise();
                read.showNumber();
                break;
            case 9:
                FibonacciLimitExercise fibonacciLimit = new FibonacciLimitExercise();
                fibonacciLimit.FibonacciCalculation();
                break;
            case 10:
                MatrixSumExercise matrix = new MatrixSumExercise();
                matrix.Matrix();
                break;
            case 11:
                RandomArrayExercise array = new RandomArrayExercise();
                array.Array();
                break;
            case 12:
                TwoArraysExercise twoArrays = new TwoArraysExercise();
                twoArrays.mergeArrays();
                break;
            case 13:
                StudentExercise student = new StudentExercise();
                student.studentInfo();
                break;
            case 14:
                SecondsConversionExercise seconds = new SecondsConversionExercise();
                seconds.getSeconds();
                break;
            case 15:
                StaticCalculatorExercise.chooseCalc();
                break;
            case 16:
                BookLoanExercise bookLoan = new BookLoanExercise();
                bookLoan.BookListPopulate();
                break;
            case 17:
                FamilyTreeExercise tree = new FamilyTreeExercise();
                tree.populatingTree();
                break;
            case 18:
                AutomobilesExercise automobile = new AutomobilesExercise();
                automobile.choosingVehicle();
                break;
            case 19:
                PhoneBookExercise phone = new PhoneBookExercise();
                phone.PopulateBook();
                break;
            default:
                System.out.println("Esse não é um exercicio válido.");
                break;
        }
        sExercise.close();
    }

    public static void showExercise(List<String> exercises) {
        System.out.println("|================EXERCICIOS===============|");
        exercises.forEach((exercise) -> {
            System.out.println("| "+((exercises.indexOf(exercise))+1)+" - "+exercise);
        });
        // for (int i = 0; i < exercises.size(); i++) {
        //     System.out.printf("| "+((exercises.indexOf(exercises.get(i)))+1)+" - "+exercises.get(i)+" |");
        //     if (i > 1) {
        //         if (i%2 == 0) System.out.println("\n");    
        //     }
        // }
        System.out.println("|=======================|");
        System.out.println("Informe o Exercicio que deseja visualizar:");
    }    

    public static void showChoosenExercise(String defaultMsg, List<String> exercises, int chooseExercise) {
        System.out.println(defaultMsg+" "+exercises.get(chooseExercise-1)+"...");
    }
}
