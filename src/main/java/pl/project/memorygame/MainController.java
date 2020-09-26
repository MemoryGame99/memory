package pl.project.memorygame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class MainController {

    //@GetMapping(value = "/main")
    public String index(Model model){
        String[] myList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        model.addAttribute("cards2", myList);
        return "main";
    }
}
