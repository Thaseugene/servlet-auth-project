package by.itacademy.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class MainController extends HttpServlet {

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
