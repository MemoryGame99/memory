package pl.project.memorygame;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.memorygame.engine.Game;

@Controller
@RequestMapping("/main")
public class GameController {

    private final Game game;

    public GameController() {
        this.game = new Game();
    }

    ModelAndView gamePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gra", new Game());

        return modelAndView;
    }
}
