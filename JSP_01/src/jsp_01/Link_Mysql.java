
import java.sql.*;

public class Link_Mysql {
	public static void main(String args[]) {
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
						System.out.println(rs.getString(0));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
}