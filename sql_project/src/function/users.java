package function;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import pane.*;
public class users {
	private String id;
	private String name;
	private String passkey;
	public users(String name,String passkey){
		this.name=name;
		this.passkey=passkey;
	}
	public void setid(String id){
		this.id=id;
	}
	public String getid(){
		return this.id;
	}
	public String getname(){
		return this.name;
		}
	public String getpasskey(){
		return this.passkey;
		}
	public static boolean  register(String name,String password_1,String password_2,personal_info user) throws ClassNotFoundException, SQLException{
		jdbc j_register=new jdbc();
		if(name.length()>20||name.length()<=0) {
			JOptionPane.showMessageDialog(null,"用户名输入有误，长度为0——20","", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		else if(password_1.length()>20||password_1.length()<=5){
			JOptionPane.showMessageDialog(null,"密码输入有误，长度为6——20","", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} 
		else if(!password_1.equals(password_2)) {
			JOptionPane.showMessageDialog(null,"两次密码输入不一致，请检查","", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		else{
			try {
				j_register.get_state().execute("execute dbo.register '"+name+"','"+key.encrypt(password_1)+"',"+"'"+user.getname()+"',"+"'"+user.getsex()+"',"+"'"+user.getage()+"',"+"'"+user.getbirthday()+"',"+"'"+user.getmobile()+"',"+"'"+user.getemail()+"',"+"'"+user.getQQ()+"','"+user.getcompany()+"','"+user.getposition()+"'");
				JOptionPane.showMessageDialog(null, "注册成功","", JOptionPane.INFORMATION_MESSAGE);
				return true;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "用户名已存在","", JOptionPane.INFORMATION_MESSAGE);// TODO Auto-generated catch block
			}//调用存储过程
			}
		j_register.close();
		return false;
	}
	public boolean login() throws ClassNotFoundException, SQLException {
		jdbc j_login=new jdbc();
		ResultSet r_login=j_login.get_state().executeQuery("select * from Users,PersonalInfo where Users.U_id=PersonalInfo.U_id and U_name='"+this.name+"'");
		if(r_login.next()){
			if(this.name.equals(r_login.getString("U_name"))&&this.passkey.equals(key.deciphering(r_login.getString("passkey"))))
			{
				main_pane sys=new main_pane(r_login.getString("P_name"),r_login.getString("U_id"));
				j_login.close();
				return true;
			}
			else {
				JOptionPane.showConfirmDialog(null,"用户名与密码有误请重新输入");
				j_login.close();
				return false;
				}
		}
		else {
			JOptionPane.showConfirmDialog(null,"用户名不存在");
			j_login.close();
			return false;
		}
	}
	public static boolean  change_password(String user_id,String password,String newpassword,String repassword,JLabel jl1,JLabel jl2,JLabel jl3) throws ClassNotFoundException, SQLException{
		jdbc c=new jdbc();
		ResultSet r=c.get_state().executeQuery("select passkey from Users where U_id='"+user_id+"'");
		r.next();
		if(!password.equals(r.getString("passkey"))){
			jl1.setText("原密码输入有误");
			return false;
		}
		else if(newpassword.length()>20||newpassword.length()<=5){
			jl2.setText("密码输入有误，长度为6——20");
			return false;
		} 
		else if(!newpassword.equals(repassword)) {
			jl3.setText("两次密码输入不一致，请检查");
			return false;
		}
		else{
		String sql="update Users set passkey='"+newpassword+"' where U_id='"+user_id+"'";
		c.get_state().executeUpdate(sql);
		JOptionPane.showConfirmDialog(null,"修改成功");
		c.close();
		return true;
		}
	}
	/*public static void main(String[] args) {
	}*/
}
