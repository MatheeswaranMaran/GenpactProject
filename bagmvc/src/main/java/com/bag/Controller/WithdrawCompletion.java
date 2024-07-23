package com.bag.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bag.Model.UserModel;
import com.bag.dao.UserDAO;

/**
 * Servlet implementation class WithdrawCompletion
 */
@WebServlet("/WithdrawCompletion")
public class WithdrawCompletion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accno = Long.valueOf(request.getParameter("accno"));
		long balance = Long.valueOf(request.getParameter("balance"));
		long amount = Long.valueOf(request.getParameter("amount"));
		boolean success = UserDAO.withdrawCompletion(amount, accno, balance);
		UserModel um = UserDAO.getBalance(accno);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if(success) {
			response.sendRedirect("UserPage.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("balance", um.getBalance());
		}
		else {
			out.println("<script>alert('Withdraw amount is greater than the balance');</script>");
            out.println("<meta http-equiv='refresh' content='0;URL=UserPage.jsp'>");
		}
	}
}
