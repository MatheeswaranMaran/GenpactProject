<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f0f0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    h1 {
        color: #333;
        margin: 10px 0;
        text-align: center;
    }

    form {
        margin-top: 20px;
    }

    button {
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #dc3545;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #c82333;
    }

    button:focus {
        outline: none;
        box-shadow: 0 0 5px rgba(220, 53, 69, 0.5);
    }
</style>
</head>
<body>
<h1>Account Number: ${accno}<br>
Name: ${name}<br> 
Account Type: ${acctype}</h1>
<form action="DeleteSuccessServlet" method="post">
    <button type="submit" value='${accno}' name="accno">Delete</button>
</form>
</body>
</html>
