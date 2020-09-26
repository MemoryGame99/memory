package pl.project.memorygame.engine;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    public static Map <UUID, Game> allGames(UUID uuid, Game game){
        Map <UUID, Game> games = new HashMap<>();
        games.put(uuid, game);

        return games;
    }


    public static boolean findPair(List<Integer> listOfPairs, int firstField, int secondField) {
        if (listOfPairs.get(firstField).equals(listOfPairs.get(secondField))) {
            listOfPairs.remove(firstField);
            listOfPairs.add(firstField, 0);
            listOfPairs.remove(secondField);
            listOfPairs.add(secondField, 0);
            return true;
        }
        return false;

    }


    public static void showPictures(List<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 4 == 0) {
                System.out.println(" ");
            }
            System.out.print(list.get(i).getPicture().getPictureName() + " ");

        }

    }

    public static void showBoard(List<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 4 == 0) {
                System.out.println(" ");
            }
            System.out.print(list.get(i).getCardIndex() + " ");
        }

    }
}


