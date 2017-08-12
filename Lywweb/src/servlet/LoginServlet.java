package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet<PrepareStatement> extends HttpServlet implements Servlet
{
 public LoginServlet ()
 {
 // TODO Auto-generated constructor stub
 }
 /*
 * (non-Javadoc)
 *
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
 * javax.servlet.http.HttpServletResponse)
 */
 @Override
 protected void doGet ( HttpServletRequest arg0, HttpServletResponse arg1 )
  throws ServletException, IOException
 {
 }
 /*
 * (non-Javadoc)
 *
 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
 * javax.servlet.http.HttpServletResponse)
 */
 @Override
 protected void doPost ( HttpServletRequest request, HttpServletResponse response )
  throws ServletException, IOException
 {
 response.setContentType ( "text/html" );
 String result = "";
 // 获取用户名
 String sUserName = request.getParameter ( "logname" );
 if ( sUserName == "" || sUserName == null || sUserName.length ( ) > 20 )
 {
  try
  {
  result = "请输入用户名（不超过20字符）！";
  request.setAttribute ( "ErrorUserName", result );
  response.sendRedirect ( "login.html" );
  } catch ( Exception e )
  {
  }
 }
 // 获取密码
 String sPasswd = request.getParameter ( "password" );
 if ( sPasswd == "" || sPasswd == null || sPasswd.length ( ) > 20 )
 {
  try
  {
  result = "请输入密码（不超过20字符）！";
  request.setAttribute ( "ErrorPassword", result );
  response.sendRedirect ( "login.html" );
  } catch ( Exception e )
  {
  }
 }
 // 登记JDBC驱动程序
 try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 Connection connect = null;
try {
	connect = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mytest", "root", "root");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 PreparedStatement pstmt = null;
try {
	pstmt = connect.prepareStatement("select * from user where username=?");
	pstmt.setString(1, "123");
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
 ResultSet rs = null;
try {
	rs = pstmt.executeQuery();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	try {
		if(rs.first()){
			  response.sendRedirect ( "login_success.jsp" );
		}
		else{
			 response.sendRedirect ( "login_failure.jsp" );
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 
 /**
  * 
 *
 */
 private static final long serialVersionUID = 1L;
}