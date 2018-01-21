package sda.java7krk.pl.ebook.register;

import org.junit.Before;
import sda.java7krk.pl.ebook.Login.LoginController;
import sda.java7krk.pl.ebook.domena.User;
import sda.java7krk.pl.ebook.domena.UserStorage;
import org.junit.Test;
import sda.java7krk.pl.ebook.View.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginControllerTest {
    private UserStorage users = new UserStorage();
    LoginController loginController = new LoginController(users);
    String massageIsCorrect = "Password or login incorect";

    @Before
    public void creatUser() {
        users.add(new User("goodLogin", "goodPassword"));
    }

    @Test
    public void shouldReturnErrorWhenPasswordWrong() {

        Response result = loginController.checkLogin("goodLogin", "wrongPassword");

        assertEquals(massageIsCorrect, result.getMassage());
        assertEquals(false, result.isSuccess());
    }

    @Test
    public void shouldReturnErrorWhenLoginIsWrong() {

        Response result = loginController.checkLogin("wrongLogin", "goodPassword");

        assertEquals(massageIsCorrect, result.getMassage());
        assertEquals(false, result.isSuccess());
    }

    @Test
    public void shouldReturnTrueWhenLoginSucces() {

        Response result = loginController.checkLogin("goodLogin", "goodPassword");

        assertEquals(true, result.isSuccess());
        assertEquals("Welcome in system", result.getMassage());
    }

}
