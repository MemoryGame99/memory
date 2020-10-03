package pl.project.memorygame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.project.memorygame.engine.Card;
import pl.project.memorygame.engine.Game;
import pl.project.memorygame.engine.GameService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
//@SessionAttributes("game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping (value = "/")
    public String index(Model model, HttpSession session){

        UUID gameId = getGameId(session);

        model.addAttribute("game", gameService.getGame(gameId));
        return "main";
    }

    private UUID getGameId(HttpSession session) {
        UUID gameId = (UUID) session.getAttribute("gameId");

        if(gameId == null) {
            gameId = gameService.newGame();
            session.setAttribute("gameId", gameId);
        }
        return gameId;
    }

    @PostMapping(value = "/check/{cardIndex}")
    public String index(Model model, @PathVariable Integer cardIndex, HttpSession session){

        UUID gameId = getGameId(session);
        gameService.getGame(gameId).checkCard(cardIndex);

        return "redirect:/";
    }

    @GetMapping(value = "/new")
    public String index2(Model model,HttpSession session){

        UUID uuid = gameService.newGame();
        session.setAttribute("gameId", uuid);

        return "redirect:/";
    }
}
