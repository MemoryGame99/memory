package pl.project.memorygame.loginAndRegistration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Slf4j
@Controller
public class ApplicationController {

    private final UserDao userDao = new UserDao();

    private final RegistrationValidator registrationValidator = new RegistrationValidator();
    private final RegistrationService registrationService = new RegistrationService(userDao); //dependency injection
    private final LoginService loginService = new LoginService(userDao); //dependency injection - wstrzykiwanie zaleznosci

    //    private final UserContextHolder userContextHolder = new UserContextHolder();  //bez @Autowired
    @Autowired //to spowoduje wstrzykniecie zaleznosci do obiektu tej klasy, ktory bedzie singletonem
    private UserContextHolder userContextHolder;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    //to jest url na który metoda reaguje - po wejsciu na niego wyswietli sie strona registerPage
    public String getRegisterForm(Model model) { //model zapewniony przez Spring
        log.info("GET method, view register form");
        model.addAttribute("form", new RegistrationDto());
        return "registerPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(RegistrationDto registrationDto, Model model) {
        Map<String, String> validatedResultMap = registrationValidator.validateUserRegistration(registrationDto);
        log.info("Trying to add user, POST method, form data contains number {} of errors", validatedResultMap.size());
        if (validatedResultMap.isEmpty()) {
            try {
                registrationService.register(registrationDto);
            } catch (UserExistsException e) {
                model.addAttribute("userExistsExceptionMessage", e.getMessage());
                model.addAttribute("form", registrationDto);
                return "registerPage";
            }
            log.info("User registered");
            model.addAttribute("form", registrationDto);
            return "registerOk";
        }
        model.addAllAttributes(validatedResultMap);
        model.addAttribute("form", registrationDto);
        return "registerPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("form", new LoginDto());
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginDto loginDto, Model model) {
        boolean ableToLogin = loginService.login(loginDto);
        if (ableToLogin) {
            userContextHolder.addUserLogin(loginDto.getLogin());
            return "index";
        }
        model.addAttribute("form", loginDto);
        model.addAttribute("errorMessage", "Login error");
        return "loginPage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        userContextHolder.addUserLogin(null);
        model.addAttribute("form", new LoginDto());
        return "loginPage";
    }
}