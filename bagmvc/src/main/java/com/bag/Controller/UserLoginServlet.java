package com.bag.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bag.Model.UserLoginModel;
import com.bag.Model.UserModel;
import com.bag.dao.AdminDAO;
import com.bag.dao.UserDAO;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accno = request.getParameter("accno");
		String pinno = request.getParameter("pin");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		long ac = Long.valueOf(accno);
		int pin = Integer.valueOf(pinno); 
//		UserModel user = new UserModel();
//		user.setAccno(ac);
//		user.setPin(pin);
//		
//		boolean success = UserDAO.login(user);
//		String name = UserDAO.namel;
//		long accountno = UserDAO.accountnol;
//		String email = UserDAO.emaill;
//		String address = UserDAO.addressl;
//		long mobno = UserDAO.mobnol;
//		String acctype = UserDAO.acctypel;
//		String dob = UserDAO.dobl;
//		long aadhaar = UserDAO.aadhaarl;
//		long balance = UserDAO.balancel;
		
		UserModel success = UserDAO.login(ac, pin);
		
		
		if(success.getAccno()!=0) {
			HttpSession session = request.getSession();
			session.setAttribute("name", success.getFullname());
			session.setAttribute("accno", Long.toString(success.getAccno()));
			session.setAttribute("email", success.getEmail());
			session.setAttribute("address",success.getAddress());
			session.setAttribute("mobno", success.getPhno());
			session.setAttribute("acctype", success.getAccType());
			session.setAttribute("dob", success.getDob());
			session.setAttribute("aadhaar", success.getAadhaar());
			session.setAttribute("balance", success.getBalance());
			RequestDispatcher rd = request.getRequestDispatcher("UserPage.jsp");
			rd.forward(request, response);
			
		}
		else {
			out.println(ac);
			response.sendRedirect("UserLogin.jsp?msg=err");
		}

	}

}
