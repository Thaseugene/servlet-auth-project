package by.itacademy.servlet.actions;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainPageInfoAction implements IAction{
	
    private static final String LOGIN_TEMPLATE = "login";
    private static final String ANON_TEMPLATE = "Anonimous";
    private static final String OUTPUT_TEMPLATE = "output";
    private static final String MAIN_PAGE_PATH = "/start.jsp";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        String userName = (String) req.getSession().getAttribute(LOGIN_TEMPLATE);
        if (userName != null) {
            sendOutput(req, resp, userName);
        } else {
            sendOutput(req, resp, ANON_TEMPLATE);  
        }
        
	}

	private void sendOutput(HttpServletRequest req, HttpServletResponse resp, String userName)
			throws ServletException, IOException {
		req.setAttribute(OUTPUT_TEMPLATE, userName);
		req.getRequestDispatcher(MAIN_PAGE_PATH).forward(req, resp);
	}

}
