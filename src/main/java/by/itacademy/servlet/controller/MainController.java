package by.itacademy.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import by.itacademy.servlet.actions.ActionCommander;
import by.itacademy.servlet.actions.enums.HttpMethodType;

public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final ActionCommander actionCommander;

	private final static String ACTION_TYPE_TEMPLATE = "actionType";

	public MainController() {
		this.actionCommander = ActionCommander.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equals(HttpMethodType.GET.toString())) {
			actionCommander.getActions().get(getServletConfig().getInitParameter(ACTION_TYPE_TEMPLATE)).execute(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equals(HttpMethodType.POST.toString())) {
			actionCommander.getActions().get(getServletConfig().getInitParameter(ACTION_TYPE_TEMPLATE)).execute(req, resp);
		}
	}
	
	
	
	

}
