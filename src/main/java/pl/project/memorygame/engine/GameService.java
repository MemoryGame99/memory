package pl.project.memorygame.engine;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private Map<Integer, Game> games = new HashMap<>();

    public GameService() {
        Game game = new Game();
        this.games.put(1, game);
    }

    public static Map<UUID, Game> allGames(UUID uuid, Game game) {
        Map<UUID, Game> games = new HashMap<>();
        games.put(uuid, game);

        return games;
    }

    public Game getGame() {
        return games.get(1);
    }

    //metoda otrzymuje lite kart i jeśli zostanie znaleziona para zwraca liste tych kart z ustawioną strona karty jako odkryta
    public static List<Card> findPair(List<Card> listOfPairs, int firstCardIndex, int secondCardIndex) {
        if (!listOfPairs.get(firstCardIndex).getPicture().getPictureName()
                .equals(listOfPairs.get(secondCardIndex).getPicture().getPictureName())) {

            listOfPairs.get(firstCardIndex).reverseCard();
            listOfPairs.get(secondCardIndex).reverseCard();

            return listOfPairs;
        }
        return listOfPairs;

    }


    public static void showCards(List<Card> list, int cardIndex) {
        list.get(cardIndex).reverseCard();
        for (int i = 0; i < list.size(); i++) {
            if (i % 4 == 0) {
                System.out.println(" ");
            }
            if (list.get(i).getCardSide() == CardSide.REVERSE) {
                System.out.print(CardSide.REVERSE.toString() + "  ");
            } else {
                System.out.print(list.get(i).getPicture().getPictureName() + "  ");
            }

        }

    }

    public static void showCards(List<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 4 == 0) {
                System.out.println(" ");
            }
            if (list.get(i).getCardSide() == CardSide.REVERSE) {
                System.out.print(CardSide.REVERSE.toString() + "  ");
            } else {
                System.out.print(list.get(i).getPicture().getPictureName() + "  ");
            }

        }

    }

    public static boolean isGameOver(List<Card> cardsList) {
        for (Card card : cardsList) {
            if (card.getCardSide() == CardSide.REVERSE) {
                return false;
            }
        }
        return true;
    }


}


