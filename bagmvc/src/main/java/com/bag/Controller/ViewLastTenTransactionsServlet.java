package com.bag.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bag.dao.UserDAO;
import com.bag.Model.*;

/**
 * Servlet implementation class ViewLastTenTransactionsServlet
 */
@WebServlet("/ViewLastTenTransactionsServlet")
public class ViewLastTenTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accno = Long.valueOf(request.getParameter("accno"));
		List<TransactionModel> list = UserDAO.viewTransaction(accno);
		System.out.println("ListServlet:"+list);
		if(list!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("list",list);
			response.sendRedirect("viewTransactions.jsp");
		}
	}

}
