package by.itacademy.servlet.actions;

import java.io.IOException;

import by.itacademy.servlet.actions.enums.HttpMethodType;
import by.itacademy.servlet.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements IAction {

	private static final String LOGIN_TEMPLATE = "login";
	private static final String PASSWORD_TEMPLATE = "password";
	private static final String ERROR_TEMPLATE = "error";
	private static final String MAIN_PATH = "/profile";
	private static final String LOGIN_PATH = "/login.jsp";

	private final UserRepository userRepository;

	public LoginAction() {
		this.userRepository = UserRepository.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equals(HttpMethodType.POST.toString())) {
			executePost(req, resp);
		} else {
			executeGet(req, resp);
		}

	}

	private void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter(LOGIN_TEMPLATE);
		String password = req.getParameter(PASSWORD_TEMPLATE);

		if (userRepository.checkIsUserExists(login, password)) {
			HttpSession session = req.getSession();
			session.setAttribute(LOGIN_TEMPLATE, login);
			req.getRequestDispatcher(MAIN_PATH).forward(req, resp);
		} else if (login == null || password == null) {
			req.getRequestDispatcher(LOGIN_PATH).forward(req, resp);
		} else if (login.isEmpty() || password.isEmpty()) {
			sendOutput(req, "Sorry, some fields are empty", resp);
		} else {
			sendOutput(req, "Sorry, incorrect login or password", resp);
		}
	}

	private void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(LOGIN_PATH).forward(req, resp);
	}

	private void sendOutput(HttpServletRequest req, String output, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute(ERROR_TEMPLATE, output);
		req.getRequestDispatcher(LOGIN_PATH).forward(req, resp);
	}

}
