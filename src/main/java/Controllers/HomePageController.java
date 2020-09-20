package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomePageController {

    ModelAndView index(){
        ModelAndView mnv = new ModelAndView("index");
        mnv.addObject("index", nieWiemJakiAtrybutTutaj);
        return mnv;
    }
}
