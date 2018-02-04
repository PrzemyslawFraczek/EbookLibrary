package sda.java7krk.pl.ebook.Login;

import sda.java7krk.pl.ebook.View.Response;
import sda.java7krk.pl.ebook.domena.UserStorage;

import java.io.File;
import java.io.FileNotFoundException;

public class LoginController {
    private UserStorage users ;


    public LoginController(UserStorage users ) {
        this.users = users;
    }


    public Response checkLogin(String name, String password) throws FileNotFoundException {


        Response response = new Response();

        if(users.userExist(name , password)) {
            response.setSuccess(true);
            response.setMassage("Welcome in system");
        }else {
            response.setSuccess(false);
            response.setMassage("Password or login incorect");
        }
        return response;

    }
}
