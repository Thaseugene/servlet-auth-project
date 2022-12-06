package by.itacademy.servlet.model;

import java.util.UUID;

public class User {

    private final String id;
    private final String userName;
    private String password;

    public User(String id, String userName, String password) {
        this.id = UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
