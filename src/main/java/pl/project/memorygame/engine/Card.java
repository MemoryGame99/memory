package pl.project.memorygame.engine;

import lombok.Getter;

@Getter
public class Card<T extends Pictures> {

    private T picture;

    int value;

    public Card(T picture, int value) {
        this.picture = picture;
        this.value = value;
    }

    private enum cardSide{
        OBVERSE,
        REVERSE;
    }
}
