package pane;


import java.awt.Container;
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
import javax.swing.JTextField;

import function.M_personal_info;
import function.personal_info;
 

public class p_i_updata extends JFrame {
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
    private JComboBox jcb;
    private JComboBox jcb1;
    private JComboBox jcb2;
    private JComboBox jcb3;
    private int[] days=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    public p_i_updata(String user_id,String name, String phone,String sex,String birthday,String age,String email,String QQ,String company,String position) {
    	this.user_id=user_id;
    	this.user_name=name;
    	this.user_mobile=phone;
    	this.user_sex=sex;
    	this.user_birthday=birthday;
    	this.user_age=age;
    	this.user_email=email;
    	this.user_QQ=QQ;
    	this.user_company=company;
    	this.user_position=position;
        this.setTitle("个人信息更新");

        init();
        getdata();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(null);
         
        this.setBounds(0, 0, 450, 600);

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
        name = new JTextField();
        name.setBounds(150, 200, 150, 20);

        phone = new JTextField();
        phone.setBounds(150, 230, 150, 20);
        
        jl2=new JLabel("姓名");
        jl2.setBounds(100, 200, 80, 20);
        jl3=new JLabel("手机号码");
        jl3.setBounds(80, 230, 80, 20);

        jl4=new JLabel("性别");
        jl4.setBounds(320, 200, 40, 20);
        jcb = new JComboBox();
        jcb.addItem("男");
        jcb.addItem("女");
        jcb.addItem(" ");
        jcb.setBounds(360, 200, 40, 20);
        
        jl5=new JLabel("出生于");
        jl5.setBounds(95, 260, 40, 20);

        jcb2 = new JComboBox();
        for(int i=0;i<100;i++)
        { 
        	jcb2.addItem(2050-i);
        }
        jcb2.setBounds(150, 260,55, 20);
        
        jl6=new JLabel("年");
        jl6.setBounds(207, 260, 15, 20);
        
       
        jcb1 = new JComboBox();
        for(int i=1;i<=12;i++)
        { 
        	jcb1.addItem(i);
       }
      
     
        jcb1.setBounds(225, 260,40, 20);
        
        jl7=new JLabel("月");
        jl7.setBounds(267, 260,15, 20);
        
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
        
        jcb3.setBounds(280, 260,40, 20);
        	
  
        
        jl8=new JLabel("日");
        jl8.setBounds(321, 260, 15, 20);
        
        age = new JTextField();
        age.setBounds(360, 260,25, 20);
        
        jl12=new JLabel("岁");
        jl12.setBounds(390, 260, 15, 20);
        
        jl9=new JLabel("E-mail");
        jl9.setBounds(95, 290, 80, 20);
        
        email = new JTextField();
        email.setBounds(150, 290,150, 20);
        
        jl10=new JLabel("QQ");
        jl10.setBounds(100, 320, 50, 20);
        
        QQ = new JTextField();
        QQ.setBounds(150, 320,150, 20);
        
        
        jl13=new JLabel("公司");
        jl13.setBounds(100, 350, 50, 20);
        
        jl14=new JLabel("职位");
        jl14.setBounds(100, 380, 50, 20);
        
        email = new JTextField();
        email.setBounds(150, 290,150, 20);
        
        company = new JTextField();
        company.setBounds(150, 350,150, 20);
        
        position = new JTextField();
        position.setBounds(150, 380,150, 20);
        bu1 = new JButton("确认");
        bu1.setBounds(170, 450, 100, 40);
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
    public void getdata(){
    	String year=this.user_birthday.substring(0, 4);
    	String month=this.user_birthday.substring(5,7);
    	String day=this.user_birthday.substring(8,10);
    	name.setText(this.user_name);
    	phone.setText(this.user_mobile);
    	email.setText(this.user_email);
    	QQ.setText(this.user_QQ);
    	age.setText(this.user_age);
    	company.setText(this.user_company);
    	position.setText(this.user_position);
    	jcb.setSelectedItem(this.user_sex);
    	jcb1.setSelectedIndex(Integer.parseInt(month)-1);
    	jcb2.setSelectedIndex(2050-Integer.parseInt(year));
    	jcb3.setSelectedIndex(Integer.parseInt(day)-1);
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
				run.updata_personal_info(user_id,user);
				JOptionPane.showMessageDialog(jl2, "修改成功","", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    	}
    }
}