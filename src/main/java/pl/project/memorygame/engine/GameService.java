package pl.project.memorygame.engine;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

@Service
public class GameService {

    public Game game;

    public GameService() {
        game = new Game(16);
    }

    public static List<Card> createCards(Integer gameSize) {
        List<Card> myResultList = new ArrayList<>(gameSize);
        for (Integer id : GameService.generateRandomPicIds(gameSize / 2, 1, 1000)) {
            myResultList.add(new Card(id));
            myResultList.add(new Card(id));
        }
        Collections.shuffle(myResultList);
        return myResultList;
    }

    public static List<Integer> generateRandomPicIds(Integer picListSize, int min, int max){

        List<Integer> pictureIdList = new ArrayList<>();
        for (int i = 0; i < picListSize; i++) {
            int random = new Random().nextInt(max - min) + min;
            int status = 0;
            if (pictureIdList.contains(random)){
                picListSize++;
                continue;
            }
            try {
                URL url = new URL("https://picsum.photos/id/" + random + "/300/200");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                status = con.getResponseCode();
                con.disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (status != 200) {
                picListSize++;
                continue;
            }
            pictureIdList.add(random);
        }
        return pictureIdList;
    }

    public void playNextMove(Integer cardNo) {
        game.incrementMoveCounter();
        game.getCards().get(cardNo).turnCard();

        if (game.getMoveCounter() % 2 == 0) {
            game.setNewTurn(true);
            game.setSelectedCardIdx(cardNo);
        } else {
            game.setPreviousCardIdx(cardNo);
        }
    }

    public void checkCards() {
        if (!game.isCardAsLast()) {
            game.getCards().get(game.getPreviousCardIdx()).turnCard();
            game.getCards().get(game.getSelectedCardIdx()).turnCard();
        }
        game.setNewTurn(false);
    }

    public void newGame() {
        game = new Game(16);
    }

    public static List<String> generateRandomPicLinks(Integer listSize) {
        List<String> myResultList = new ArrayList<>(listSize);

        for (Integer i : GameService.generateRandomPicIds(listSize, 1, 1000)) {
            myResultList.add("https://picsum.photos/id/" + i + "/600/400");
        }

        return myResultList;
    }

}


