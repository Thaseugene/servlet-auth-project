package by.itacademy.servlet.storage;

import by.itacademy.servlet.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static UserStorage instance;
    private final Map<String, User> userTable;

    private UserStorage() {
        this.userTable = new HashMap<>();
        init();
    }

    public static UserStorage getInstance() {
        if(instance==null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public Map<String, User> getUserTable() {
        return userTable;
    }

    private void init() {
        userTable.put("user", new User("1", "user", "user", "user", "user"));
    }

}
