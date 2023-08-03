package digitbanking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loan")
public class loan extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session  = req.getSession();
	int option = Integer.parseInt(req.getParameter("option"));
	String url = "jdbc:mysql://localhost:3306/banking";
	String user = "root";
	String pwd = "root";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection(url, user, pwd);
	if(option == 1) {
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from loan where lid = ?");
		prepareStatement.setInt(1, option);
		ResultSet resultSet = prepareStatement.executeQuery();	
		if(resultSet.next()==true) {
		session.setAttribute("lid",resultSet.getInt(1));	
		session.setAttribute("ltype",resultSet.getString(2));	
		session.setAttribute("tenure",resultSet.getInt(3));	
		session.setAttribute("interest",resultSet.getFloat(4));	
		session.setAttribute("description",resultSet.getString(5));	
		resp.sendRedirect("/BankingApplication/loanDetails.jsp");
		}
	
		
	}
	
	
	else if(option == 2) {
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from loan where lid = ?");
		prepareStatement.setInt(1, option);
		prepareStatement.executeQuery();	
		ResultSet resultSet = prepareStatement.executeQuery();	
		if(resultSet.next()==true) {
			session.setAttribute("lid",resultSet.getInt(1));	
			session.setAttribute("ltype",resultSet.getString(2));	
			session.setAttribute("tenure",resultSet.getInt(3));	
			session.setAttribute("interest",resultSet.getFloat(4));	
			session.setAttribute("description",resultSet.getString(5));
			resp.sendRedirect("/BankingApplication/loanDetails.jsp");
		}
		
	}
	else if(option == 3) {
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from loan where lid = ?");
		prepareStatement.setInt(1, option);
		prepareStatement.executeQuery();	
		ResultSet resultSet = prepareStatement.executeQuery();	
		if(resultSet.next()==true) {
			session.setAttribute("lid",resultSet.getInt(1));	
			session.setAttribute("ltype",resultSet.getString(2));	
			session.setAttribute("tenure",resultSet.getInt(3));	
			session.setAttribute("interest",resultSet.getFloat(4));	
			session.setAttribute("description",resultSet.getString(5));
			resp.sendRedirect("/BankingApplication/loanDetails.jsp");
		}
		
	}
	else if(option == 4) {
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from loan where lid = ?");
		prepareStatement.setInt(1, option);
		prepareStatement.executeQuery();	
		ResultSet resultSet = prepareStatement.executeQuery();	
		if(resultSet.next()==true) {
			session.setAttribute("lid",resultSet.getInt(1));	
			session.setAttribute("ltype",resultSet.getString(2));	
			session.setAttribute("tenure",resultSet.getInt(3));	
			session.setAttribute("interest",resultSet.getFloat(4));	
			session.setAttribute("description",resultSet.getString(5));
			resp.sendRedirect("/BankingApplication/loanDetails.jsp");
		}
		
	}
	else if(option == 5) {
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from loan where lid = ?");
		prepareStatement.setInt(1, option);
		prepareStatement.executeQuery();	
		ResultSet resultSet = prepareStatement.executeQuery();	
		if(resultSet.next()==true) {
			session.setAttribute("lid",resultSet.getInt(1));	
			session.setAttribute("ltype",resultSet.getString(2));	
			session.setAttribute("tenure",resultSet.getInt(3));	
			session.setAttribute("interest",resultSet.getFloat(4));	
			session.setAttribute("description",resultSet.getString(5));
			resp.sendRedirect("/BankingApplication/loanDetails.jsp");
		}
		
	}
	else {
		resp.sendRedirect("/BankingApplication/loanFail.html");
	}
	
	
	}
	catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}}
