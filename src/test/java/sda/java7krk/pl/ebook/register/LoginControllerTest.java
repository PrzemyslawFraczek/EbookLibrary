package sda.java7krk.pl.ebook.register;

import org.junit.After;
import org.junit.Before;
import sda.java7krk.pl.ebook.Login.LoginController;
import sda.java7krk.pl.ebook.domena.User;
import sda.java7krk.pl.ebook.domena.UserStorage;
import org.junit.Test;
import sda.java7krk.pl.ebook.View.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginControllerTest {
    private static final String GOOD_LOGIN = "goodLogin";
    private static final String GOOD_PASSWORD = "goodPassword";
    private static final String WRONG_PASSWORD = "wrongPassword";
    private static final String WRONG_LOGIN = "wrongLogin";
    private static final String PASSWORD_OR_LOGIN_INCORECT = "Password or login incorect";

    private UserStorage users;
    private LoginController loginController;
    private File file ;

    @Before
    public void setup() {

        users = new UserStorage(file = new File("testUsers.txt"));
        loginController = new LoginController(users);
    }

    @After
    public void delete(){
        file.deleteOnExit();
    }


    @Test
    public void shouldReturnErrorWhenPasswordWrong() throws FileNotFoundException {
        Response result = loginController.checkLogin(GOOD_LOGIN, WRONG_PASSWORD);

        assertEquals(PASSWORD_OR_LOGIN_INCORECT, result.getMassage());
        assertEquals(false, result.isSuccess());
    }

    @Test
    public void shouldReturnErrorWhenLoginIsWrong() throws FileNotFoundException {

        Response result = loginController.checkLogin(WRONG_LOGIN, GOOD_PASSWORD);

        assertEquals(PASSWORD_OR_LOGIN_INCORECT, result.getMassage());
        assertEquals(false, result.isSuccess());
    }

    @Test
    public void shouldReturnTrueWhenLoginSucces() throws IOException {
        users.save(GOOD_LOGIN , GOOD_PASSWORD);
        Response result = loginController.checkLogin(GOOD_LOGIN, GOOD_PASSWORD);

        assertEquals(true, result.isSuccess());
        assertEquals("Welcome in system", result.getMassage());
    }

}
