<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1 align = "center">WELCOME TO THE BANK</h1>
<%
session = request.getSession();
String s1 = (String)session.getAttribute("cust_name");
out.println(s1 + " Welcome to Your account ");



%>
<br>
<br>
<a href = "Checkbalance">check balance</a>
<br>
<br>
<a href = "ChangePassword.html">Change Password</a>
<a href = "loan.jsp">Take Loan</a>
<a href = "transfermoney.html">Transfer Money</a>
<a href = "transcationD.jsp">ShowTranscation</a>
<a href = "logout">logout</a>

</body>
</html>