package by.itacademy.servlet.commander;

import java.util.HashMap;
import java.util.Map;


public class ActionCommander {
	
	private static ActionCommander instance;
	
	private final Map<String, Action> actions;

	private ActionCommander() {
		this.actions = new HashMap<>();
		init();
	}
	
	public static ActionCommander getInstance() {
        if(instance==null) {
            instance = new ActionCommander();
        }
        return instance;
	}

	public Map<String, Action> getActions() {
		return actions;
	}
	
	private void init() {
		actions.put("login", new LoginAction());
		actions.put("register", new RegistrationAction());
	}	

}
