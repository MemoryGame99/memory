package pl.project.memorygame.engine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Getter
@Setter

public class Game {

    private UUID uuid;
    List<Card> cardsList;
    int moveCounter;
    int pairsCounter;

    public Game() {
        this.cardsList = createCardsList(16);
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
}
