<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }
    form {
        max-width: 600px;
        margin: 0 auto;
        background: #ffffff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        font-size: 24px;
        margin-bottom: 20px;
    }
    input[type="text"], input[type="number"] {
        width: calc(100% - 20px);
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }
    button[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 10px;
    }
    button[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<form action="ModifyUserServlet" method="post">
    <h1>Account Number: ${accno}</h1>
    <input value="${name}" name="name" placeholder="Name"/>
    <input value="${mobno}" name="mobno" placeholder="Mobile Number"/>
    <input value="${email}" name="email" placeholder="Email"/>
    <input value="${address}" name="address" placeholder="Address"/>
    <input value="${acctype}" name="acctype" placeholder="Account Type"/>
    <input value="${dob}" name="dob" placeholder="Date of Birth"/>
    <input value="${aadhaar}" name="aadhaar" placeholder="Aadhaar Number"/>
    <button type="submit" value='${accno}' name="accno">Modify</button>
</form>
</body>
</html>
