

import java.sql.*;

public class Link_Mysql {
	public static void main(String args[]) {
		// try {
		try {
			Class.forName("java.lang.System");
//			System.out.println("The class of " + args[] +
//                    " is " + args[].getClass().getName());

			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Success loading Mysql Driver!");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// } catch (Exception e) {
		// System.out.print("Error loading Mysql Driver!");
		// e.printStackTrace();
		// }
//		try {
			try {
				Connection connect = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/test", "root", "root");
				// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

				System.out.println("Success connect Mysql server!");
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from user");
				// user 为你表的名称
				while (rs.next()) {
					System.out.println(rs.getString("name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		} catch (Exception e) {
//			System.out.print("get data error!");
//			e.printStackTrace();
//		}
	}
}