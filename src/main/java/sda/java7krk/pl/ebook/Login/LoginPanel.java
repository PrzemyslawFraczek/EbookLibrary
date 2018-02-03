package sda.java7krk.pl.ebook.Login;

import sda.java7krk.pl.ebook.View.Response;

import java.util.Scanner;

public class LoginPanel {
    private LoginController loginController;

    public LoginPanel(LoginController loginController) {
        this.loginController = loginController;
    }

    Scanner scanner = new Scanner(System.in);

    public String login() {
        System.out.println("Give me Login");
        String login = scanner.next();
        System.out.println("Give me password");
        String pasw = scanner.next();
        Response response = loginController.checkLogin(login, pasw);
        return response.getMassage();
    }
}
