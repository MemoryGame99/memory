package pl.project.memorygame.loginAndRegistration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private boolean preferEmails;

}
