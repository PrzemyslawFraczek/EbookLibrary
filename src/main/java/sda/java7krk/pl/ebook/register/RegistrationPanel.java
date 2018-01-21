package sda.java7krk.pl.ebook.register;

import sda.java7krk.pl.ebook.View.Response;

import java.util.Scanner;

public class RegistrationPanel {
    private RegistrationController registrationController;


    Scanner scanner = new Scanner(System.in);

    public RegistrationPanel(RegistrationController registrationController) {
        this.registrationController = registrationController;
    }

    public String registration(){
        System.out.println("Give me Login");
        String login = scanner.next();
        System.out.println("Give me password");
        String pasw = scanner.next();
        Response response = registrationController.register(login, pasw);
        return response.getMassage();
    }
}
