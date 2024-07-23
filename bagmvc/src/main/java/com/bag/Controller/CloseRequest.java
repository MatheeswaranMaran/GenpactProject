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
 * Servlet implementation class CloseRequest
 */
@WebServlet("/CloseRequest")
public class CloseRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pass = Integer.valueOf(request.getParameter("pin"));
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
//		UserModel user = new UserModel();
//		user.setPin(pass);
//		boolean success = UserDAO.closeVerify(user);
//		long balance = UserDAO.balance3;
//		long accno = UserDAO.accno3;
		UserModel success = UserDAO.closeVerify(pass);
		if(success.getAccno()!=0) {
			if(success.getBalance()==0) {
				request.setAttribute("accno",success.getAccno());
				request.setAttribute("balance",success.getBalance());
				RequestDispatcher rd = request.getRequestDispatcher("closeCompletion.jsp");
				rd.forward(request,response);
			}
			else {
				out.println("<script>alert('Your balance must be zero in order to close your account!!');</script>");
	            out.println("<meta http-equiv='refresh' content='0;URL=UserPage.jsp'>");
			}
			
		}
		else {
			out.println("<script>alert('Enter pin correctly');</script>");
            out.println("<meta http-equiv='refresh' content='0;URL=closeRequest.jsp'>");
		}
	}

}
