package pl.project.memorygame.engine;

import java.util.*;

public class GameService {


    public Game newGame(){
        List<Integer> valuesForGameField = createValuesForGameField();
        List<Card> cardsList = createCardsList(valuesForGameField);

        return new Game(cardsList);
    }


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

    private static Card createCard(int pictureNumber, int cardNumber) {
        AnimalPicture Picture = new AnimalPicture(pictureNumber);
        Card card = new Card(Picture, cardNumber);

        return card;
    }

    public static List<Card> createCardsList(List<Integer> valuesList) {

        List<Card> cardsList = new ArrayList<>();

        for (int i = 0; i < valuesList.size(); i++) {
            cardsList.add(createCard(valuesList.get(i), i));

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


    public static void showPictures(List<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 4 == 0) {
                System.out.println(" ");
            }
            System.out.print(list.get(i).getPicture().getPictureName() + " ");

        }

    }

    public static void showBoard(List<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 4 == 0) {
                System.out.println(" ");
            }
            System.out.print(list.get(i).getValue() + " ");
        }

    }
}


