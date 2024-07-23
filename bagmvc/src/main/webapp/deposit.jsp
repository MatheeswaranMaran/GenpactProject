<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
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

    div {
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    form {
        display: flex;
        flex-direction: column;
        gap: 10px;
    }

    input[type="password"] {
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #28a745;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #218838;
    }

    button:focus {
        outline: none;
        box-shadow: 0 0 5px rgba(40, 167, 69, 0.5);
    }
</style>
</head>
<body>
<div> 
    <form action="DepositServlet" method="post">
        <input type="password" placeholder="Enter pin" autofocus name="pin" required/>
        <button type="submit">Deposit</button>
    </form>
</div>
</body>
</html>
