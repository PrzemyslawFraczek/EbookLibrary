package sda.java7krk.pl.ebook.registration;

public class Main {
    public static void main(String[] args) {
        UserStorage userStorage = new UserStorage();


        new StartPanel(userStorage).startPanel();
    }
}
