package pl.project.memorygame.engine;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private Map<UUID, Game> games = new HashMap<>();


    public GameService() {
    }

    public Game getGame(UUID gameId) {
        return games.get(gameId);
    }

    public UUID newGame(){
        Game game = new Game();
        this.games.put(game.getUuid(), game);
        return game.getUuid();
    }

}


