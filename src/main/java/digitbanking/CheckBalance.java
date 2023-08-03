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
@WebServlet("/Checkbalance")
public class CheckBalance extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int accno = (int) session.getAttribute("accno");
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, pwd);
		PreparedStatement prepareStatement = connection.prepareStatement("Select * from bankapp where acc_no = ?");
		prepareStatement.setInt(1, accno);
		ResultSet resultSet = prepareStatement.executeQuery();
		if(resultSet.next()==true) {
			session.setAttribute("balance", resultSet.getInt("balance"));
			resp.sendRedirect("/BankingApplication/balance.jsp");
		}
		else {
			resp.sendRedirect("/BankingApplication/balanceFail.jsp");
		}
	}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
