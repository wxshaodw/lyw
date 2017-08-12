import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					return_window w=new return_window(rs.getString(3),String.valueOf(rs.getFloat(4)),rs.getString(6));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	}


