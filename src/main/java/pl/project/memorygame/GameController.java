package pl.project.memorygame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.memorygame.engine.Card;
import pl.project.memorygame.engine.Game;
import pl.project.memorygame.engine.GameService;

import java.util.List;

@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }



    @GetMapping (value = "/")
    public String index(Model model){

        model.addAttribute("game", gameService.getGame());
        return "main";
    }
    @PostMapping(value = "/check/{cardIndex}")
    public String index(Model model, @PathVariable Integer cardIndex){

        gameService.getGame().checkCard(cardIndex);

        return "redirect:/";
    }

    @GetMapping(value = "/new")
    public String index2(Model model){

        gameService.newGame();

        return "redirect:/";
    }
}
