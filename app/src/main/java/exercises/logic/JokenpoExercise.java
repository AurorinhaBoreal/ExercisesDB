package exercises.logic;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class JokenpoExercise {
    ArrayList<String> playerHand = new ArrayList<>();
    ArrayList<String> computerHand = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String[] choices = {"P", "A", "T"};
    int[] score = {0,0};

    public void game() {
        System.out.println("Bem-Vinde! Gostaria de jogar Pedra, Papel, Tesoura? S/N");

        String wannaPlay = scanner.nextLine().toUpperCase();

        if (wannaPlay.equals("S")) {
            play();
        }

        else {
            System.out.println("Eu nem queria mesmo!");
        }
    }

    private void play() {
        String player;
        playerHand.clear();
        char computer;
        computerHand.clear();
        System.out.println("Escolha entre Pedra (P), Papel (A) ou Tesoura (T):");

        // Pegando o primeiro caractere que aparece para podermos utilizar char
        player = scanner.next().toUpperCase();
        computer = choices[random.nextInt(3)].charAt(0);

        // Artes ASCII Possiveis
        if (player.equals("P")) {
            playerHand.add("    _______  ");
            playerHand.add("---'   ____) ");
            playerHand.add("      (_____)");
            playerHand.add("      (_____)");
            playerHand.add("      (____) ");
            playerHand.add("---.__(___)  ");
        } else if (player.equals("A")) {
            playerHand.add("     _______      ");
            playerHand.add("---'    ____)____ ");
            playerHand.add("           ______)");
            playerHand.add("          _______)");
            playerHand.add("         _______) ");
            playerHand.add(" ---.__________)  ");
        } else if (player.equals("T")) {
            playerHand.add("    _______      ");
            playerHand.add("---'   ____)___ _");
            playerHand.add("          ______)");
            playerHand.add("      __________)");
            playerHand.add("      (____)     ");
            playerHand.add("---.__(___)      ");
        } else {
            System.out.println("Jogada inválida.");
            play();
        }

        if (computer == 'P') {
            computerHand.add("   _______    ");
            computerHand.add("  (____   '---");
            computerHand.add(" (_____)      ");
            computerHand.add(" (_____)      ");
            computerHand.add("  (____)      ");
            computerHand.add("   (___)__.---");
        } else if (computer == 'A') {
            computerHand.add("     _______      ");
            computerHand.add(" ____(____   '----");
            computerHand.add("(______           ");
            computerHand.add("(_______          ");
            computerHand.add(" (_______         ");
            computerHand.add("    (_________.---");
        } else if (computer == 'T') {
            computerHand.add("       _______    ");
            computerHand.add("  ____(____   '---");
            computerHand.add(" (______          ");
            computerHand.add("(__________       ");
            computerHand.add("      (____)      ");
            computerHand.add("       (___)__.---");
        }
        
        showHands(playerHand, computerHand);
        System.out.println("Sua Jogada    \t    Jogada do Java\n");
        String result = gameLogic(player, computer, score);

        System.out.println(result);

        System.out.println("\nPontuação Atual: \nVOCÊ: "+score[0]+" \nJAVA: "+score[1]);

        System.out.println("Quer jogar denovo? S/N");

        // Capturando linha vazia
        scanner.nextLine();
        String playAgain = scanner.nextLine().toUpperCase();

        if (playAgain.equals("S")) {
            play();
        }
    }

    private void showHands(ArrayList<String> playerHands, ArrayList<String> computerHands) {
        for (int i = 0; i < playerHands.size(); i++) {
            System.out.println(playerHands.get(i)+"  \t  "+computerHands.get(i));
        }
    }

    private String gameLogic(String player, char computer, int[] score) {
        String[] possibleResults = {"Parabéns! Você ganhou a rodada!", "Ihh, Empatou!", "Você perdeu pro Java!"};
        String result;

        if (player.charAt(0) == computer) {
            result = possibleResults[1];
        } else if (player.equals("P")) {
            result = computer == 'T' ? possibleResults[0] : possibleResults[2];
        } else {
            result = computer == 'A' ? possibleResults[0] : possibleResults[2];
        }
        
        if (result.equals("Parabéns! Você ganhou a rodada!")) {
            score[0] += 1;
        } else if (result.equals("Você perdeu pro Java!")) {
            score[1] += 1;
        }
        return result;
    }
}
