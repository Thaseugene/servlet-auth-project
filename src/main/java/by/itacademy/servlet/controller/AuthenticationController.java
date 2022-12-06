package by.itacademy.servlet.controller;

import java.io.IOException;

import by.itacademy.servlet.commander.ActionCommander;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ActionCommander actionCommander;

    private final static String ACTION_TYPE_TEMPLATE = "actionType";

    public AuthenticationController() {
        this.actionCommander = ActionCommander.getInstance();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        actionCommander.getActions().get(req.getParameter(ACTION_TYPE_TEMPLATE)).execute(req, resp);
    }

}
