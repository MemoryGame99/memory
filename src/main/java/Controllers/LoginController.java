package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    ModelAndView loginPage(){
        ModelAndView mnv = new ModelAndView("login");
        mnv.addObject("login", tutajKlasaLoginDTO);
        return mnv;
    }
}
