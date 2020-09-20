package pl.project.memorygame.loginAndRegistration;

public class UserExistsException extends Exception {

    UserExistsException(String email) {
        super("User already exists" + email);
    }
}
