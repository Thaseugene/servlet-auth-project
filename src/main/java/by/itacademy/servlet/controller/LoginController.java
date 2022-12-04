package by.itacademy.servlet.controller;

import by.itacademy.servlet.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final UserRepository userRepository;

    public LoginController() {
        this.userRepository = UserRepository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String userName = req.getParameter("login");
        String password = req.getParameter("password");

        if (userRepository.checkIsUserExists(userName, password)) {
            HttpSession session=req.getSession();
            session.setAttribute("login",userName);
            req.getRequestDispatcher("/main").forward(req, resp);
        } else if (userName.isEmpty() || password.isEmpty()) {
            req.setAttribute("error", "Sorry, some fields are empty");
            doGet(req, resp);
        } else {
            req.setAttribute("error", "Sorry, incorrect login or password");
            doGet(req, resp);
        }
    }

}
