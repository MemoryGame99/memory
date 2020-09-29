package pl.project.memorygame.engine;

import org.springframework.stereotype.Service;

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

    public static List<Integer> generateRandomPicIds(Integer picListSize, int min, int max) {

        List<Integer> pictureIdList = new ArrayList<>(picListSize);
        for (int i = 0; i < picListSize; i++) {
            pictureIdList.add(new Random().nextInt(max - min) + min);
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
}


