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
import com.bag.dao.AdminDAO;

@WebServlet("/ModifyRequestUserServlet")

public class ModifyRequestUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accno = request.getParameter("accno");
		long ac = Long.valueOf(accno);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		UserModel success = AdminDAO.modifyRequestUser(ac);
		if(success.getAccno()!=0) {
			request.setAttribute("name", success.getFullname());
			request.setAttribute("accno",success.getAccno());
			request.setAttribute("email", success.getEmail());
			request.setAttribute("address", success.getAddress());
			request.setAttribute("mobno", success.getPhno());
			request.setAttribute("acctype",success.getAccType());
			request.setAttribute("dob", success.getDob());
			request.setAttribute("aadhaar", success.getAadhaar());
			RequestDispatcher rd = request.getRequestDispatcher("modifyUserDetails.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("<script>alert('Account Number not exists');</script>");
			out.println("<meta http-equiv='refresh' content='0;URL=AdminPage.jsp'>");
		}
	}

}
