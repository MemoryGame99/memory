package pl.project.memorygame.engine;

import lombok.Getter;

@Getter
public class CardPicture <T extends Pictures> {

    private T picture;
    int value;

    public CardPicture(T picture, int value) {
        this.picture = picture;
        this.value = value;
    }
}
