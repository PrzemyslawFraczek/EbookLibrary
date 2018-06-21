package sda.java7krk.pl.ebook.domena;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserStorage {
    void save(String name, String password) throws IOException;

    boolean userExist(String name) throws FileNotFoundException;

    boolean userExist(String name, String password) throws FileNotFoundException;
}
