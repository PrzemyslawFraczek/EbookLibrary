package sda.java7krk.pl.ebook.domena;

import java.io.File;

public class UserStorageFactory {

    public UserStorage createFileUserStorage() {
        File file = new File("user.txt");
        return new FileUserStorage(file);
    }

}
