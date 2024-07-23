package com.bag.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bag.Model.AdminModel;
import com.bag.Model.UserModel;
import com.bag.dao.AdminDAO;
import com.bag.dao.UserDAO;

/**
 * Servlet implementation class ModifyRequest
 */
@WebServlet("/ModifyRequest")
public class ModifyRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accno = Long.valueOf(request.getParameter("accno"));
		int pass = Integer.valueOf(request.getParameter("pin"));
		
//		UserModel user = new UserModel();
//		user.setAccno(accno);
//		user.setPin(pass);
//		long ac = UserDAO.accnom;
		
		UserModel success = UserDAO.modifyRequest(accno, pass);
		if(success.getAccno()!=0){		
			request.setAttribute("accno", success.getAccno());
			response.sendRedirect("modifyCompletion.jsp");
			
		}
		else {
			response.sendRedirect("modifyRequest.jsp?msg=err");
		}
	}

}
