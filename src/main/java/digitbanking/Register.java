package digitbanking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bank_id = Integer.parseInt(req.getParameter("bank_id"));
		String bankName = req.getParameter("bank_name");
		String IFSCCode = req.getParameter("IFSCCode");
		int Accno = Integer.parseInt(req.getParameter("accno"));
		int Pin = Integer.parseInt(req.getParameter("pin"));
		int Customer_Id = Integer.parseInt(req.getParameter("cust_id"));
		String CustomerName = req.getParameter("custname");
		int balance = Integer.parseInt(req.getParameter("balance"));
		String Email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, pwd);
			PreparedStatement prepareStatement = connection
					.prepareStatement("insert into bankapp values(?,?,?,?,?,?,?,?,?,?)");
			prepareStatement.setInt(1, bank_id);

			prepareStatement.setString(2, bankName);

			prepareStatement.setString(3, IFSCCode);

			prepareStatement.setInt(4, Accno);

			prepareStatement.setInt(5, Pin);

			prepareStatement.setInt(6, Customer_Id);

			prepareStatement.setString(7, CustomerName);

			prepareStatement.setInt(8, balance);

			prepareStatement.setString(9, Email);

			prepareStatement.setLong(10, phone);

			int x = prepareStatement.executeUpdate();

			if (x > 0) {

				resp.sendRedirect("/BankingApplication/registerSuccess.html");

			}

			else {

				resp.sendRedirect("/BankingApplication/RegisterFail.html");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
