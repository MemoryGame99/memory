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

    @GetMapping(value = "/")
    public String start(Model model) {
        List<String> randomPicLinks = GameService.generateRandomPicLinks(4);
        model.addAttribute("randomPics", randomPicLinks);
        return "start";
    }

    @GetMapping(value = "/main")
    public String mainGame(Model model) {

        model.addAttribute("gameCards", gameService.game.getCards());
        model.addAttribute("newTurn", gameService.game.getNewTurn());
        model.addAttribute("victory", gameService.game.isEnded());
        model.addAttribute("moves", gameService.game.getTourCounter());

        return "main";
    }

    @PostMapping(value = "/check/{cardNo}")
    public String nextReveal(@PathVariable Integer cardNo) {

        gameService.playNextMove(cardNo);

        return "redirect:/main";
    }

    @PostMapping(value = "/newTurn")
    public String newTurn() {
        gameService.checkCards();
        return "redirect:/main";
    }

    @PostMapping(value = "/newGame")
    public String newGame() {
        gameService.newGame();
        return "redirect:/main";
    }

    @GetMapping(value = "/newGame")
    public String newGameGet() {
        gameService.newGame();
        return "redirect:/main";
    }

}
