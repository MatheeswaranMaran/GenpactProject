<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Account Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }
    div {
        margin: 0 auto;
        max-width: 800px;
    }
    button {
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-right: 10px;
        margin-bottom: 10px;
    }
    #deposit {
        background-color: #4CAF50; /* Green */
    }
    #deposit:hover {
        background-color: #45a049;
    }
    #modify {
        background-color: #2196F3; /* Blue */
    }
    #modify:hover {
        background-color: #1e88e5;
    }
    #withdraw {
        background-color: #f44336; /* Red */
    }
    #withdraw:hover {
        background-color: #e53935;
    }
    #close {
        background-color: #ff9800; /* Orange */
    }
    #close:hover {
        background-color: #fb8c00;
    }
    #logout {
        background-color: #f44336; /* Purple */
    }
    #logout:hover {
        background-color: #8e24aa;
    }
    #view{
    	background-color: #ff9800;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #f9f9f9; /* Light grey background */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Light shadow */
    }
    table, th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
    table th {
        color: black;
    }
    table th, table td {
        padding: 10px;
    }
</style>
</head>
<body>
<div>    
	<% String acc = (String) session.getAttribute("accno");
		if(acc==null){
		response.sendRedirect("UserLogin.jsp");
		return;
		}
		%>
    <button id="deposit" onClick="window.location.href='deposit.jsp'">DEPOSIT</button>
    <button id="modify" onClick="window.location.href='modifyRequest.jsp'">MODIFY</button>
    <button id="withdraw" onClick="window.location.href='withdraw.jsp'">WITHDRAW</button>    
    <button id="close" onClick="window.location.href='closeRequest.jsp'">CLOSE</button>
    <form action="ViewLastTenTransactionsServlet" method="post">
        <input type="hidden" value="<%= session.getAttribute("accno") %>" name="accno" />
        <button type="submit" id="view">VIEW</button>
    </form>
    <button id="logout" onClick="window.location.href='LogoutUserServlet'">LOGOUT</button>
    <table>
        <thead>
            <tr>
                <th>Fullname</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Account Type</th>
                <th>Balance</th>
                <th>Date of Birth</th>
                <th>Aadhaar</th>
                <th>Account Number</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th><%=session.getAttribute("name") %></th>
                <th><%=session.getAttribute("address") %></th>
                <th><%=session.getAttribute("mobno") %></th>
                <th><%=session.getAttribute("email") %></th>
                <th><%=session.getAttribute("acctype") %></th>
                <th><%=session.getAttribute("balance") %></th>
                <th><%=session.getAttribute("dob") %></th>
                <th><%=session.getAttribute("aadhaar") %></th>
                <th><%=session.getAttribute("accno") %></th>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
