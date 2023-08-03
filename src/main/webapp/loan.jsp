<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Options</title>

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
  max-width: 400px;
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

form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

label {
  font-size: 16px;
  margin: 5px 0;
}

input[type="text"] {
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 300px;
}

input[type="submit"] {
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

input[type="submit"]:hover {
  background-color: #0056b3;
}
</style>
</head>
<body>
  <div class="container">
    <h1>Loan Options</h1>
    <form action="loan">
      <label>1. Home Loan</label>
      <label>2. Education Loan</label>
      <label>3. Vehicle Loan</label>
      <label>4. Gold Loan</label>
      <label>5. Personal Loan</label>
      <br>
      Choose Your Option:
      <input type="text" name="option">
      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>
