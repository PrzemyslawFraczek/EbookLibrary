package sda.java7krk.pl.ebook.View;

import sda.java7krk.pl.ebook.Login.LoginController;
import sda.java7krk.pl.ebook.Login.LoginPanel;
import sda.java7krk.pl.ebook.domena.UserStorage;
import sda.java7krk.pl.ebook.register.RegistrationController;
import sda.java7krk.pl.ebook.register.RegistrationPanel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StartPanel {
    private LoginPanel loginPanel;
    private RegistrationPanel registrationPanel;

    private Scanner scanner = new Scanner(System.in);

    public StartPanel(UserStorage userStorage) throws IOException {
        RegistrationController registrationController = new RegistrationController(userStorage);
        registrationPanel = new RegistrationPanel(registrationController);
        LoginController loginController = new LoginController(userStorage);
        loginPanel = new LoginPanel(loginController);
    }

    public void startPanel() throws IOException {
        int answer = 0;
        do {
            System.out.println("1 - sing in ");
            System.out.println("2 - login");
            System.out.println("3 - Exit");
            answer = scanner.nextInt();

            if (answer == 1) {
                System.out.println(registrationPanel.registration().getMassage());

            }
            if (answer == 2) {
                System.out.println(loginPanel.login());
            }

        } while (answer != 3);


    }

}
