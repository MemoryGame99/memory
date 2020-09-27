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


    ModelAndView gamePage() {
        ModelAndView modelAndView = new ModelAndView();
        Game game = new Game();
        List<Card> cardsList = game.getCards();


        modelAndView.addObject("cards",cardsList );

        return modelAndView;
    }

    @GetMapping (value = "/main")
    public String index(Model model){

        model.addAttribute("game", gameService.getGame());
        return "main";
    }
    @PostMapping(value = "/main/{cardIndex}")
    public String index(Model model, @PathVariable Integer cardIndex){

        gameService.getGame().checkCard(cardIndex);

        return "redirect:/main";
    }
}
