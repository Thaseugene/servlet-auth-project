package by.itacademy.servlet.actions;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import by.itacademy.servlet.model.User;
import by.itacademy.servlet.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowProfileAction implements IAction {

	private static final String LOGIN_TEMPLATE = "login";
	private static final String USER_TEMPLATE = "user";
	private static final String FORMATTER = "yyyy-MM-dd HH:mm:ss";
	private static final String REG_DATE = "registrationDate";
	private static final String PROFILE_PATH = "/profile.jsp";
	private static final String MAIN_PATH = "/main";

	private final UserRepository userRepository;

	public ShowProfileAction() {
		this.userRepository = UserRepository.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = (String) req.getSession().getAttribute(LOGIN_TEMPLATE);
		if (login != null) {
			Optional<User> userOptional = userRepository.getUserByLogin(login);
			if (userOptional.isPresent()) {
				User user = userOptional.get();
				req.setAttribute(USER_TEMPLATE, user);
				req.setAttribute(REG_DATE, user.getRegisterDate().format(DateTimeFormatter.ofPattern(FORMATTER)));
				req.getRequestDispatcher(PROFILE_PATH).forward(req, resp);
			}
		} else {
			req.getRequestDispatcher(MAIN_PATH).forward(req, resp);
		}

	}

}
