

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	Connection con=null;
	Statement state=null;
	public jdbc() throws ClassNotFoundException, SQLException{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1483; DatabaseName=PersonalInfoManegemeng","sa","wx4852010");
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
