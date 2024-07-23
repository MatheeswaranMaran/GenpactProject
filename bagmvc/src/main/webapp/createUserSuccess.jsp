<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Account Number and Password</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f0f0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }

    h1 {
        color: #333;
        margin: 10px 0;
    }

    button {
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #007BFF;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 20px;
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
    <h1>Account Number: ${accno}</h1>
    <h1>Name: ${name}</h1>
    <h1>Pin: ${pin}</h1>
    <button onClick="window.location.href='AdminPage.jsp'">Admin Page</button>
</body>
</html>
