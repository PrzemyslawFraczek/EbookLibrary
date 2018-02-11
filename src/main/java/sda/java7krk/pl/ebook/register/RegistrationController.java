package sda.java7krk.pl.ebook.register;



import sda.java7krk.pl.ebook.domena.UserStorage;
import sda.java7krk.pl.ebook.View.Response;

import java.io.*;

public class RegistrationController {
    private UserStorage users;


    public RegistrationController(UserStorage users) {
        this.users = users;
    }

    public Response register(String name, String password) throws IOException {
        Response response = new Response();

        if (isPasswordTooShort(password)) {
            response.setSuccess(false);
            response.setMassage("password is too short");

        }else if (users.userExist(name)) {
            response.setSuccess(false);
            response.setMassage("User exist, change name or password");


        }  else {
            response.setSuccess(true);
            response.setMassage("Well done !!");
            users.save(name,password);
        }
        return response;
    }

    private boolean isPasswordTooShort(String password) {
        return password.length() < 7;
    }

}
