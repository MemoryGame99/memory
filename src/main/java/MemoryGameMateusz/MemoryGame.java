package MemoryGameMateusz;

import java.util.Random;
import java.util.Scanner;

public class MemoryGame {
    private Card[][] board;
    private String[] colors = {"Orange", "Orange", "Blue", "Blue", "Pink", "Pink", "Yellow", "Yellow", "Red", "Red", "Green", "Green", "Black", "Black", "White", "White"};
    private Random rand;
    private Scanner reader;


    public MemoryGame() {
        rand = new Random();
        reader = new Scanner(System.in);
        board = new Card[4][4];
        shuffle();
        setCards();
        printCards();
        playGame();
    }


    public void playGame() {
        choosePairOfCards();
    }

    public void choosePairOfCards() {
        int cardChoice, row1, col1, row2, col2;
        System.out.println();
        System.out.println("Enter the number on the card: ");
        System.out.println("First card choice?");
        cardChoice = getInputAsInt();
        row1 = cardChoice / 4;
        col1 = cardChoice / 4;
        board[row1][col1].setShowing();

        System.out.println("Second card choice?");
        cardChoice = getInputAsInt();
        row2 = cardChoice / 4;
        col2 = cardChoice / 4;
        board[row2][col2].setShowing();

        printCards();
    }

    public void setCards() {
        int i = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = new Card(colors[i], i);
                i++;
            }
        }
    }


    public void printCards() {
        Card card;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                card = board[row][col];
                card.showCard();

            }
            System.out.println();
        }
    }

    public void shuffle() {
        for (int i = 0; i < colors.length; i++) {
            int position = rand.nextInt(colors.length);
            String temp = colors[i];
            colors[i] = colors[position];
            colors[position] = temp;
        }
    }

    public int getInputAsInt() {
        String temp = reader.nextLine();
        return Integer.parseInt(temp);
    }
}


