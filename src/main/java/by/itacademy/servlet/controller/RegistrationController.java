package by.itacademy.servlet.controller;

import by.itacademy.servlet.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrationController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UserRepository userRepository;

    public RegistrationController() {
        this.userRepository = UserRepository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            req.setAttribute("error", "Some fields are empty");
            doGet(req, resp);
        } else if (!password.equalsIgnoreCase(confirmPassword)) {
            req.setAttribute("error", "Password fields are not equal");
            doGet(req, resp);
        } else if (userRepository.checkIsUserExists(userName)) {
            req.setAttribute("error", "User with this login already exists");
            doGet(req, resp);
        } else {
            userRepository.addUser(userName, password);
            req.setAttribute("output", "Account successfully created");
            doGet(req, resp);
        }

    }
}
