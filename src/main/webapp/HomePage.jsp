<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to the Bank</title>

<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f7f7f7;
  color: #333;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.container {
  max-width: 600px;
  padding: 20px;
}

h1 {
  text-align: center;
  font-size: 48px;
  color: #007BFF;
  margin-bottom: 20px;
}

.welcome-message {
  text-align: center;
  font-size: 18px;
  margin-bottom: 30px;
}

.actions {
  text-align: center;
}

.actions a {
  display: inline-block;
  margin: 10px;
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  text-decoration: none;
  border-radius: 5px;
  transition: background-color 0.2s ease;
}

.actions a:hover {
  background-color: #0056b3;
}
</style>
</head>
<body>
  <div class="container">
    <h1>Welcome to the Bank</h1>
    <div class="welcome-message">
      <% session = request.getSession();
         String s1 = (String)session.getAttribute("cust_name");
         out.println(s1 + ", Welcome to Your Account"); %>
    </div>
    <div class="actions">
      <a href="Checkbalance">Check Balance</a>
      <a href="ChangePassword.html">Change Password</a>
      <a href="loan.jsp">Take Loan</a>
      <a href="transfermoney.html">Transfer Money</a>
      <a href="transcationD.jsp">Show Transaction</a>
      <a href="logout">Logout</a>
    </div>
  </div>
</body>
</html>
