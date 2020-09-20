package pl.project.memorygame.loginAndRegistration;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.function.Function;

@Slf4j
public class LoginService {

    private final UserDao userDao;

    public LoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean login(LoginDto loginDto) {
        Function<User, Boolean> matchPasswordFunction = user -> user.getPasswordHash().equals(DigestUtils.sha512Hex(loginDto.getPassword()));
        return userDao.findUserByLogin(loginDto.getLogin())
                .map(matchPasswordFunction) //zostanie uruchomiony wtedy kiedy finduserby login zwroci usera
//                .orElse(returnFalse()); // powinno zostac uruchomiome tylko wtedy kiedy nie zostanie zwrocony uzytkownik (teraz uruchamia sie zawsze)
                .orElseGet(()-> returnFalse());
    }

    private boolean returnFalse() {
        log.info("Running resource-heavy method");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
