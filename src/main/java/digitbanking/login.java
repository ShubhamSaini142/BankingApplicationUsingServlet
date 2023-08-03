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

import com.mysql.cj.Session;
@WebServlet("/login")
public class login extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int Customer_Id = Integer.parseInt(req.getParameter("cust_Id"));
		int Pin = Integer.parseInt(req.getParameter("pin"));
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pwd = "root";
		try {
		HttpSession session  =  req.getSession(); 
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(url, user, pwd);
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from bankapp where cust_id = ? and pin = ?");
		prepareStatement.setInt(1, Customer_Id);
		prepareStatement.setInt(2, Pin);
		ResultSet resultSet = prepareStatement.executeQuery();
		if(resultSet.next()==true) {
			session.setAttribute("accno" , resultSet.getInt("acc_no"));
			session.setAttribute("cust_name", resultSet.getString("customerName"));
			resp.sendRedirect("/BankingApplication/LoginSuccess.html");	
			
		}
		
		
		}
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
