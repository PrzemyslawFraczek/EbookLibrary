package sda.java7krk.pl.ebook.registration;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class RegistrationControllerTest {
    private List<User> users = new ArrayList<User>();

    @Test
    public void shuoldRegisterNewUser()
    {
        Response rezult = new RegistrationController(users).register("franklin", "12345555");

        assertEquals(true , rezult.isSuccess());
    }

    @Test
    public void shuoldReturnErrorWhenPasswordToShor() {
        Response rezult = new RegistrationController(users).register("frani" , "123456");

        assertEquals("password is too short" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());

    }

    @Test
    public void shuoldReturnErrorWhenUserExist() {


        users.add(new User("aaa" , "12345678"));

        Response rezult = new RegistrationController(users).register("aaa" , "12345678");

        assertEquals("User exist, change name or password" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());

    }


}
