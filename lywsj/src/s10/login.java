package s10;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;
public class login extends JFrame {
	String str[]={"学生用户","教师用户"};
	Button exit=new Button("退出");
	Button q=new Button("确定");
	Button cancle=new Button("取消");
	JTextField Id=new JTextField(12);
	JPasswordField Key=new JPasswordField(12);
	JComboBox Typ=new JComboBox(str);
	JLabel Typ_Label=new JLabel("用户类型          ");
	JLabel Id_Label=new JLabel("用户");
	JLabel Key_Label=new JLabel("密码");
	JPanel cen=new JPanel();
	JPanel sou=new JPanel();
	public login(String Name){
		super(Name);
		Bulit_window();
		setSize(200,160);
		centerWindow();
	}
	public void Bulit_window(){
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		q.addActionListener(new Enter());
		cancle.addActionListener(new ReWrite());
		exit.addActionListener(new exit());
		Typ.setSelectedItem(str[0]);
		Key.addActionListener(new Enter());
		cen.add(Typ_Label);
		cen.add(Typ);
		cen.add(Id_Label);
		cen.add(Id);
		cen.add(Key_Label);
		cen.add(Key);
		sou.add(q);
		sou.add(cancle);
		sou.add(exit);
		c.add("Center",cen);
		c.add("South",sou);
		setResizable(false);
	}
	public void centerWindow(){
		Toolkit tk= getToolkit();
		Dimension dm=tk.getScreenSize();
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
	}
	class Enter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(Id.getText().equals(""))JOptionPane.showMessageDialog(null, "用户名不可为空!");
			else if(Key.getText().equals(""))JOptionPane.showMessageDialog(null, "密码不可为空!");
			else if(Id.getText().equals("t")&&Key.getText().equals("t")&&Typ.getSelectedItem()==str[1])JOptionPane.showMessageDialog(null, "教师用户登陆成功");
			else if(Id.getText().equals("s")&&Key.getText().equals("s")&&Typ.getSelectedItem()==str[0])JOptionPane.showMessageDialog(null, "学生用户登陆成功");
			else JOptionPane.showMessageDialog(null, "用户名不存在或者密码不正确!");
		}
		}
	 class ReWrite implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 Id.setText("");
			 Key.setText("");
			 Id.requestFocus();
		}
		}
	 class exit implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 System.exit(0);}
		}
	public static void main(String[] args) {
		login window=new login("225梁烨文");
		window.setDefaultCloseOperation(0);
		window.setVisible(true);// TODO Auto-generated method stub
	}
}
