<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.bag.Model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    table th {
        background-color: #4CAF50;
        color: white;
    }
    table th, table td {
        padding: 10px;
    }
    button {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 20px;
        font-size: 16px;
    }
    button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<% int i = 1; %>
<table border="1">
<thead>
<tr>
    <th>ID</th>
    <th>Account Number</th>
    <th>Date</th>
    <th>Type</th>
    <th>Amount</th>
</tr>
</thead>
<% List<TransactionModel> l = (List<TransactionModel>)session.getAttribute("list"); %>
<tbody>
<% for(TransactionModel temp : l) { %>
    <tr>
        <td><%= i++ %></td>
        <td><%= temp.getAccno() %></td>
        <td><%= temp.getDate() %></td>
        <td><%= temp.getType() %></td>
        <td><%= temp.getAmount() %></td>
    </tr>
<% } %>
</tbody>
</table>
<button onClick="window.print()">Print</button>
</body>
</html>
