package com.bag.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bag.Model.UserModel;
import com.bag.dao.UserDAO;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pass = Integer.valueOf(request.getParameter("pin"));
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
//		UserModel user = new UserModel();
//		user.setPin(pass);
//		boolean success = UserDAO.depositVerify(user);
//		long balance = UserDAO.balance;
//		long accno = UserDAO.accno;
		UserModel success = UserDAO.depositVerify(pass);
		
		if(success.getAccno()!=0) {
			request.setAttribute("accno",success.getAccno());
			request.setAttribute("balance",success.getBalance());
			RequestDispatcher rd = request.getRequestDispatcher("depositCompletion.jsp");
			rd.forward(request,response);
		}
		else {
			out.println("<script>alert('Enter pin correctly');</script>");
            out.println("<meta http-equiv='refresh' content='0;URL=deposit.jsp'>");
		}
	}

}
