package function;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	static String severname;
	static String databasename;
	static String login;
	static String password;
	Connection con=null;
	Statement state=null;
	public static void setdata(String Severname,String databasename,String login,String password){
		jdbc.severname=key.deciphering(Severname);
		jdbc.databasename=key.deciphering(databasename);
		jdbc.login=key.deciphering(login);
		jdbc.password=key.deciphering(password);
	}
	public jdbc() throws ClassNotFoundException, SQLException{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://"+jdbc.severname+";"+" DatabaseName="+jdbc.databasename,jdbc.login,jdbc.password);
			state=con.createStatement();
	}
	public Statement get_state(){
		return state;
	}
	public void close() throws SQLException{
		con.close();
		state.close();
	}

}
