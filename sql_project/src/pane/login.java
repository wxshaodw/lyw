package pane;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import function.*;
/**
 * 仿QQ登录界面
 * 
 * @author jiang
 */
public class  login extends JFrame {
    // 用户名
    private JTextField username;
    // 密码
    private JPasswordField password;
    // 小容器
    private JLabel jl1;

    // 小按钮
    private JButton bu1;
    private JButton bu2;
    private JButton bu3;
    private JButton bu4;
    private JLabel jl2;
    private JLabel jl3;
    // 列表框
    private JComboBox jcb;

    public login() {
        // 设置窗口标题
        this.setTitle("伟文个人事务管理系统");
        // 窗体组件初始化
        init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 设置布局方式为绝对定位
        this.setLayout(null);
         
        this.setBounds(0, 0, 355, 265);
        // 设置窗体的标题图标
        Image image = new ImageIcon("./img/图标.jpg").getImage();
        this.setIconImage(image);
         
        // 窗体大小不能改变
        this.setResizable(false);
         
        // 居中显示
        this.setLocationRelativeTo(null);
 
        // 窗体可见
        this.setVisible(true);
    }
 

    public void init() {
        // 创建一个容器
        Container con = this.getContentPane();
        jl1 = new JLabel();
        // 设置背景图片
        Image image1 = new ImageIcon("./img/登录界面背景.jpg").getImage();
        jl1.setIcon(new ImageIcon(image1));
        jl1.setBounds(0, -20, 355, 265);
        username = new JTextField();
        username.setBounds(100, 100, 150, 20);

 
        // 密码输入框
        password = new JPasswordField();
        password.setBounds(100, 130, 150, 20);
        password.addActionListener(new listener());
        jl2=new JLabel("用户名");
        jl2.setBounds(40, 100, 80, 20);
        jl3=new JLabel("密码");
        jl3.setBounds(50, 130, 80, 20);
        // 按钮设定
        bu1 = new JButton("退出");
        bu1.setBounds(280, 180, 65, 20);// 给按钮添加1个事件
        bu1.addActionListener(new listener());
        bu2 = new JButton("注册");
        bu2.setBounds(5, 220, 75, 20);
        bu2.addActionListener(new listener());
        bu3 = new JButton("登陆");
        bu3.setBounds(5, 180, 75, 20);
        bu3.addActionListener(new listener());
        bu4 = new JButton("设置");
        bu4.setBounds(280, 220, 65, 20);// 给按钮添加1个事件
        bu4.addActionListener(new listener());
        // 所有组件用容器装载
        jl1.add(bu4);
        jl1.add(bu1);
        jl1.add(bu2);
        jl1.add(bu3);
        jl1.add(username);
        jl1.add(password);
        jl1.add(jl2);
        jl1.add(jl3);
        con.add(jl1);
    }
	public static Boolean test_link() throws IOException{
		File config =new File("./数据库/config.txt");
		if(!config.exists()){
			new set_database();
			return false;
		}
		else{
			 int i=0;
			 String link_data[]=new String[4];
			 FileReader fr=new FileReader("./数据库/config.txt");
			 BufferedReader br=new BufferedReader(fr);
			 while(br.ready()){
				 link_data[i]=br.readLine();
				 i++;
			 }
			 jdbc.setdata(link_data[0],link_data[1],link_data[2],link_data[3]);
			 br.close();
			 fr.close();
			 return true;
		}
		
	}
class listener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if(e.getSource()==bu3||e.getSource()==password){
            	users u_login= new users(username.getText(),password.getText());
            	try {
    				if(u_login.login())dispose();
    			} catch (ClassNotFoundException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}      			
    		}
    		if(e.getSource()==bu2){
    			register r=new register();
    			}
    		if(e.getSource()==bu1)System.exit(0);
    		if(e.getSource()==bu4){
    			File config =new File("./数据库/config.txt");
    			if(!config.exists()){
    				new set_database();
    			}
    			else{
    				 int i=0;
    				 String link_data[]=new String[4];
    				 FileReader fr;
					try {
						fr = new FileReader("./数据库/config.txt");
	    				 BufferedReader br=new BufferedReader(fr);
	    				 while(br.ready()){
	    					 link_data[i]=br.readLine();
	    					 i++;
	    				 }
	    				 set_database.setdata(link_data[0],link_data[1],link_data[2],link_data[3]);
	    				 new set_database();
	    				 dispose();
	    				 br.close();
	    				 fr.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    		}
    	}
    	}
    }
    public static void main(String[] args) {
    	try {
			if(login.test_link())new  login();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
    }
 
}