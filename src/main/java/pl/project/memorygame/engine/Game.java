package pl.project.memorygame.engine;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Game {

    List<Card> cardsList;
    int moveCounter;
    int pairsCounter;

    public Game(List<Card> cardsList) {
        this.cardsList = cardsList;
        this.moveCounter = 0;
        this.pairsCounter = 0;
    }
}
