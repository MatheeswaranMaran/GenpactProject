<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f0f0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        max-width: 400px;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    h1 {
        color: #333;
        text-align: center;
        margin-bottom: 20px;
    }

    input[type="text"], input[type="password"], input[type="submit"], input[type="reset"] {
        display: block;
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="submit"], input[type="reset"] {
        background-color: #007BFF;
        color: #fff;
        border: none;
        cursor: pointer;
    }

    input[type="submit"]:hover, input[type="reset"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Admin Login</h1>
    <form action="AdminLoginServlet" method="post">
        <input type="text" autofocus placeholder="Enter admin name" name="un" required/>
        <input type="password" placeholder="Enter password" name="pwd" required/>
        <input type="submit" value="Login" />
        <input type="reset" value="Reset" />
    </form>
</div>
</body>
</html>
