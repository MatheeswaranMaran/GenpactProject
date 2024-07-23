<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw Money</title>
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
    input[type="text"], input[type="number"] {
        width: calc(100% - 10px);
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }
    input[type="text"][readonly] {
        background-color: #f0f0f0;
        cursor: not-allowed;
    }
    button[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    button[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<form action="WithdrawCompletion" method="post">
    <input type="text" value="${accno}" name="accno" readonly />
    <input type="text" value="${balance}" name="balance" readonly/>
    <input type="number" placeholder="Enter the amount" name="amount" />
    <button type="submit">Withdraw</button>
</form>
</body>
</html>
