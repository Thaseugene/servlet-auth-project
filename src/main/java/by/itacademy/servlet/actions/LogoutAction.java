package by.itacademy.servlet.actions;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutAction implements IAction{
	
	private static final String LOGIN_TEMPLATE = "login";
	private static final String MAIN_PATH = "/main";
	private static final String PROFILE_PATH = "/profile";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        String userName = (String) req.getSession().getAttribute(LOGIN_TEMPLATE);
        if (userName != null) {
        	req.getSession(false).invalidate();
        	req.getRequestDispatcher(MAIN_PATH).forward(req, resp);
        } else {
        	req.getRequestDispatcher(PROFILE_PATH).forward(req, resp);
        }
        
	}

}
