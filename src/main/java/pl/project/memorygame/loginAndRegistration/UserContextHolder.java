package pl.project.memorygame.loginAndRegistration;

import org.springframework.stereotype.Service;

@Service //to spowoduje utworzenie przez Spring nowego obiektu (singletona)
public class UserContextHolder {

    private String email;

    public void addUserLogin(String email) {
        this.email = email;
    }

    public String getUserLoggedIn() {
        return email;
    }
}
