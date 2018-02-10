package sda.java7krk.pl.ebook.Login;

import sda.java7krk.pl.ebook.View.CliSystemInterface;
import sda.java7krk.pl.ebook.View.Response;
import sda.java7krk.pl.ebook.View.SystemInterface;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginPanel {
    private LoginController loginController;
    private final SystemInterface systemInterface;

    public LoginPanel(LoginController loginController, SystemInterface systemInterface) {
        this.loginController = loginController;
        this.systemInterface = systemInterface;
    }

    public String login() throws FileNotFoundException {
        systemInterface.display("Give me Login");
        String login = systemInterface.readInformation();
        systemInterface.display("Give me password");
        String pasw = systemInterface.readInformation();
        Response response = loginController.checkLogin(login, pasw);
        return response.getMassage();
    }
}
