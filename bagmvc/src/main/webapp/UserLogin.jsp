<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }
    form {
        max-width: 300px;
        margin: 0 auto;
        background: #ffffff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    input[type="number"], input[type="password"], input[type="submit"], input[type="reset"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }
    input[type="submit"], input[type="reset"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover, input[type="reset"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<form action="UserLoginServlet" method="post">
    <input type="number" autofocus placeholder="Enter account number" name="accno" required/>
    <input type="password" placeholder="Enter pin" name="pin" required/>
    <input type="submit" value="Login" />
    <input type="reset" value="Reset" />
</form>
</body>
</html>
