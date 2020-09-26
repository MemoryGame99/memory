package pl.project.memorygame.engine;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class Picture {

    private int pictureIndex;
    private String pictureName;

    private Map<Integer, String> pictures(){
        Map <Integer, String> cardPictures = new HashMap<>();
        cardPictures.put(1, "PICTURE1");
        cardPictures.put(2, "PICTURE2");
        cardPictures.put(3, "PICTURE3");
        cardPictures.put(4, "PICTURE4");
        cardPictures.put(5, "PICTURE5");
        cardPictures.put(6, "PICTURE6");
        cardPictures.put(7, "PICTURE7");
        cardPictures.put(8, "PICTURE8");

        return cardPictures;
    }
    public Picture(int pictureIndex) {
        this.pictureIndex = pictureIndex;
        pictureName = pictures().get(pictureIndex);

    }

}
