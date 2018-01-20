package sda.java7krk.pl.ebook.registration;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RegistrationControllerTest {
    @Test
    public void shuoldRegisterNewUser()
    {
        Response rezult = new RegistrationController().register("franklin", "12345555");

        assertEquals(true , rezult.isSuccess());
    }

    @Test
    public void shuoldReturnErrorWhenPasswordToShor() {
        Response rezult = new RegistrationController().register("frani" , "123456");

        assertEquals("password is too short" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());

    }

    @Test
    public void shuoldReturnErrorWhenUserExist() {

        Response rezult = new RegistrationController().register("aaa" , "12345678");

        assertEquals("User exist, change name or password" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());

    }


}
