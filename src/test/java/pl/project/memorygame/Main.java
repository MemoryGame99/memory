package pl.project.memorygame;

import pl.project.memorygame.engine.Card;
import pl.project.memorygame.engine.GameService;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> valuesForGameField = GameService.createValuesForGameField();
        List<Card> cardsList = GameService.createCardsList(valuesForGameField);
        GameService.showPictures(cardsList);

    }
}