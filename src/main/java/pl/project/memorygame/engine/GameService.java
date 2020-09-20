package pl.project.memorygame.engine;

import java.util.*;

public class GameService {

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

    public static void createGameField() {

        List<Integer> listOfPairs = new ArrayList<>();
        Integer value = 1;
        for (int i = 0; i < 16; i+=2) {

            listOfPairs.add(i, value);
            listOfPairs.add(i+1, value);
            value++;

        }
        Collections.shuffle(listOfPairs);

    }

    //This will find pairs and remove/replace slots in the list
    public static void findPair (List<Integer> listOfPairs, int firstField, int secondField){

    }


}
