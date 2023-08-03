package digitbanking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/transfermoney")
public class transfermoney extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cust_id = Integer.parseInt(req.getParameter("cust_id"));
		String bank_name = req.getParameter("bank_name");
		String IFSC = req.getParameter("IFSC");
		int senderaccno = Integer.parseInt(req.getParameter("senderaccno"));
		String recieverifsc = req.getParameter("recieverifsc");
		int recieveraccno = Integer.parseInt(req.getParameter("recieveraccno"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		int pin = Integer.parseInt(req.getParameter("pin"));

		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pwd = "root";
		try {
			HttpSession session = req.getSession();
			session.setAttribute("sender_accno", senderaccno);
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, user, pwd);
			PreparedStatement prepareStatement = connection.prepareStatement(
					"select * from bankapp where cust_id = ? and  IFSC = ? and acc_no = ? and pin = ?");
			prepareStatement.setInt(1, cust_id);
			prepareStatement.setString(2, IFSC);
			prepareStatement.setInt(3, senderaccno);
			prepareStatement.setInt(4, pin);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next() == true) {
				prepareStatement = connection.prepareStatement("select * from bankapp where IFSC = ? and acc_no = ?");
				prepareStatement.setString(1, recieverifsc);
				prepareStatement.setInt(2, recieveraccno);
				ResultSet resultSet2 = prepareStatement.executeQuery();
				if (resultSet2.next() == true) {
					prepareStatement = connection.prepareStatement("select balance from bankapp where acc_no =?");
					prepareStatement.setInt(1, senderaccno);
					ResultSet resultset3 = prepareStatement.executeQuery();
					resultset3.next();
					int bal = resultset3.getInt(1);
					if (bal > amount) {
					prepareStatement = 	connection.prepareStatement("update bankapp set balance = balance - ? where acc_no = ?");
						prepareStatement.setInt(1, amount);
						prepareStatement.setInt(2, senderaccno);
						int x = prepareStatement.executeUpdate();
						if (x > 0) {
							prepareStatement = connection
									.prepareStatement("update bankapp set balance = balance + ? where acc_no = ?");
							prepareStatement.setInt(1, amount);
							prepareStatement.setInt(2, recieveraccno);
							int x1 = prepareStatement.executeUpdate();
							if (x1 > 0) {
								prepareStatement = connection
										.prepareStatement("insert into  transferdata values(?,?,?,?,?,?,?,?);");
								prepareStatement.setInt(1, cust_id);
								prepareStatement.setString(2, bank_name);
								prepareStatement.setString(3, IFSC);
								prepareStatement.setInt(4, senderaccno);
								prepareStatement.setString(5, recieverifsc);
								prepareStatement.setInt(6, recieveraccno);
								prepareStatement.setInt(7, amount);
								Random i = new Random();
								int z = i.nextInt(900) + 100;
								prepareStatement.setInt(8,z);
								int x2 = prepareStatement.executeUpdate();
								if (x2 > 0) {
									
									resp.sendRedirect("/BankingApplication/transferSuccess.html");
								} 

							} 
						} 
					} 
				} 

			} 
			

		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
