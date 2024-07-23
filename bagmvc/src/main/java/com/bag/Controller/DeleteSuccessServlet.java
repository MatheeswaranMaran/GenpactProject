package com.bag.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bag.Model.UserModel;
import com.bag.dao.AdminDAO;

/**
 * Servlet implementation class DeleteSuccessServlet
 */
@WebServlet("/DeleteSuccessServlet")
public class DeleteSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accno = Long.valueOf(request.getParameter("accno"));
		UserModel user = new UserModel();
		user.setAccno(accno);
		boolean success = AdminDAO.deleteUser(user);
		if(success) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script>alert('Successfully Deleted')</script>");
			out.println("<meta http-equiv='refresh' content='0;URL=AdminPage.jsp'>");
		}
	}

}
