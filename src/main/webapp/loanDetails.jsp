<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Details</title>

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
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  background-color: #fff;
}

h1 {
  text-align: center;
  font-size: 24px;
  color: #007BFF;
  margin-bottom: 20px;
}

loan-details {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}

loan-details label {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 5px;
}

loan-details p {
  margin: 0;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f7f7f7;
}

</style>
</head>
<body>
  <div class="container">
    <h1>Loan Details</h1>
    <loan-details>
      <label>Loan ID</label>
      <p><%= session.getAttribute("lid") %></p>

      <label>Loan Type</label>
      <p><%= session.getAttribute("ltype") %></p>

      <label>Loan Tenure</label>
      <p><%= session.getAttribute("tenure") %></p>

      <label>Loan Interest</label>
      <p><%= session.getAttribute("interest") %></p>

      <label>Loan Description</label>
      <p><%= session.getAttribute("description") %></p>
    </loan-details>
  </div>
</body>
</html>
