package sda.java7krk.pl.ebook.domena;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private Map<String , User> users = new HashMap<String, User>();

    public void add(User user) {
        users.put(user.getName(), user);
    }

    public boolean userExist(String name) {
        return users.containsKey(name);

    }
    public boolean pswdCorrect(String name, String password) {
        return users.get(name).getPassword().equals(password);
    }
}
