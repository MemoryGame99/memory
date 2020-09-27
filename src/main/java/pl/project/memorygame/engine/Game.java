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

    Integer firstCardIndex;
    Integer secondCardIndex;

    public Game() {
        this.cards = createCardsList(16);
        this.moveCounter = 0;
        this.pairsCounter = 0;
        this.uuid = UUID.randomUUID();
    }

    public Game checkCard(Integer cardIndex) {
        if(firstCardIndex == null) {
            this.firstCardIndex = cardIndex;
            return this;
        } else {
            if(secondCardIndex == null) {
                this.secondCardIndex = cardIndex;

                // sprawdzamy czy takie same
                // jezeli tak to zapisz tą informacje

                // jezeli roze to zwracamy return this
            } else {
                // zakryj wszystko oprócz tego indeksu + odkrytych poprawnie kart
            }


        }


return this;
    }


    //metoda otrzymuje lite kart i jeśli zostanie znaleziona para zwraca liste tych kart z ustawioną strona karty jako odkryta
    public List<Card> findPair(int firstCardIndex, int secondCardIndex) {
        if (!cards.get(firstCardIndex).getPicture().getPictureName()
                .equals(cards.get(secondCardIndex).getPicture().getPictureName())) {

            cards.get(firstCardIndex).reverseCard();
            cards.get(secondCardIndex).reverseCard();

            return cards;
        }
        return cards;

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
