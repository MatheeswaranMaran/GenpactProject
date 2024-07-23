package com.bag.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bag.Model.UserModel;
import com.bag.dao.AdminDAO;




@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accno = Long.valueOf(request.getParameter("accno"));
		PrintWriter out = response.getWriter();
//		UserModel user = new UserModel();
//		user.setAccno(accno);
//		boolean success = AdminDAO.viewUser(user);
//		String name = AdminDAO.name2;
//		long accountno = AdminDAO.accno2;
//		String email = AdminDAO.email2;
//		String address = AdminDAO.address2;
//		long mobno = AdminDAO.mobno2;
//		String acctype = AdminDAO.acctype2;
//		String dob = AdminDAO.dob2;
//		long aadhaar = AdminDAO.aadhaar2;
		UserModel success = AdminDAO.viewUser(accno);
		if(success.getAccno()!=0) {
			request.setAttribute("name", success.getFullname());
			request.setAttribute("accno",success.getAccno());
			request.setAttribute("email", success.getEmail());
			request.setAttribute("address", success.getAddress());
			request.setAttribute("mobno", success.getPhno());
			request.setAttribute("acctype",success.getAccType());
			request.setAttribute("dob", success.getDob());
			request.setAttribute("aadhaar", success.getAadhaar());
			RequestDispatcher rd = request.getRequestDispatcher("viewUsers.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("<script>alert('Account Number not exists');</script>");
			out.println("<meta http-equiv='refresh' content='0;URL=AdminPage.jsp'>");
		}
	}


}