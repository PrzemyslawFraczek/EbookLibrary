package sda.java7krk.pl.ebook;

import sda.java7krk.pl.ebook.View.CliSystemInterface;
import sda.java7krk.pl.ebook.View.StartPanel;
import sda.java7krk.pl.ebook.domena.FileUserStorage;
import sda.java7krk.pl.ebook.domena.UserStorage;
import sda.java7krk.pl.ebook.domena.UserStorageFactory;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        UserStorageFactory userStorageFactory = new UserStorageFactory();
        UserStorage userStorage = userStorageFactory.createFileUserStorage();


        try {
            new StartPanel(userStorage, new CliSystemInterface()).startPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
