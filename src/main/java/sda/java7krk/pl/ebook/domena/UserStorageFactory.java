package sda.java7krk.pl.ebook.domena;

import java.io.File;

public class UserStorageFactory {
    public UserStorage creatorFileUserStorage(String pathname) {
        File file = new File(pathname);
        return new FileUserStorage(file);
    }
}
