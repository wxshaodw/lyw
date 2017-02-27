package pane;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import function.key;
import function.users;
 

public class change_password extends JFrame {
    // 用户名
    private JPasswordField password;
    // 密码
    private JPasswordField newpassword;
    private JPasswordField repassword;
    // 小容器
    //private JLabel jl1;
    


    // 小按钮
    private JLabel jl1;
    private JButton bu1;
    private JButton bu2;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;
    private JLabel jl6;
    private JLabel jl9;
 
    // 列表框

    public change_password() {
        // 设置窗口标题
        this.setTitle("修改密码");
        // 窗体组件初始化
        init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 设置布局方式为绝对定位
        this.setLayout(null);
         
        this.setBounds(0, 0, 450, 400);
        // 设置窗体的标题图标
        Image image = new ImageIcon("").getImage();
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
        Image image1 = new ImageIcon("./img/6.0.jpg").getImage();
        jl1.setIcon(new ImageIcon(image1));
        jl1.setBounds(-7,-12, 900, 200);
        password = new JPasswordField();
        password.setBounds(70, 200, 150, 20);
        

 
        // 密码输入框
        newpassword = new JPasswordField();
        newpassword.setBounds(70, 230, 150, 20);
        
        jl2=new JLabel("原密码");
        jl2.setBounds(25, 200, 80, 20);
        jl3=new JLabel("新密码");
        jl3.setBounds(25, 230, 80, 20);
        // 用户登录状态选择
        jl4=new JLabel();
        jl4.setBounds(230, 200, 200, 20);

        
        jl5=new JLabel();
       jl5.setBounds(230, 230, 200, 20);
 
        
        jl6=new JLabel();
        jl6.setBounds(230, 260, 200, 20);
        
               
        jl9=new JLabel("重输新密码");
        jl9.setBounds(5, 260, 80, 20);
        
        repassword = new JPasswordField();
        repassword.setBounds(70, 260,150, 20);
        // 按钮设定
        
        
        bu1 = new JButton("保存");
        bu1.setBounds(50, 300, 100, 40);
        bu1.addActionListener(new listener());  
        
        bu2 = new JButton("退出");
        bu2.setBounds(300, 300, 100, 40);
        bu2.addActionListener(new listener());  
       
 
        // 所有组件用容器装载
        con.add(bu2);
        con.add(bu1);
        con.add(jl1);
        con.add(newpassword);
        con.add(password);
        con.add(jl2);
        con.add(jl3);
        con.add(jl4);
        con.add(jl5);
        con.add(jl6);
        con.add(jl9);
        con.add(repassword);

    }
    class listener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if(e.getSource()==bu1){
        		try {
        			boolean flag=users.change_password(main_pane.user_id,key.encrypt(password.getText()),key.encrypt(newpassword.getText()),key.encrypt(repassword.getText()),jl4,jl5,jl6);
        			if(flag)dispose();
    			} catch (ClassNotFoundException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} 
    		}
    		if(e.getSource()==bu2)dispose();
    	}
    }
 /*   public static void main(String[] args) {
        // 实例化对象
    	register a = new  register();
    }
 */
}