package digitbanking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/showTranscation")
public class showTranscation extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pwd = "root";
		try {
		HttpSession session  =  req.getSession(); 
	
//		int sender_accno = sc.nextInt();
		int sender_accno = (int) session.getAttribute("accno");
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(url, user, pwd);
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from transferdata where sender_accno=?");
		prepareStatement.setInt(1,sender_accno);
		ResultSet resultSet = prepareStatement.executeQuery();
		if(resultSet.next()==true) {
			ArrayList al = new ArrayList();
			session.setAttribute("cust_id",resultSet.getInt(1));	
			session.setAttribute("bank_name",resultSet.getString(2));	
			session.setAttribute("IFSC",resultSet.getString(3));	
			session.setAttribute("sender_accno",resultSet.getInt(4));	
			session.setAttribute("reciever_ifsc",resultSet.getString(5));	
			session.setAttribute("reciever_accno",resultSet.getInt(6));	
			session.setAttribute("amount",resultSet.getInt(7));	
			session.setAttribute("transation_Id",resultSet.getInt(8));
			resp.sendRedirect("transcationDetails.jsp");
			
		}
		
		
		}
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
