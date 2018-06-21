package sda.java7krk.pl.ebook.register;

import sda.java7krk.pl.ebook.View.CliSystemInterface;
import sda.java7krk.pl.ebook.View.Response;
import sda.java7krk.pl.ebook.View.SystemInterface;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationPanel {
    private RegistrationController registrationController;


    private Scanner scanner = new Scanner(System.in);
    private final SystemInterface systemInterface;

    public RegistrationPanel(RegistrationController registrationController, SystemInterface systemInterface) {
        this.registrationController = registrationController;
        this.systemInterface = systemInterface;
    }

    public Response registration() throws IOException {
        systemInterface.display("Give me Login");
        String login = systemInterface.readInformation();
        systemInterface.display("Give me password");
        String pasw = systemInterface.readInformation();
        return registrationController.register(login, pasw);
    }
    public void registrationExample() {
        systemInterface.display("Gimme login:");
        String login = systemInterface.readInformation();
        systemInterface.display("Give me password");
        String pasw = systemInterface.readInformation();

        Response response = registrationController.register(login, pasw);

        if (response.isSuccess()) {
            systemInterface.display("God damn, you made it!");
        } else {
            systemInterface.display("You have to try again");
            systemInterface.display(response.getMassage());
        }
    }
    private String readInformation() {
        return scanner.next();
    }
}
