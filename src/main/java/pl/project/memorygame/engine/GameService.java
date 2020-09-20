package pl.project.memorygame.engine;

import java.util.*;

public class GameService {
    public static void main(String[] args) {

        List<Integer> game = createGameField();
        List<Integer> endGame = new ArrayList<>();
        endGame.add(0);
        Scanner scanner = new Scanner(System.in);
        printBoard(game);

        while (!endGame.containsAll(game) && scanner.hasNextInt()) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            findPair(game, a, b);
            printBoard(game);
            System.out.println();
        }
        System.out.println();
        System.out.println(" you win!");

    }

    private int getRandomKey() {
        Random random = new Random();
        int a = random.nextInt(4) + 1;
        int b = random.nextInt(4) + 1;
        return 10 * a + b;
    }

    //FIX ME
    private String getMemoryCardPicture() {

        return "picture";

    }

    //FIX ME - should return List

    public static List<Integer> createGameField() {

        List<Integer> listOfPairs = new ArrayList<>();
        Integer value = 1;
        for (int i = 0; i < 16; i += 2) {

            listOfPairs.add(i, value);
            listOfPairs.add(i + 1, value);
            value++;

        }
        Collections.shuffle(listOfPairs);

        return listOfPairs;
    }

    //This will find pairs and remove/replace slots in the list
    public static boolean findPair(List<Integer> listOfPairs, int firstField, int secondField) {
        if (listOfPairs.get(firstField).equals(listOfPairs.get(secondField))) {
            listOfPairs.remove(firstField);
            listOfPairs.add(firstField, 0);
            listOfPairs.remove(secondField);
            listOfPairs.add(secondField, 0);
            return true;
        }
        return false;

    }

    private static void printBoard(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 4 == 0) {
                System.out.println(" ");
            }
            System.out.print(list.get(i)+" ");

        }

    }


}
