package sda.java7krk.pl.ebook.domena;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private Map<String, User> users = new HashMap<String, User>();

//
//    public User[] mapToArray() {
//        User[] arrayUsers = new User[users.size()];
//        for(Map.Entry<String, User> entry : users.entrySet()) {
//            entry.getValue();
//        }
//
//    }
    public void add(User user) {
        users.put(user.getName(), user);
    }

    public boolean userExist(String name) {
        return users.containsKey(name);

    }

    public boolean userExist(String name, String password) {
        if (userExist(name)) {
            return users.get(name).getPassword().equals(password);
        }
        return false;
    }


}
