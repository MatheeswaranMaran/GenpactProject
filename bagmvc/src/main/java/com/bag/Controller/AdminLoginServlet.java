package com.bag.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bag.Model.AdminModel;
import com.bag.dao.AdminDAO;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("un");
		String pass = request.getParameter("pwd");
		AdminModel admin = new AdminModel();
		admin.setPassword(pass);
		admin.setUsername(name);
		boolean success = AdminDAO.login(admin);
		if(success){		
			response.sendRedirect("AdminPage.jsp");
			
		}
		else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script>alert('Enter valid credentials');</script>");
			out.println("<meta http-equiv='refresh' content='0;URL=AdminLogin.jsp'>");
		}
	}

}