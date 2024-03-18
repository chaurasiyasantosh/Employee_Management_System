<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.model.Employee"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>

<% Employee employee = (Employee)request.getAttribute("employee"); %>
    <h1>Employee Details </h1>
    <p>First Name: <%=employee.getFirstName() %></p>
    <p>Last Name: <%=employee.getLastName()%></p>
    <p>Email: <%=employee.getEmail()%></p>
    <p>PhoneNo: <%=employee.getPhoneNo()%></p>
    <p>Gender: <%=employee.getGender()%></p>
    
    <!-- Display more employee details as needed -->
</body>
</html>