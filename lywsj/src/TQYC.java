import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
public class TQYC extends JFrame{
	Container c;
	JPanel A=new JPanel();//改成背景框
	JPanel B=new JPanel();//改成背景框
	public TQYC()
	{
		super("欢迎使用教师科研信息管理系统");
		setLayout(null);
		TQYQ a=new TQYQ();
		TQYU b=new TQYU();
		TQYG d=new TQYG();
		a.setBounds(0, 0, 1500, 200);
		b.setBounds(0, 150, 300, 600);
		d.setBounds(200, 200, 1500,800);
		add(b);
		add(d);
		add(a);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1200, 750);
	//this.setResizable(false);
	this.setVisible(true);}
	public static void main(String args[]){
		new TQYC();
	}
}

