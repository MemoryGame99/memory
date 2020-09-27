package pl.project.memorygame.engine;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private Integer gameNumber = 1;
    private Map<Integer, Game> games = new HashMap<>();


    public GameService() {
        Game game = new Game();
        this.games.put(gameNumber, game);

    }

    public static Map<UUID, Game> allGames(UUID uuid, Game game) {
        Map<UUID, Game> games = new HashMap<>();
        games.put(uuid, game);

        return games;
    }

    public Game getGame() {
        return games.get(gameNumber);

    }

    public void newGame(){
        Game game = new Game();
        gameNumber = gameNumber+1 ;
        this.games.put(gameNumber, game);

    }

}


