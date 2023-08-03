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
import javax.servlet.http.HttpSession;
@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session =  req.getSession();
	int accno = (int) session.getAttribute("accno");
	int oldPassword = Integer.parseInt(req.getParameter("oldpassword"));
	int newPassword = Integer.parseInt(req.getParameter("newpassword"));
	int confirmPassword = Integer.parseInt(req.getParameter("confirmpassword"));
	if(newPassword==confirmPassword) {
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pwd = "root";
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(url, user, pwd);
		PreparedStatement prepareStatement = connection
				.prepareStatement("update bankapp set pin = ? where acc_no = ? ");
		prepareStatement.setInt(1, confirmPassword);
		prepareStatement.setInt(2, accno);
		int x =prepareStatement.executeUpdate();   
		if(x>0) {
            
			resp.sendRedirect("/BankingApplication/passwordchangedSuccess.html");
		}
		else {
			resp.sendRedirect("passwordNotChanged.html");
			
		}
		
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		
		}
	}

	}

	private String getParameter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
