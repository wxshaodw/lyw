package asdf;
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
	JTextField sno_t=new JTextField(15);
	JTextField cno_t=new JTextField(15);
	JTextField grade_t=new JTextField(15);
	JTextField key=new JTextField(15);
	JButton cheak=new JButton("查询");
	JButton insert_b=new JButton("添加");
	JButton updata_b=new JButton("修改");
	JButton delete=new JButton("删除");
	JLabel sno=new JLabel("学号：");
	JLabel cno=new JLabel("课程号：");
	JLabel grade=new JLabel("分数：");
	JPanel insert=new JPanel();
	JPanel bot=new JPanel();
	Container c=getContentPane();

	public panel() {
		addtool();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 150);
		this.setVisible(true);
	}
	public void addtool() {
		insert.setLayout(new FlowLayout());
		insert.add(sno);
		insert.add(sno_t);
		insert.add(cno);
		insert.add(cno_t);
		insert.add(grade);
		insert.add(grade_t);
		insert.add(insert_b);
		insert_b.addActionListener(new listen());
		cheak.addActionListener(new listen());
		updata_b.addActionListener(new listen());
		delete .addActionListener(new listen());
		bot.add(insert);
		bot.add(key);
		bot.add(cheak);
		bot.add(insert_b);
		bot.add(updata_b);
		bot.add(delete);
		c.add(bot);
	}
	class listen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Connection con=null;
			Statement state=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1483; DatabaseName=lywdb","sa","wx4852010");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				state=con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int i=0;
			ResultSet b=null;
			if(e.getActionCommand().equals("查询")){
				try {
					b=state.executeQuery("select * from sc where sno='"+key.getText()+"'");
					b.next();
					System.out.println(b.getString("sno"));
					System.out.println(b.getString("cno"));
					System.out.println(b.getString("grade"));
					JOptionPane.showConfirmDialog(null,"学号:"+b.getString("sno")+" 课程号"+b.getString("cno")+" 成绩："+b.getString("grade"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if(e.getActionCommand().equals("修改")){
				try {
					state.executeUpdate("update sc set grade="+Integer.parseInt(grade_t.getText())+"where sno='"+sno_t.getText()+"' and cno='"+cno_t.getText()+"'");
					JOptionPane.showConfirmDialog(null,"修改信息成功");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getActionCommand().equals("删除")){
				try {
					state.executeUpdate("delete from sc where sno='201420225'");
					JOptionPane.showConfirmDialog(null,"删除信息成功");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getActionCommand().equals("添加")){
				try {
					state.executeUpdate("insert into sc values('"+sno_t.getText()+"','"+cno_t.getText()+"',"+Integer.parseInt(grade_t.getText())+")");
					JOptionPane.showConfirmDialog(null,"添加 信息成功");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			}
	}
	
    public static void main(String[] args) {
    	panel lyw=new panel();// 实例化对象
       
    }
}