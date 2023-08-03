<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session = request.getSession();
int s1 = (int) session.getAttribute("lid");
String s2 = (String) session.getAttribute("ltype");
int s3 = (int) session.getAttribute("tenure");
Float s4 = (Float) session.getAttribute("interest");
String s5 = (String) session.getAttribute("description");
out.println(" LoanID " + s1 + "<br>");
out.println();
out.println(" Loan-type " + s2+ "<br>");
out.println();
out.println(" Loan-tenure " + s3+ "<br>");
out.println();
out.println(" Loan-interest " + s4+ "<br>");
out.println();
out.println(" Loan-description " + s5+ "<br>");
out.println();




%>

</body>
</html>