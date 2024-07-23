package com.bag.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bag.dao.UserDAO;

/**
 * Servlet implementation class CloseCompletion
 */
@WebServlet("/CloseCompletion")
public class CloseCompletion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accno = Long.valueOf(request.getParameter("accno"));
		boolean success = UserDAO.closeCompletion(accno);
		if(success) {
			response.sendRedirect("LogoutUserServlet");
		}
	}
} 
