package pl.project.memorygame.loginAndRegistration;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class RegistrationService {

    private final UserDao userDao;

    public RegistrationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(RegistrationDto registrationDto) throws UserExistsException {
        if (userDao.checkIfUserExists(registrationDto)) {
            throw new UserExistsException(registrationDto.getEMail());
        }
        User user = User.builder()
                .uuid(UUID.randomUUID())
                .firstName(registrationDto.getFirstName())
                .lastName(registrationDto.getLastName())
                .eMail(registrationDto.getEMail())
                .passwordHash(DigestUtils.sha512Hex(registrationDto.getPassword()))
                .build();

        userDao.addUser(user);

    }
}
