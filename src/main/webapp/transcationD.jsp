<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction History</title>
    <link rel="stylesheet" type="text/css" href="sty.css">
</head>
<body>
    <div class="container">
        <h1>Transaction History</h1>
        <table>
            <tr>
                <th>Customer ID</th>
                <th>Bank Name</th>
                <th>IFSC</th>
                <th>Sender Account</th>
                <th>Receiver IFSC</th>
                <th>Receiver Account</th>
                <th>Amount</th>
                <th>Transaction ID</th>
            </tr>
            <% 
            int acc_no = (int) session.getAttribute("accno");
            String url = "jdbc:mysql://localhost:3306/banking";
            String user = "root";
            String pwd = "root";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM transferdata WHERE sender_accno = ? ORDER BY transation_Id DESC");
                pstmt.setInt(1, acc_no);
                ResultSet resultSet = pstmt.executeQuery();

                while (resultSet.next()) { %>
                <tr>
                    <td><%= resultSet.getInt(1) %></td>
                    <td><%= resultSet.getString(2) %></td>
                    <td><%= resultSet.getString(3) %></td>
                    <td><%= resultSet.getInt(4) %></td>
                    <td><%= resultSet.getString(5) %></td>
                    <td><%= resultSet.getInt(6) %></td>
                    <td><%= resultSet.getInt(7) %></td>
                    <td><%= resultSet.getInt(8) %></td>
                </tr>
                <% }
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </table>
        <br>
        <a href="HomePage.jsp">Go To Home</a>
    </div>
</body>
</html>
