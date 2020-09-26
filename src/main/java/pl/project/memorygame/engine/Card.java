package pl.project.memorygame.engine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
@NoArgsConstructor
@ToString
public class Card {

    private Picture picture;
    private int cardIndex;
    private CardSide cardSide;

    public Card(Picture picture, int cardIndex) {
        this.picture = picture;
        this.cardIndex = cardIndex;
        this.cardSide = cardIndex%2==0 ? CardSide.REVERSE : CardSide.OBVERSE;
    }

    public void reverseCard() {
        if (cardSide.equals(CardSide.REVERSE)) {
            cardSide = CardSide.OBVERSE;
        } else if (cardSide.equals(CardSide.OBVERSE)) {
            cardSide = CardSide.REVERSE;

        }
    }

    public static List<Integer> createValuesForCards(int quantity) {
        //quantity must be even
        if (quantity < 0 || quantity > 16) {
            quantity = 16;
        }
        if (quantity % 2 != 0) {
            quantity += 1;
        }

        List<Integer> listOfPairs = new ArrayList<>();
        Integer value = 1;
        for (int i = 0; i < quantity; i += 2) {

            listOfPairs.add(i, value);
            listOfPairs.add(i + 1, value);
            value++;

        }
        Collections.shuffle(listOfPairs);

        return listOfPairs;
    }

    public static Card createCard(int pictureIndex, int cardIndex) {
        Picture Picture = new Picture(pictureIndex);

        return new Card(Picture, cardIndex);
    }


}
