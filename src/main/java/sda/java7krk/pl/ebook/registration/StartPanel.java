package sda.java7krk.pl.ebook.registration;

import java.util.Scanner;

public class StartPanel {
    private RegistrationController registrationController;

    Scanner scanner = new Scanner(System.in);

    public StartPanel(UserStorage userStorage) {
        registrationController = new RegistrationController(userStorage);
    }

    public void startPanel () {
        int answer = 0;
        do {
            System.out.println("1 - sing in ");
            System.out.println("2 - login");
            System.out.println("3 - Exit");
            answer = scanner.nextInt();

            if (answer == 1) {
                System.out.println("Give me Login");
                String login = scanner.next();
                System.out.println("Give me password");
                String pasw = scanner.next();
                Response response = registrationController.register(login, pasw);
                System.out.println(response.getMassage());

            }
            if (answer == 2) {
                System.out.println("Give me Login");
                String login = scanner.next();
                System.out.println("Give me password");
                String pasw = scanner.next();

            }
        }while(answer != 3);

    }

}
