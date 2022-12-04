package by.itacademy.servlet.repository;

import by.itacademy.servlet.model.User;
import by.itacademy.servlet.storage.UserStorage;

import java.util.UUID;

public class UserRepository {

    private static UserRepository instance;
    private final UserStorage userStorage;

    private UserRepository() {
        this.userStorage = UserStorage.getInstance();
    }

    public static UserRepository getInstance() {
        if(instance==null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(String userName, String password) {
        String id = UUID.randomUUID().toString();
        userStorage.getUserTable().put(userName, new User(id, userName, password));
    }

    public boolean checkIsUserExists(String userName) {
        return userStorage.getUserTable().containsKey(userName);
    }

    public boolean checkIsUserExists(String userName, String userPassword) {
        return checkIsUserExists(userName) &&
                userStorage.getUserTable()
                        .get(userName)
                        .getPassword()
                        .equals(userPassword);
    }


}
