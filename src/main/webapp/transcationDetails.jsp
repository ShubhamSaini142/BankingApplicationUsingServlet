<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>transcationDetails</title>
</head>
<body>
<%
session = request.getSession();
int s1 = (int) session.getAttribute("cust_id");	
String s2 = (String) session.getAttribute("bank_name");	
String s3 = (String) session.getAttribute("IFSC");	
int s4 = (int) session.getAttribute("sender_accno");	
String s5 = (String) session.getAttribute("reciever_ifsc");	
int s6 = (int) session.getAttribute("reciever_accno");	
int s7 = (int) session.getAttribute("amount");	
int s8 = (int) session.getAttribute("transation_Id");
out.println(" cust_id " + s1 + "<br>");
out.println();
out.println(" bank_name-type " + s2+ "<br>");
out.println();
out.println(" IFSC " + s3+ "<br>");
out.println();
out.println(" sender_accno " + s4+ "<br>");
out.println();
out.println(" reciever_ifsc " + s5+ "<br>");
out.println();
out.println(" reciever_accno " + s6+ "<br>");
out.println();
out.println(" amount " + s7+ "<br>");
out.println();
out.println(" transation_Id " + s8+ "<br>");
out.println();

%>

</body>
</html>