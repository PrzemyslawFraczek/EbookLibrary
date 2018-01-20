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

        assertEquals("Hasło za krótkie" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());

    }
}
