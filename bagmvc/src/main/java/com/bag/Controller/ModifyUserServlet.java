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
 * Servlet implementation class ModifyUserServlet
 */
@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneStr = request.getParameter("mobno");
        String email = request.getParameter("email");
        String accType = request.getParameter("acctype");
        String aadhaarStr = request.getParameter("aadhaar");
        String dob = request.getParameter("dob");
        String accnoStr = request.getParameter("accno");

        long mobno = 0, aadhaar = 0, accno = 0;

        try {
            if (phoneStr != null && !phoneStr.isEmpty()) {
                mobno = Long.parseLong(phoneStr);
            }
            if (aadhaarStr != null && !aadhaarStr.isEmpty()) {
                aadhaar = Long.parseLong(aadhaarStr);
            }
            if (accnoStr != null && !accnoStr.isEmpty()) {
                accno = Long.parseLong(accnoStr);
            }
        } catch (NumberFormatException e) {
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Enter valid numeric details');</script>");
            out.println("<meta http-equiv='refresh' content='0;URL=modifyUserDetails.jsp'>");
            return;
        }

        UserModel user = new UserModel();
        user.setFullname(fullname);
        user.setAddress(address);
        user.setAccType(accType);
        user.setDob(dob);
        user.setEmail(email);
        user.setPhno(mobno);
        user.setAadhaar(aadhaar);
        user.setAccno(accno);

        PrintWriter out = response.getWriter();
        boolean success = AdminDAO.modifyUser(user);
        if (success) {
            response.sendRedirect("AdminPage.jsp");
        } else {
            out.println("<script>alert('Enter valid details');</script>");
            out.println("<meta http-equiv='refresh' content='0;URL=modifyUserDetails.jsp'>");
        }
    }
}
