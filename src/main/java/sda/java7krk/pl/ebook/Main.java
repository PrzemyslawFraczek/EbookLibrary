package sda.java7krk.pl.ebook;

import com.sun.corba.se.pept.transport.ContactInfoList;
import sda.java7krk.pl.ebook.View.CliSystemInterface;
import sda.java7krk.pl.ebook.View.StartPanel;
import sda.java7krk.pl.ebook.domena.UserStorage;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("user.txt");
        UserStorage userStorage = new UserStorage(file);


        CliSystemInterface systemInterface = new CliSystemInterface();
        new StartPanel(userStorage, systemInterface).startPanel();
    }
}
