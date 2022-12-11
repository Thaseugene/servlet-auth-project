package by.itacademy.servlet.actions;

import java.io.IOException;

import by.itacademy.servlet.actions.enums.HttpMethodType;
import by.itacademy.servlet.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationAction implements IAction {

	private static final String LOGIN_TEMPLATE = "login";
	private static final String PASSWORD_TEMPLATE = "password";
	private static final String NAME_TEMPLATE = "userName";
	private static final String SURNAME_TEMPLATE = "userSurname";
	private static final String PASSWORD_CONFIRM_TEMPLATE = "confirmPassword";
	private static final String ERROR_TEMPLATE = "error";
	private static final String OUTPUT_TEMPLATE = "output";

	private static final String REG_PATH = "/registration.jsp";

	private final UserRepository userRepository;

	public RegistrationAction() {
		this.userRepository = UserRepository.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getMethod().equals(HttpMethodType.POST.toString())) {
			executePost(req, resp);
		} else {
			executeGet(req, resp);
		}

	}

	private void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter(LOGIN_TEMPLATE);
		String password = req.getParameter(PASSWORD_TEMPLATE);
		String userName = req.getParameter(NAME_TEMPLATE);
		String userSurname = req.getParameter(SURNAME_TEMPLATE);
		String confirmPassword = req.getParameter(PASSWORD_CONFIRM_TEMPLATE);

		if (login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || userName.isEmpty()
				|| userSurname.isEmpty()) {
			sendOutput(req, ERROR_TEMPLATE, "Some fields are empty", resp);
		} else if (!password.equalsIgnoreCase(confirmPassword)) {
			sendOutput(req, ERROR_TEMPLATE, "Password fields are not equal", resp);
		} else if (userRepository.checkIsUserExists(login)) {
			sendOutput(req, ERROR_TEMPLATE, "User with this login already exists", resp);
		} else {
			userRepository.addUser(login, password, userName, userSurname);
			sendOutput(req, OUTPUT_TEMPLATE, "Account successfully created", resp);
		}
	}

	private void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(REG_PATH).forward(req, resp);
	}

	private void sendOutput(HttpServletRequest req, String outputTemplate, String output, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute(outputTemplate, output);
		req.getRequestDispatcher(REG_PATH).forward(req, resp);
	}

}
