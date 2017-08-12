package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class orc_servlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException {
doGet(req,resp);
}
@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException {
HttpSession session = req.getSession();
AccountBean return_data = new AccountBean();
String sql = "select * from goods";
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} // ¼ÓÔØMYSQL JDBCÇý¶¯³ÌÐò
Connection connect = null;
try {
	connect = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:lywdb", "system", "Wx4852010");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		Statement stmt = null;
		try {
			stmt = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return_data.setname(rs.getString(3));
			return_data.setprice(rs.getString(4));
			return_data.setdc(rs.getString(5));
			session.setAttribute("return_data", return_data);
			String login_suc ="return.jsp";
			resp.sendRedirect(login_suc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}