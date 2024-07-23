<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%@page import="com.bag.Model.UserModel" %>
    <%@page import="com.bag.dao.AdminDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f0f0;
        height: 100vh;
    }

    div {
        display: flex;
        gap: 10px;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    button {
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #007BFF;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }

    button:focus {
        outline: none;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
    }
</style>
</head>
<body>
<h1>Admin Dashboard</h1>
    <button id="create" onClick="window.location.href='createUser.jsp'">CREATE</button>
    <button id="modify" onClick="window.location.href='modifyRequestUser.jsp'">MODIFY</button>
    <button id="delete" onClick="window.location.href='deleteRequest.jsp'">DELETE</button>    
    <button id="view" onClick="window.location.href='viewRequest.jsp'">VIEW</button>

<div>
<%int i = 1; %>
    <table border='1'>
    <thead>
    	<tr>
    		<th>SNo</th>
    		<th>Name</th>
    		<th>Account Number</th>
    		<th>Mobile Number</th>
    		<th>Modify</th>
    		<th>Delete</th>
    		<th>View</th>
    	</tr>
    </thead>
    <%AdminDAO admin = new AdminDAO();
    List<UserModel> userlist = (List<UserModel>)admin.userDetails(); 
    %>
    <tbody>
    <%for(UserModel user: userlist){ %>
    	<tr>
    		<td><%=i++ %></td>
    		<td><%=user.getFullname() %></td>
    		<td><%=user.getAccno() %></td>
    		<td><%=user.getPhno() %></td>
    		<td><button onClick="window.location.href='ModifyRequestUserServlet?accno=<%=user.getAccno() %>'">Modify</button></td>
    		<td><button onClick="window.location.href='DeleteRequestServlet?accno=<%=user.getAccno() %>'">Delete</button></td>
    		<td><button onClick="window.location.href='ViewUsersServlet?accno=<%=user.getAccno() %>'">View</button>
    	</tr>
    	<%} %>
    </tbody>
    </table>
</div>
</body>
</html>
