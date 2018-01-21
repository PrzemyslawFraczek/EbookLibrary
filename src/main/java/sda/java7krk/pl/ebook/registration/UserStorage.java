package sda.java7krk.pl.ebook.registration;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private Map<String ,User > UserList = new HashMap<String, User>();

    public void add(User user) {
        UserList.put(user.getName(), user);
    }

    public boolean userExist(String name) {
        return UserList.containsKey(name);
    }
}
