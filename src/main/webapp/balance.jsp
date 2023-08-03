<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance</title>

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
  text-align: center;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  background-color: #fff;
}

h1 {
  font-size: 24px;
  margin-bottom: 20px;
  color: #555;
}

.balance {
  font-weight: bold;
  font-size: 32px;
  color: #007BFF;
}

a {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  text-decoration: none;
  border-radius: 5px;
  transition: background-color 0.2s ease;
}

a:hover {
  background-color: #0056b3;
}

</style>
</head>
<body>
  <div class="container">
    <h1>Balance</h1>
    <span class="balance"><%= session.getAttribute("balance") %></span><br>
    <a href="HomePage.jsp">GO BACK</a>
  </div>
</body>
</html>
