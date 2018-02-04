package sda.java7krk.pl.ebook;

import sda.java7krk.pl.ebook.View.StartPanel;
import sda.java7krk.pl.ebook.domena.UserStorage;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserStorage userStorage = new UserStorage(new File("user.txt"));


        new StartPanel(userStorage).startPanel();
    }
}
