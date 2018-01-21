package sda.java7krk.pl.ebook;

import sda.java7krk.pl.ebook.View.StartPanel;
import sda.java7krk.pl.ebook.domena.UserStorage;

public class Main {
    public static void main(String[] args) {
        UserStorage userStorage = new UserStorage();


        new StartPanel(userStorage).startPanel();
    }
}
