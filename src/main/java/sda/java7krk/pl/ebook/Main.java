package sda.java7krk.pl.ebook;

import sda.java7krk.pl.ebook.View.CliSystemInterface;
import sda.java7krk.pl.ebook.View.StartPanel;
import sda.java7krk.pl.ebook.domena.UserStorage;
import sda.java7krk.pl.ebook.domena.UserStorageFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserStorageFactory userStorageFactory = new UserStorageFactory();
        UserStorage userStorage = userStorageFactory.creatorFileUserStorage("user.txt");


        CliSystemInterface systemInterface = new CliSystemInterface();
        try {
            new StartPanel(userStorage, systemInterface).startPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
