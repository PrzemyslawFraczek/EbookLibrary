package sda.java7krk.pl.ebook.registration;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RegistrationControllerTest {
    private UserStorage users = new UserStorage();

    @Test
    public void shuoldRegisterNewUser()
    {
        RegistrationController registrationController = new RegistrationController(users);
        Response rezult = registrationController.register("franklin", "12345555");

        assertEquals(true , rezult.isSuccess());
        assertTrue(users.userExist("franklin"));
    }

    @Test
    public void shuoldReturnErrorWhenPasswordToShor() {
        Response rezult = new RegistrationController(users).register("frani" , "123456");

        assertEquals("password is too short" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());
        assertFalse(users.userExist("frani"));
    }

    @Test
    public void shuoldReturnErrorWhenUserExist() {


        users.add(new User("aaa" , "12345678"));

        Response rezult = new RegistrationController(users).register("aaa" , "12345678");

        assertEquals("User exist, change name or password" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());

    }


}
