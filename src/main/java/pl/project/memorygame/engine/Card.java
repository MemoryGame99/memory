package pl.project.memorygame.engine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Card {

    private Picture picture;
    private int value;
    private CardSide cardSide;


    public Card(Picture picture, int value) {
        this.picture = picture;
        this.value = value;
        this.cardSide = CardSide.REVERSE;
    }

    public void reverseCard() {
        if (cardSide.equals(CardSide.REVERSE)) {
            cardSide = CardSide.OBVERSE;
        } else if (cardSide.equals(CardSide.OBVERSE)) {
            cardSide = CardSide.REVERSE;

        }
    }

}
