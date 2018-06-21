package sda.java7krk.pl.ebook.register;

import org.junit.After;
import org.junit.Before;


import sda.java7krk.pl.ebook.domena.UserStorage;
import org.junit.Test;
import sda.java7krk.pl.ebook.View.Response;
import sda.java7krk.pl.ebook.domena.UserStorageFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RegistrationControllerTest {

    private UserStorage users;
    private File file ;
    private UserStorageFactory userStorageFactory =  new UserStorageFactory();

    @Before
    public void setup() {
        file = new File("testUsers.txt");
        users = userStorageFactory.creatorFileUserStorage("testUsers.txt");
    }

    @After
    public void deleteFile() throws Exception {
        Files.deleteIfExists(file.toPath());
    }

    @Test
    public void shuoldRegisterNewUser() throws IOException {
        RegistrationController registrationController = new RegistrationController(users);
        Response rezult = registrationController.register("franklin", "12345555");

        assertEquals(true , rezult.isSuccess());
        assertTrue(users.userExist("franklin"));
    }

    @Test
    public void shuoldReturnErrorWhenPasswordToShor() throws IOException {
        Response rezult = new RegistrationController(users).register("frani" , "123456");

        assertEquals("password is too short" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());
        assertFalse(users.userExist("frani"));
    }

    @Test
    public void shuoldReturnErrorWhenUserExist() throws IOException {



        users.save("aaa" , "12345678");
        Response rezult = new RegistrationController(users).register("aaa" , "12345678");

        assertEquals("User exist, change name or password" , rezult.getMassage());
        assertEquals(false , rezult.isSuccess());

    }

}
