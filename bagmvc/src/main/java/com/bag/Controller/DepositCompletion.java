package com.bag.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bag.Model.UserModel;
import com.bag.dao.UserDAO;

/**
 * Servlet implementation class DepositCompletion
 */
@WebServlet("/DepositCompletion")
public class DepositCompletion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accno = Long.valueOf(request.getParameter("accno"));
		long amount = Long.valueOf(request.getParameter("amount"));
		boolean success = UserDAO.depositCompletion(amount, accno);
		UserModel um = UserDAO.getBalance(accno);
		if(success) {
			response.sendRedirect("UserPage.jsp");
			
			HttpSession session = request.getSession();
			session.setAttribute("balance",um.getBalance());
		}
	}

}
