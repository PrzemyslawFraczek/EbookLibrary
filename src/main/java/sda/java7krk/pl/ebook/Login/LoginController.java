package sda.java7krk.pl.ebook.Login;

import sda.java7krk.pl.ebook.View.Response;
import sda.java7krk.pl.ebook.domena.UserStorage;

public class LoginController {

    private UserStorage users ;

    public LoginController(UserStorage users) {
        this.users = users;
    }


    public Response checkLogin(String name, String password) {

        Response response = new Response();
        if (isPasswordTooShort(password)) {
            response.setSuccess(false);
            response.setMassage("password is too short");

        } else if (isUserExist(name)) {
            response.setSuccess(true);
            response.setMassage("You are in system :)");


        } else {
            response.setSuccess(false);
            response.setMassage("User not exist , check your password or login ! ");


        }
        return response;

    }

    private boolean isUserExist(String name) {
        return users.userExist(name);
    }

    private boolean isPasswordTooShort(String password) {
        return password.length() < 7;
    }
}
