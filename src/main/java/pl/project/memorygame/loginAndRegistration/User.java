package pl.project.memorygame.loginAndRegistration;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

public class User {

    private UUID uuid;

    private String firstName;
    private String lastName;
    private String eMail;
    private String passwordHash;

    private boolean preferEmails;

}
