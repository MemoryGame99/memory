package pl.project.memorygame.engine;

import java.util.*;

public class GameService {




    public static List<Integer> createValuesForGameField() {

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

    private static Card<Picture> createCard(int pictureNumber, int cardNumber){
        AnimalPicture animalPicture = new AnimalPicture(pictureNumber);
        Card<AnimalPicture> card = new Card<>(animalPicture,cardNumber);

        return null;
    }

    private static List<Card<Picture>> createCardsList(List<Integer> valuesList){

        List<Card<Picture>> cardsList = new ArrayList<>();

        for (int i = 0; i < valuesList.size(); i++) {
           cardsList.add(createCard(valuesList.get(i),i));

        }
        return cardsList;
    }


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
