package jsp_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementSQL {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	public static void main(String[] args) {
		try{
		createTable();
		}catch(SQLException e){
		System.out.println(e.getMessage());
		}
		}
private static void createTable() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		String sql = "CREATE TABLE Counselor ( id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,"
				+ "  firstName VARCHAR (50),"
				+ "    nickName VARCHAR (50),"
				+ "    lastName VARCHAR (50),"
				+ "    telephone VARCHAR (25),"
				+ "    email VARCHAR (50),"
				+ "    memberSince DATE DEFAULT '0000-00-00',"
				+ "    PRIMARY KEY (id)"
				+ "            )";
		try{
		conn = getDBConnection();
		stmt = conn.createStatement();
		System.out.println(sql);
		stmt.execute(sql);
		System.out.println("Table \"t_user\" is created!");
		}catch(SQLException e){
		System.out.println(e.getMessage());
		}finally{
		if(stmt!=null){
		stmt.close();
		}
		if(conn!=null){
		conn.close();
		}
		}
		}
private static Connection getDBConnection(){
Connection conn = null;
try{
Class.forName(DB_DRIVER);
}catch(ClassNotFoundException e){
System.out.println(e.getMessage());
}
try{
conn = DriverManager.getConnection(DB_CONNECTION,DB_USER, DB_PASSWORD);
}catch(SQLException e){
System.out.println(e.getMessage());
}
return conn;
}
}
