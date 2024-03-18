<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            width: 50%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="date"],
        textarea {
            width: 100%;
            padding: 10px;
            margin: 5px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Employee Form</h1>
    <form action="controller/add" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName">

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName">

        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary">

        <label>Gender:</label>
        <input type="radio" id="genderMale" name="gender" value="Male">
        <label for="genderMale">Male</label>
        <input type="radio" id="genderFemale" name="gender" value="Female">
        <label for="genderFemale">Female</label>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email">

        <label for="phoneNo">Phone Number:</label>
        <input type="text" id="phoneNo" name="phoneNo">

        <label for="age">Age:</label>
        <input type="text" id="age" name="age">

        <label for="address">Address:</label>
        <textarea id="address" name="address" rows="4" cols="50"></textarea>

        <input type="submit" value="Submit">
    </form>
    
    <form action="controller/get" method="post">
     	<div class="form-group">
             <label>Enter Id</label> <input type="number"
                 class="form-control" name="readId">
         </div>
     </form>
</body>
</html>
