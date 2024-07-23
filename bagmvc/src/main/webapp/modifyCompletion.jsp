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
        background-color: #f0f0f0;
        padding: 20px;
    }
    form {
        width: 300px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    input[type="number"], input[type="text"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
        font-size: 16px;
    }
    input[type="number"]:read-only {
        background-color: #f0f0f0;
    }
    button[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        font-size: 16px;
    }
    button[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<form action="ModifyCompletion" method="post">
    <input type="number" value="${accno}" name="accno" readonly />
    <input type="number" placeholder="Enter new pin" name="pin" required />
    <button type="submit">Modify</button>
</form>
</body>
</html>
