

import java.sql.*;

public class Link_Mysql {
	public static void main(String args[]) {
		// try {
		try {
			Class.forName("java.lang.System");
//			System.out.println("The class of " + args[] +
//                    " is " + args[].getClass().getName());

			Class.forName("com.mysql.jdbc.Driver"); // ����MYSQL JDBC��������
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
				// ����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������

				System.out.println("Success connect Mysql server!");
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from user");
				// user Ϊ��������
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