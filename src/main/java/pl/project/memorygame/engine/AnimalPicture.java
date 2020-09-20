package pl.project.memorygame.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalPicture extends Picture {

    private int value;
    private String pictureName;


    private Map<Integer, String> pictures(){
       Map <Integer, String> cardPictures = new HashMap<>();
        cardPictures.put(1, "DOG");
        cardPictures.put(2, "CAT");
        cardPictures.put(3, "MOUSE");
        cardPictures.put(4, "BIRD");
        cardPictures.put(5, "GIRAFFE");
        cardPictures.put(6, "ELEPHANT");
        cardPictures.put(7, "TURTLE");
        cardPictures.put(8, "SNAKE");

        return cardPictures;
    }

    public AnimalPicture(int value) {
        this.value = value;
        pictureName = pictures().get(value);

    }
}
