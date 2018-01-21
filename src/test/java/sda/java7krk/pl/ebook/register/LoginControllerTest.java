package sda.java7krk.pl.ebook.register;
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

    @Test
    public void shouldReturnErrorWhenPasswordWrong () {
        LoginController loginController = new LoginController(users);
        users.add(new User("admin", "dwauefuwhu"));
        Response result = loginController.checkLogin("admin", "admin12345");

        assertEquals("Password or login incorect", result.getMassage());
        assertEquals(false, result.isSuccess());
    }
    @Test
    public void shouldReturnErrorWhenLoginIsWrong () {
        LoginController loginController = new LoginController(users);
        users.add(new User("admin", "12345678"));
        Response result = loginController.checkLogin("admin2", "12345678");

        assertEquals("Password or login incorect", result.getMassage());
        assertEquals(false, result.isSuccess());
    }
    @Test
    public void shouldReturnTrueWhenLoginSucces () {
        LoginController loginController = new LoginController(users);
        users.add(new User("admin", "12345678"));
        Response result = loginController.checkLogin("admin", "12345678");

        assertEquals(true, result.isSuccess());
        assertEquals("Welcome in system", result.getMassage());
    }

}
