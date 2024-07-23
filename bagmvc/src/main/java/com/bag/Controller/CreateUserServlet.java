package com.bag.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bag.Model.UserModel;
import com.bag.dao.AdminDAO;

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname=request.getParameter("fullname");
		String address=request.getParameter("address");
		long phno=Long.valueOf(request.getParameter("phone"));
		String email=request.getParameter("email");
		String accType=request.getParameter("acctype");
		long aadhaar=Long.valueOf(request.getParameter("aadhaar"));
		long balance=Long.valueOf(request.getParameter("balance"));
		String dob=request.getParameter("dob");
		long ac = AdminDAO.isRandom2();
		int pin = AdminDAO.isRandom();
		
		UserModel user=new UserModel();
		user.setFullname(fullname);
		user.setAddress(address);
		user.setAccType(accType);
		user.setBalance(balance);
		user.setDob(dob);
		user.setEmail(email);
		user.setPhno(phno);
		user.setAadhaar(aadhaar);
		user.setAccno(ac);
		user.setPin(pin);
		PrintWriter out=response.getWriter();
		boolean success = AdminDAO.createUser(user);
		if(success) {
			request.setAttribute("name", fullname);
			request.setAttribute("accno",ac);
			request.setAttribute("pin", pin);
			RequestDispatcher rd = request.getRequestDispatcher("createUserSuccess.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
