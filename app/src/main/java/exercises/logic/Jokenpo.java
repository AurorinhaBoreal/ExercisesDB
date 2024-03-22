package exercises.logic;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Jokenpo {
    ArrayList<String> playerHand = new ArrayList<>();
    ArrayList<String> computerHand = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String[] choices = {"P", "A", "T"};
    int[] score = {0,0};

    public void game() {
        System.out.println("Bem-Vinde! Gostaria de jogar Pedra, Papel, Tesoura? S/N");

        String wannaPlay = scanner.nextLine();

        if (wannaPlay.equals("S")) {
            play();
        }

        else {
            System.out.println("Eu nem queria mesmo!");
        }
    }

    private void play() {
        char player;
        playerHand.clear();
        char computer;
        computerHand.clear();
        System.out.println("Escolha entre Pedra (P), Papel (A) ou Tesoura (T):");

        // Pegando o primeiro caractere que aparece para podermos utilizar char
        player = scanner.next().charAt(0);
        computer = choices[random.nextInt(3)].charAt(0);

        // Artes ASCII Possiveis
        if (player == 'P') {
            playerHand.add("    _______  ");
            playerHand.add("---'   ____) ");
            playerHand.add("      (_____)");
            playerHand.add("      (_____)");
            playerHand.add("      (____) ");
            playerHand.add("---.__(___)  ");
        } else if (player == 'A') {
            playerHand.add("     _______      ");
            playerHand.add("---'    ____)____ ");
            playerHand.add("           ______)");
            playerHand.add("          _______)");
            playerHand.add("         _______) ");
            playerHand.add(" ---.__________)  ");
        } else if (player == 'T') {
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
        String playAgain = scanner.nextLine();

        if (playAgain.equals("S")) {
            play();
        }
    }

    private void showHands(ArrayList<String> playerHands, ArrayList<String> computerHands) {
        for (int i = 0; i < playerHands.size(); i++) {
            System.out.println(playerHands.get(i)+"  \t  "+computerHands.get(i));
        }
    }

    private String gameLogic(char player, char computer, int[] score) {
        String[] possibleResults = {"Parabéns! Você ganhou a rodada!", "Ihh, Empatou!", "Você perdeu pro Java!"};
        String result;

        if (player == 'P' && computer == 'P') {
            result = possibleResults[1];
        } else if (player == 'P' && computer == 'A') {
            result = possibleResults[2];
        } else if (player == 'P' && computer == 'T') {
            result = possibleResults[0];
        } else if (player == 'A' && computer == 'P') {
            result = possibleResults[0];
        } else if (player == 'A' && computer == 'A') {
            result = possibleResults[1];
        } else if (player == 'A' && computer == 'T') {
            result = possibleResults[2];
        } else if (player == 'T' && computer == 'P') {
            result = possibleResults[2];
        } else if (player == 'T' && computer == 'A') {
            result = possibleResults[0];
        } else {
            result = possibleResults[1];
        }
        
        if (result.equals("Parabéns! Você ganhou a rodada!")) {
            score[0] += 1;
        } else if (result.equals("Você perdeu pro Java!")) {
            score[1] += 1;
        }
        return result;
    }
}
