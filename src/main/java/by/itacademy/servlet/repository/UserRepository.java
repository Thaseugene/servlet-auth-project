package by.itacademy.servlet.repository;

import java.util.Optional;
import java.util.UUID;

import by.itacademy.servlet.model.User;
import by.itacademy.servlet.storage.UserStorage;

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

    public void addUser(String login, String password, String userName, String userSurname) {
        String id = UUID.randomUUID().toString();
        userStorage.getUserTable().put(login, new User(id, login, password, userName, userSurname));
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
    
    public Optional<User> getUserByLogin(String login) {
		return Optional.of(userStorage.getUserTable().get(login));
	}


}
