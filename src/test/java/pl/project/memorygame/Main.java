package pl.project.memorygame;

import net.minidev.json.JSONUtil;
import pl.project.memorygame.engine.Card;
import pl.project.memorygame.engine.Game;
import pl.project.memorygame.engine.GameService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Card> cardsList = Game.createCardsList(4);
   /*     GameService gameService = new GameService();
        Game game = gameService.getGame();*/
        int counter = 0;
        GameService.showCards(cardsList);
        boolean gameOver = GameService.isGameOver(cardsList);
        while (!gameOver) {

            int a = scanner.nextInt()-1;
            GameService.showCards(cardsList,a);
            int b = scanner.nextInt()-1;
            GameService.showCards(cardsList,b);

            List<Card> pair = GameService.findPair(cardsList, a, b);
            System.out.println();
            System.out.println("-----------");
            GameService.showCards(pair);
            counter++;
            gameOver = GameService.isGameOver(pair);
        }

    }
}
