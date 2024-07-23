<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f9f9f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        overflow: hidden; /* Prevent body scroll */
    }
    .container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 100%;
    }
    #form {
        display: flex;
        flex-direction: column;
        width: 100%;
        max-width: 400px;
        padding: 20px;
        border: 2px solid #e0e0e0;
        border-radius: 10px;
        background-color: #ffffff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        gap: 15px;
        overflow-y: auto;
        max-height: 90vh; /* Adjust max-height as needed */
    }
    label {
        font-size: 16px;
        color: #333333;
    }
    input[type="text"],
    input[type="tel"],
    input[type="number"],
    input[type="date"] {
        border: 1px solid #cccccc;
        border-radius: 4px;
        font-size: 16px;
        padding: 10px;
        margin-top: 5px;
        transition: border-color 0.3s;
        width: calc(100% - 22px); /* Ensuring the input width takes into account padding and border */
        box-sizing: border-box;
    }
    input[type="text"]:focus,
    input[type="tel"]:focus,
    input[type="number"]:focus,
    input[type="date"]:focus {
        border-color: #4CAF50;
        outline: none;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        padding: 10px;
        cursor: pointer;
        transition: background-color 0.3s;
        margin-top: 15px;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    @media (max-width: 600px) {
        #form {
            width: 90%;
        }
    }
</style>
</head>
<body>
    <div class="container">
        <form id="form" action="CreateUserServlet" method="post">
            <label for="fullname">Name</label>
            <input type="text" autofocus id="fullname" name="fullname" placeholder="Enter username" required/>
            <label for="address">Address</label>
            <input type="text" id="address" name="address" placeholder="Enter address" required/>
            <label for="phone">Mobile Number</label>
            <input type="tel" id="phone" name="phone" pattern="[6-9]{1}[0-9]{9}" placeholder="Enter mobile number" required />
            <label for="email">Email Address</label>
            <input type="text" id="email" name="email" placeholder="Enter email" required/>
            <label for="acctype">Account Type</label>
            <input type="text" id="acctype" name="acctype" placeholder="Enter account type" required/>
            <label for="balance">Balance</label>
            <input type="number" id="balance" min='1000' name="balance" placeholder="Enter balance" required/>
            <label for="dob">Date Of Birth</label>
            <input type="date" id="dob" name="dob" placeholder="Enter date of birth" required/>
            <label for="aadhaar">Aadhaar Number</label>
            <input type="tel" id="aadhaar" name="aadhaar" pattern='[1-9]{1}[0-9]{11}' placeholder="Enter aadhaar number" required />
            <input type="submit" id="submit" value="Submit" />
        </form>
    </div>
</body>
</html>
