package SwingTest;

import java.awt.*; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import javax.swing.*;  
public class GUIQQ extends JFrame implements MouseListener{ 
 //北部区域标签
	JLabel jlb; 
 //中部区域  
	JPanel jp;  
	JComboBox cmbzt;//组合框 设置状态用的 
	JLabel jp_jlbtx,jp_jlbzczh,jp_jlbzhmm; //标签"注册账号""找回密码" 
	JTextField jp_jtusr; // QQ号码/手机/邮箱  
	JPasswordField jp_pw;  //密码  
	JCheckBox jp_jcbjzmm,jp_jcbzddl;//复选框 设置"记住密码""自动登录"
	Font f1=new Font("宋体", Font.PLAIN, 14); //设置字体  
	JButton jp_jbdzh,jp_jbsz,jp_jbdl;//按钮 设置登陆等
	
	public GUIQQ() {   
		jlb=new JLabel(new ImageIcon("../img/cyqq.jpg")); //上端的城市学院图片       
		jp=new JPanel();   
		jp.setLayout(null);
		//显示QQ头像
		jp_jlbtx=new JLabel(new ImageIcon("img/qq.jpg"));   
		jp_jlbtx.setBounds(18, 10, 85, 85); //设置标签位置 前提是要空布局
		//账号输入文本框
		jp_jtusr=new JTextField("QQ号码/手机/邮箱"); 
		jp_jtusr.setForeground(Color.DARK_GRAY);//设置颜色   
		jp_jtusr.addMouseListener(this); 
		jp_jtusr.setBounds(118, 11, 170, 25);  
		//密码输入文本框
		jp_pw=new JPasswordField("",24);
		jp_pw.setForeground(Color.DARK_GRAY);   
		jp_pw.addMouseListener(this); 
		jp_pw.setBounds(118, 45, 170, 24); 
		//“注册账号”文本，在账号输入框后面显示
		jp_jlbzczh=new JLabel("注册账号");   
		jp_jlbzczh.setFont(f1); 
		jp_jlbzczh.setForeground(Color.BLUE);   
		jp_jlbzczh.setBounds(300, 10, 70, 25);  
		//“找回密码”文本，在密码输入框后面显示
		jp_jlbzhmm=new JLabel("找回密码"); 
		jp_jlbzhmm.setFont(f1);//设置"找回密码"字体 
		jp_jlbzhmm.setForeground(Color.BLUE); //设置"找回密码"字体颜色
		jp_jlbzhmm.setBounds(300, 43, 70, 25);  
		//登录状态组合框
		String[] s={"在线","隐身","忙碌","离线"}; //设置状态 
		cmbzt=new JComboBox(s);   
		cmbzt.setFont(f1); 
		cmbzt.setBounds(300, 78, 60, 21);  
		//"记住密码"复选框
		 jp_jcbjzmm=new JCheckBox("记住密码");   
		 jp_jcbjzmm.setFont(f1); 
		 jp_jcbjzmm.setBounds(114, 78, 90, 20); 
		 //"自动登录"复选框
		 jp_jcbzddl=new JCheckBox("自动登录");   
		 jp_jcbzddl.setFont(f1); 
		 jp_jcbzddl.setBounds(206, 78, 90, 20);
		 //"多账号"按钮
		 jp_jbdzh=new JButton("多账号");      
		 jp_jbdzh.setFont(f1);      
		 jp_jbdzh.setBounds(10, 120, 76, 21);
		//"设置"按钮
		 jp_jbsz=new JButton("设置");   
		 jp_jbsz.setFont(f1); 
		 jp_jbsz.setBounds(95, 120, 65, 21);  
		//"登录"按钮
		 jp_jbdl=new JButton("登录");   
		 jp_jbdl.setFont(f1); 
		 jp_jbdl.setBounds(297, 120, 65, 21); 
		 //添加各个组件 
		 jp.add(jp_jlbtx);//头像   
		 jp.add(jp_jtusr); //账号文本框
		 jp.add(jp_jlbzhmm); //找回密码标签  
		 jp.add(jp_pw); //密码框
		 jp.add(jp_jlbzczh);//注册账号标签
		 jp.add(cmbzt); //登录状态组合框
		 jp.add(jp_jcbjzmm); //记住密码复选框
		 jp.add(jp_jcbzddl); //自动登录复选框
		 jp.add(jp_jbdzh); //多帐号按钮
		 jp.add(jp_jbsz);  //设置按钮
		 jp.add(jp_jbdl);//登录按钮
		 
		 this.add(jlb,"North");//标签放到最北部 
		 this.add(jp,BorderLayout.CENTER);// 放到中部    
		 
		 this.setIconImage(new ImageIcon("img/qq.jpg").getImage());//设置窗口上的qq小图片  
		 this.setResizable(false);//不允许放大，改变窗口大小等   
		 this.setSize(380,275); 
		 this.setLocation(500,200); 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		 this.setVisible(true);    
	} 
	public void mouseClicked(MouseEvent e) {  
		if(e.getSource()==jp_jtusr)   { 
			jp_jtusr.setText(""); 
			jp_jtusr.setForeground(Color.BLACK);   
		} 
		else if(e.getSource()==jp_pw) {
			jp_pw.setText(""); 
			jp_pw.setForeground(Color.BLACK);
			jp_pw.setEchoChar('●');   
		}
	}
	public static void main(String[] args) {   
		GUIQQ acl=new GUIQQ(); 
		acl.setTitle("2016未来QQ");
		}   
 public void mousePressed(MouseEvent e) { }      
 public void mouseReleased(MouseEvent e) {}      
 public void mouseEntered(MouseEvent e) {}
 public void mouseExited(MouseEvent e) { }  
}
