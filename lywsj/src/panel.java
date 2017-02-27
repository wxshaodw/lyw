import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class panel extends JFrame{

	JTextField key=new JTextField(15);
	JButton cheak=new JButton("cheak");
	JPanel bot=new JPanel();

	public panel() {
		addtool();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
		this.setVisible(true);
	}
	public void addtool() {
		Container c=getContentPane();
		bot.add(key);
		bot.add(cheak);
		cheak.addActionListener(new cheak_l());
		c.add(bot);
		
	}
	class cheak_l implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Connection con=null;
			Statement state=null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1483; DatabaseName=lywdb","sa","wx4852010");
			state=con.createStatement();
			int i=0;
			ResultSet b=state.executeQuery("select * from sc where sno like'"+key+"'");
			JLabel sno_data=new JLabel();
			JLabel cno_data=new JLabel();
			JLabel grade_data=new JLabel();
			sno_data.setText(b.getString(1));
			cno_data.setText(b.getString(2));
			grade_data.setText(b.getString(3));
			bot.add(sno_data);
			bot.add(cno_data);
			bot.add(grade_data);
			// TODO Auto-generated method 
		}
	}
	
    public static void main(String[] args) {
    	panel lyw=new panel();// 实例化对象
       
    }
}