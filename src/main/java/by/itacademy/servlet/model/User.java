package by.itacademy.servlet.model;

import java.time.LocalDateTime;

public class User {

    private final String id;
    private final String login;
    private final String userName;
    private final String userSurname;
    private final LocalDateTime registerDate;
    
    
    private String password;

    public User(String id, String login, String password, String userName, String userSurname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userName = userName;
		this.userSurname = userSurname;
		this.registerDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

	public String getUserName() {
		return userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	
	
    
    
    
}
