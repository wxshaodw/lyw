package jsp_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public static boolean login(User user) {
		String sql="select * from users where username=?";
		boolean falg = false;
		Connection conn;
		try {
			conn = jdbc.getconn();
			PreparedStatement stat=conn.prepareStatement(sql);
			stat.setString(1,user.getUsername());
			stat.executeQuery();
			ResultSet rs=stat.getResultSet();
			rs.next();
			if(rs.getString("password").equals(user.getPassword())){
				falg=true;
			}
			// TODO Auto-generated method stub
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return falg;
	}
}
