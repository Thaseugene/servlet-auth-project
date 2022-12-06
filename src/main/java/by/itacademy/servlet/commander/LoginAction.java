package by.itacademy.servlet.commander;

import java.io.IOException;

import by.itacademy.servlet.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements Action {

	private static final String LOGIN_TEMPLATE = "login";
	private static final String PASSWORD_TEMPLATE = "password";
	private static final String ERROR_TEMPLATE = "error";
	private static final String MAIN_PATH = "/main";
	private static final String LOGIN_PATH = "/login.jsp";

	private final UserRepository userRepository;

	public LoginAction() {
		this.userRepository = UserRepository.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter(LOGIN_TEMPLATE);
		String password = req.getParameter(PASSWORD_TEMPLATE);

		if (userRepository.checkIsUserExists(userName, password)) {
			HttpSession session = req.getSession();
			session.setAttribute(LOGIN_TEMPLATE, userName);
			req.getRequestDispatcher(MAIN_PATH).forward(req, resp);
		} else if (userName.isEmpty() || password.isEmpty()) {
			sendOutput(req, "Sorry, some fields are empty", resp);
		} else {
			sendOutput(req, "Sorry, incorrect login or password", resp);
		}
	}

	private void sendOutput(HttpServletRequest req, String output, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute(ERROR_TEMPLATE, output);
		req.getRequestDispatcher(LOGIN_PATH).forward(req, resp);
	}

}
