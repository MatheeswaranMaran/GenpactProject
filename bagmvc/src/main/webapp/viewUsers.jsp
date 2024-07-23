<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }
    h1 {
        margin-bottom: 10px;
        font-size: 20px;
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
<h1>Name: ${name}</h1>
<h1>Account Number: ${accno}</h1>
<h1>Email: ${email}</h1>
<h1>Mobile Number: ${mobno}</h1>
<h1>Date of Birth: ${dob}</h1>
<h1>Account Type: ${acctype}</h1>
<h1>Aadhaar: ${aadhaar}</h1>
<h1>Address: ${address}</h1>
<button onClick="window.location.href='AdminPage.jsp'">Admin Page</button>
</body>
</html>
