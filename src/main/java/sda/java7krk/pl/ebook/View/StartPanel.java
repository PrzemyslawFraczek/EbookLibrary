package sda.java7krk.pl.ebook.View;

import sda.java7krk.pl.ebook.Login.LoginController;
import sda.java7krk.pl.ebook.Login.LoginPanel;
import sda.java7krk.pl.ebook.domena.UserStorage;
import sda.java7krk.pl.ebook.register.RegistrationController;
import sda.java7krk.pl.ebook.register.RegistrationPanel;

import java.io.IOException;
import java.util.Scanner;

public class StartPanel {
    private LoginPanel loginPanel;
    private RegistrationPanel registrationPanel;

    private Scanner scanner = new Scanner(System.in);
    private final SystemInterface systemInterface;

    public StartPanel(UserStorage userStorage, SystemInterface systemInterface) {
        this.systemInterface = systemInterface;
        RegistrationController registrationController = new RegistrationController(userStorage);
        registrationPanel = new RegistrationPanel(registrationController, this.systemInterface);
        LoginController loginController = new LoginController(userStorage);
        loginPanel = new LoginPanel(loginController, this.systemInterface);
    }

    public void startPanel() throws IOException {
        int answer = 0;
        do {
            systemInterface.display("1 - sing in ");
            systemInterface.display("2 - login");
            systemInterface.display("3 - Exit");
            answer = systemInterface.nextInt();

            if (answer == 1) {
                systemInterface.display(registrationPanel.registration().getMassage());

            }
            if (answer == 2) {
                systemInterface.display(loginPanel.login());
            }

        } while (answer != 3);


    }

    private void display(String s) {
        System.out.println(s);
    }

}
