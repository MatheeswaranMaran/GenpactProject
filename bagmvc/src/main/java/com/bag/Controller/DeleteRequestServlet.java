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

/**
 * Servlet implementation class deleteRequestServlet
 */
@WebServlet("/DeleteRequestServlet")
public class DeleteRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accno = Long.valueOf(request.getParameter("accno"));
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		UserModel success = AdminDAO.deleteRequest(accno);
		
		if(success.getAccno()!=0) {
			request.setAttribute("name",success.getFullname());
			request.setAttribute("accno",success.getAccno());
			request.setAttribute("acctype",success.getAccType());
			RequestDispatcher rd = request.getRequestDispatcher("deleteUserDetails.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("<script>alert('Account Number not exists');</script>");
			out.println("<meta http-equiv='refresh' content='0;URL=AdminPage.jsp'>");
		}
	}

}
