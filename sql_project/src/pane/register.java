package pane;


import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import function.M_personal_info;
import function.personal_info;
import function.users;
 

public class register extends JFrame {
	String user_id;
	String user_name;
	String user_mobile;
	String user_sex;
	String user_birthday;
	String user_age;
	String user_email;
	String user_QQ;
	String user_company;
	String user_position;
    private JTextField name;
    private JTextField phone;
    private JLabel jl1;
    private JTextField email;
    private JTextField QQ;
    private JTextField age;
    private JTextField position;
    private JTextField company;
    private JTextField username;
    private JPasswordField password;
    private JPasswordField repassword;
    boolean temp=false;
    private JButton bu1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;
    private JLabel jl6;
    private JLabel jl7;
    private JLabel jl8;
    private JLabel jl9;
    private JLabel jl10;
    private JLabel jl12;
    private JLabel jl13;
    private JLabel jl14;
    private JLabel jl15;
    private JLabel jl16;
    private JLabel jl17;
    private JLabel jl18;
    private JLabel jl19;
    private JLabel jl20;
    private JLabel jl21;
    private JLabel jl22;
    private JComboBox jcb;
    private JComboBox jcb1;
    private JComboBox jcb2;
    private JComboBox jcb3;
    private int[] days=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    public register() {
        init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(null);
         
        this.setBounds(0, 0, 450, 650);

        Image image = new ImageIcon("").getImage();
        this.setIconImage(image);

        this.setResizable(false);

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
    public void init() {
        Container con = this.getContentPane();
        jl1 = new JLabel();
        Image image1 = new ImageIcon("img/6.0.jpg").getImage();
        jl1.setIcon(new ImageIcon(image1));
        jl1.setBounds(0,-12, 900, 200);
        
        jl15 =new JLabel("登录名");
        jl15.setBounds(90, 200, 150, 20);
        
        username=new JTextField();
        username.setBounds(150, 200, 150, 20);
        
        jl19=new JLabel("*");
        jl19.setFont(new Font("黑体", Font.PLAIN, 20));
        jl19.setBounds(300, 200, 150, 20);
        
        jl16 =new JLabel("密码");
        jl16.setBounds(100, 230, 150, 20);
        
        password=new JPasswordField();
        password.setBounds(150, 230, 150, 20);
        
        jl20=new JLabel("*");
        jl20.setFont(new Font("黑体", Font.PLAIN, 20));
        jl20.setBounds(300, 230, 150, 20);
        
        jl17 =new JLabel("重输密码");
        jl17.setBounds(80, 260, 150, 20);
        
        repassword=new JPasswordField();
        repassword.setBounds(150, 260, 150, 20);
        
        jl21=new JLabel("*");
        jl21.setFont(new Font("黑体", Font.PLAIN, 20));
        jl21.setBounds(300, 260, 150, 20);
        
        name = new JTextField();
        name.setBounds(150, 290, 150, 20);

        phone = new JTextField();
        phone.setBounds(150, 320, 150, 20);
        
        jl2=new JLabel("真实姓名");
        jl2.setBounds(80, 290, 80, 20);
        
        jl22=new JLabel("*");
        jl22.setFont(new Font("黑体", Font.PLAIN, 20));
        jl22.setBounds(300, 290, 150, 20);
        
        jl3=new JLabel("手机号码");
        jl3.setBounds(80, 320, 80, 20);

        jl4=new JLabel("性别");
        jl4.setBounds(320, 290, 40, 20);
        jcb = new JComboBox();
        jcb.addItem("男");
        jcb.addItem("女");
        jcb.addItem(" ");
        jcb.setBounds(360, 290, 40, 20);
        
        jl5=new JLabel("出生于");
        jl5.setBounds(95, 350, 40, 20);

        jcb2 = new JComboBox();
        for(int i=0;i<100;i++)
        { 
        	jcb2.addItem(2050-i);
        }
        jcb2.setBounds(150, 350,55, 20);
        
        jl6=new JLabel("年");
        jl6.setBounds(207, 350, 15, 20);
        
       
        jcb1 = new JComboBox();
        for(int i=1;i<=12;i++)
        { 
        	jcb1.addItem(i);
       }
      
     
        jcb1.setBounds(225, 350,40, 20);
        
        jl7=new JLabel("月");
        jl7.setBounds(267, 350,15, 20);
        
        jcb3 = new JComboBox ();
       
   
        addDays();
        jcb2.addItemListener(new ItemListener(){
         public void itemStateChanged(ItemEvent e) {
          addDays();
         }
        });
        jcb1.addItemListener(new ItemListener(){
         public void itemStateChanged(ItemEvent e) {
          addDays();
         }
        });
        
        jcb3.setBounds(280, 350,40, 20);
        	
  
        
        jl8=new JLabel("日");
        jl8.setBounds(321, 350, 15, 20);
        
        age = new JTextField();
        age.setBounds(360, 350,25, 20);
        
        jl12=new JLabel("岁");
        jl12.setBounds(390, 350, 15, 20);
        
        jl9=new JLabel("E-mail");
        jl9.setBounds(95, 380, 80, 20);
        
        email = new JTextField();
        email.setBounds(150, 380,150, 20);
        
        jl10=new JLabel("QQ");
        jl10.setBounds(100, 410, 50, 20);
        
        QQ = new JTextField();
        QQ.setBounds(150, 410,150, 20);
        
        
        jl13=new JLabel("公司");
        jl13.setBounds(100, 440, 50, 20);
        
        jl14=new JLabel("职位");
        jl14.setBounds(100, 470, 50, 20);
        
        jl18=new JLabel("注：带*为必填");
        jl18.setBounds(100, 500, 200, 20);
        
        email = new JTextField();
        email.setBounds(150, 380,150, 20);
        
        company = new JTextField();
        company.setBounds(150, 440,150, 20);
        
        position = new JTextField();
        position.setBounds(150, 470,150, 20);
        bu1 = new JButton("确认");
        bu1.setBounds(170, 550, 100, 40);
        bu1.addActionListener(new listener());
        
        con.add(jcb3);
        con.add(jcb1);
        con.add(jcb2);
        con.add(position);
        con.add(company);
        con.add(jl13);
        con.add(jl14);
        con.add(jcb);
        con.add(bu1);
        con.add(jl1);
        con.add(name);
        con.add(phone);
        con.add(jl2);
        con.add(jl3);
        con.add(jl4);
        con.add(jl5);
        con.add(jl6);
        con.add(jl7);
        con.add(jl8);
        con.add(jl9);
        con.add(email);
        con.add(jl10);
        con.add(QQ);
        con.add(age);
        con.add(jl12);
        con.add(jl15);
        con.add(jl16);
        con.add(jl17);
        con.add(jl18);
        con.add(jl19);
        con.add(jl20);
        con.add(jl21);
        con.add(jl22);
        con.add(username);
        con.add(password);
        con.add(repassword);
    }
    private void addDays(){
    	  int year=Integer.parseInt(jcb2.getSelectedItem().toString());
    	  int month=Integer.parseInt(jcb1.getSelectedItem().toString())-1;
    	  if(year%4==0 && year%100!=0 || year%400==0){
    	   days[1]=29;
    	  }else{
    	   days[1]=28;
    	  }
    	  jcb3.removeAllItems();
    	  for(int i=0;i<days[month];i++){
    	   jcb3.addItem(new String(""+(i+1)));
    	  }
    	 }
    class listener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String year=jcb2.getSelectedItem().toString();
        	String month=jcb1.getSelectedItem().toString();
        	String day=jcb3.getSelectedItem().toString();       	
        	if(Integer.parseInt(month)<10)month="0"+month;
        	if(Integer.parseInt(day)<10)day="0"+day;
    		personal_info user=new personal_info();
    		String  birthday=year+"-"+month+"-"+day;
    		user.setdata(user_id,name.getText(),jcb.getSelectedItem().toString(), age.getText(),phone.getText(),year+"-"+month+"-"+day, email.getText(), QQ.getText(),"2",company.getText(),position.getText());
    		M_personal_info run=new M_personal_info(user_id);
    		try {
    			boolean result=false;
    			if(result=users.register(username.getText(),password.getText(),repassword.getText(),user)){
    				dispose();
    				new login();
    			}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
    	}
    }
	/*public static void main(String[] args) {
        // 实例化对象
    }*/
}