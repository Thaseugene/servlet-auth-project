package by.itacademy.servlet.actions;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IAction {
	
	void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
