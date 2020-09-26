package pl.project.memorygame.engine;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
public class Game {

    private UUID uuid;
    List<Card> cards;
    @Setter
    int moveCounter;
    @Setter
    int pairsCounter;

    public Game() {
        this.cards = createCardsList(16);
        this.moveCounter = 0;
        this.pairsCounter = 0;
        this.uuid = UUID.randomUUID();

    }

    public static List<Card> createCardsList(int quantity) {
        List<Integer> valuesList = Card.createValuesForCards(quantity);
        List<Card> cardsList = new ArrayList<>();
        for (int i = 0; i < valuesList.size(); i++) {
            cardsList.add(Card.createCard(valuesList.get(i), i));

        }
        return cardsList;
    }

    @Override
    public String toString() {
        return "Game{" +
                "cardsList=" + cards +
                '}';
    }
}
