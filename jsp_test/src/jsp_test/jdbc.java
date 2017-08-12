package jsp_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

	public static Connection getconn() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String pasword="root";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,username,pasword);
		// TODO Auto-generated method stub
		return conn;
	}

}
