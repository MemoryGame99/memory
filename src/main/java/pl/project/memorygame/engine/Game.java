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



            if (firstCardIndex == null) {
                reverseCard(cardIndex, 1);
            } else {
                if (secondCardIndex == null) {
                    reverseCard(cardIndex, 2);

                    // sprawdzamy czy takie same
                    // jezeli tak to zapisz tą informacje
                    // jezeli roze to zwracamy return this
                    if (checkIfThisIsPair(firstCardIndex, secondCardIndex)) {
                        markAsCorrect(firstCardIndex, secondCardIndex);
                    }
                } else {
                    // zakryj wszystko oprócz tego indeksu + odkrytych poprawnie kart
                    reverseCard(firstCardIndex, 1);
                    reverseCard(secondCardIndex, 2);

                    firstCardIndex = null;
                    secondCardIndex = null;

                    reverseCard(cardIndex, 1);
                }
            }

        return this;
    }

    private void markAsCorrect(Integer firstCardIndex, Integer secondCardIndex) {

        cards.get(firstCardIndex).setHasAPair(true);
        cards.get(secondCardIndex).setHasAPair(true);

    }

    private void reverseCard(Integer cardIndex, Integer cardNo) {
        if (!cards.get(cardIndex).isHasAPair()) {
            if (cardNo == 1) {
                this.firstCardIndex = cardIndex;
            } else {
                this.secondCardIndex = cardIndex;

            }
            cards.get(cardIndex).reverseCard();
        }
    }

    private boolean checkIfThisIsPair(int firstCardIndex, int secondCardIndex) {
        return cards.get(firstCardIndex).getPicture().getPictureName()
                .equals(cards.get(secondCardIndex).getPicture().getPictureName());
    }

    private List<Card> pairsShown(int firstCardIndex, int secondCardIndex) {
        if (checkIfThisIsPair(firstCardIndex, secondCardIndex)) {
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
