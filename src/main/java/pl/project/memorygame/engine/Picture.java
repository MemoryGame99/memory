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
        cardPictures.put(1, "PICTURE 1");
        cardPictures.put(2, "PICTURE 2");
        cardPictures.put(3, "PICTURE 3");
        cardPictures.put(4, "PICTURE 4");
        cardPictures.put(5, "PICTURE 5");
        cardPictures.put(6, "PICTURE 6");
        cardPictures.put(7, "PICTURE 7");
        cardPictures.put(8, "PICTURE 8");

        return cardPictures;
    }
    public Picture(int pictureIndex) {
        this.pictureIndex = pictureIndex;
        pictureName = pictures().get(pictureIndex);

    }

}
