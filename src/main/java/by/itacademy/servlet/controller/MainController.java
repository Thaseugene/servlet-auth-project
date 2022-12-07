package by.itacademy.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String LOGIN_TEMPLATE = "login";
    private static final String OUTPUT_TEMPLATE = "error";
    private static final String MAIN_PAGE_PATH = "/mainPage.jsp";

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = (String) req.getSession().getAttribute(LOGIN_TEMPLATE);
        if (userName != null) {
            req.setAttribute(OUTPUT_TEMPLATE, userName);
            getServletContext().getRequestDispatcher(MAIN_PAGE_PATH).forward(req, resp);
        } else {
            req.setAttribute(OUTPUT_TEMPLATE, "Anonymous");
            getServletContext().getRequestDispatcher(MAIN_PAGE_PATH).forward(req, resp);
        }
    }


}
