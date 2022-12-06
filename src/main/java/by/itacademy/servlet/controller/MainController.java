package by.itacademy.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = (String) req.getSession().getAttribute("login");
        if (userName != null) {
            req.setAttribute("output", userName);
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, resp);
        } else {
            req.setAttribute("output", "Anonymous");
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, resp);
        }
    }


}
