package pane;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import function.M_friends_info;
import function.M_personal_info;
import function.friends_info;
import function.personal_info;
 

public class f_i_updata extends JPanel {
	String user_id;
	friends_info data;
    private JTextField name = new JTextField();
    private JTextField phone;
    private JLabel jl1;
    private JTextField email;
    private JTextField QQ;
    private JTextField age;
    private JTextField position;
    private JTextField company;
    private JTextField phone2;
    private JTextField phone3;
    private JTextArea  ta;
    private JButton change;
    private JButton save;
    private JButton canle;
    private JLabel title =new JLabel();
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
    private JComboBox jcb;
    private JComboBox jcb1;
    private JComboBox jcb2;
    private JComboBox jcb3;
    private int[] days=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    public f_i_updata(String user_id,friends_info data) {
    	this.user_id=user_id;
    	this.data=data;
    	init();
    	if(!(this.data==null||main_pane.tip==-1)){
    		title.setText("详细查看");
    		getdata();
    		}
    	else title.setText("添加信息");
    }
 

    public void init() {
        name.setBounds(150, 200, 150, 20);
        
        phone = new JTextField();
        phone.setBounds(150, 230, 150, 20);
        phone.addKeyListener(new keylistener());
        
        title.setBounds(180,0,250,250);
        title.setFont(new Font("黑体", Font.PLAIN, 30));
        
        jl2=new JLabel("姓名");
        jl2.setBounds(100, 200, 80, 20);
        jl3=new JLabel("固定电话");
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
        jl8.setBounds(322, 260, 15, 20);
        
        age = new JTextField();
        age.addKeyListener(new keylistener()); 
        
        
        jl12=new JLabel("岁");
        jl12.setBounds(390, 260, 15, 20);
        
        jl9=new JLabel("E-mail");
        jl9.setBounds(95, 290, 80, 20);
        
        email = new JTextField();
        email.setBounds(150, 290,150, 20);
        age.setBounds(360, 260,25, 20);

        jl10=new JLabel("QQ");
        jl10.setBounds(100, 320, 50, 20);
        jl10.addKeyListener(new keylistener()); 
        
        QQ = new JTextField();
        QQ.setBounds(150, 320,150, 20);
        QQ.addKeyListener(new keylistener()); 
        
        
        change = new JButton("修改");
        change.setBounds(170, 600, 100, 40);
        change.addActionListener(new listener());
        
        save =new JButton("保存");
        save.setBounds(80, 600, 100, 40);
        save.addActionListener(new listener());
        
        canle =new JButton("取消");
        canle.setBounds(320, 600, 100, 40);
        canle.addActionListener(new listener());
        
        jl13=new JLabel("公司");
        jl13.setBounds(100, 350, 50, 20);
        
        jl14=new JLabel("职位");
        jl14.setBounds(100, 380, 50, 20);
        
        company = new JTextField();
        company.setBounds(150, 350,150, 20);

        
        position = new JTextField();
        position.setBounds(150, 380,150, 20);

        
        jl15=new JLabel("手机号码");
        jl15.setBounds(80, 410, 60, 20);
        
        jl16=new JLabel("备用电话");
        jl16.setBounds(80,440, 60, 20);
        
        phone2 = new JTextField();
        phone2.setBounds(150, 410,150, 20);

        phone2.addKeyListener(new keylistener());
        phone3 = new JTextField();
        phone3.setBounds(150,440,150, 20);
        phone3.addKeyListener(new keylistener());
        
        ta=new  JTextArea();
        JScrollPane  sp = new JScrollPane(ta);
 		ta.setLineWrap(true);
 		sp.setBounds(150, 480,200, 100);

 	   JLabel jl16l = new JLabel("备注");
       jl16l.setBounds(90,500, 60, 20);
       
       name.setEditable(false);
       phone.setEditable(false);
       email.setEditable(false);
       jcb.setEditable(false);
       jcb1.setEditable(false);
       jcb2.setEditable(false);
       jcb3.setEditable(false);
       QQ.setEditable(false);
       age.setEditable(false);
       position.setEditable(false);
       company.setEditable(false);
       phone2.setEditable(false);
       phone3.setEditable(false);
       ta.setEditable(false);
       
       this.add(title);
        this.add(jl16l);
        this.add(sp);
        this.setLayout(null);
        this.add(jcb2);
        this.add(jcb1);
        this.add(jcb3);
        this.add(jl15);
        this.add(jl16);
        this.add(phone2);
        this.add(phone3);
        this.add(position);
        this.add(company);
        this.add(jl13);
        this.add(jl14);
        this.add(jcb);
        this.add(name);
        this.add(phone);
        this.add(jl2);
        this.add(jl3);
        this.add(jl4);
        this.add(jl5);
        this.add(jl6);
        this.add(jl7);
        this.add(jl8);
        this.add(jl9);
        this.add(email);
        this.add(jl10);
        this.add(QQ);
        this.add(age);
        this.add(jl12);
        if(this.data==null){
		       name.setEditable(true);
		       phone.setEditable(true);
		       email.setEditable(true);
		       jcb.setEditable(true);
		       jcb1.setEditable(true);
		       jcb2.setEditable(true);
		       jcb3.setEditable(true);
		       QQ.setEditable(true);
		       age.setEditable(true);
		       position.setEditable(true);
		       company.setEditable(true);
		       phone2.setEditable(true);
		       phone3.setEditable(true);
		       ta.setEditable(true);
        	this.add(save);
        	this.add(canle);
        }
        else this.add(change);
        this.setVisible(true);
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
    	String year=data.getbirthday().substring(0, 4);
    	String month=data.getbirthday().substring(5,7);
    	String day=data.getbirthday().substring(8,10);
    	name.setText(data.getname());
    	phone.setText(data.getphone());
    	phone2.setText(data.getmobile());
    	phone3.setText(data.getmobile2());
    	email.setText(data.getemail());
    	QQ.setText(data.getQQ());
    	age.setText(data.getage());
    	company.setText(data.getcompany());
    	position.setText(data.getposition());
    	jcb.setSelectedItem(data.getsex());
    	jcb1.setSelectedIndex(Integer.parseInt(month)-1);
    	jcb2.setSelectedIndex(2050-Integer.parseInt(year));
    	jcb3.setSelectedIndex(Integer.parseInt(day)-1);
    	ta.setText(data.getremark());
    }
    class listener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if(e.getSource()==change){
    			title.setText("修改信息");
 		       name.setEditable(true);
 		       phone.setEditable(true);
 		       email.setEditable(true);
 		       jcb.setEditable(true);
 		       jcb1.setEditable(true);
 		       jcb2.setEditable(true);
 		       jcb3.setEditable(true);
 		       QQ.setEditable(true);
 		       age.setEditable(true);
 		       position.setEditable(true);
 		       company.setEditable(true);
 		       phone2.setEditable(true);
 		       phone3.setEditable(true);
 		       ta.setEditable(true);
 		       remove(change);
 		       add(save);
 		       add(canle);
 		       updateUI();
    		}
    		if(e.getSource()==save){
        		if (name.getText().length()>10||name.getText().length()==0)
        			JOptionPane.showMessageDialog(null, "姓名输入有误，长度为1-10个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if (age.getText().length()>3)
        			JOptionPane.showMessageDialog(null, "年龄输入有误，长度为1-3个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if (phone.getText().length()>8)
        			JOptionPane.showMessageDialog(null, "固定电话输入有误，长度为1-8个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if(phone2.getText().length()>11)
        			JOptionPane.showMessageDialog(null, "手机电话输入有误，长度为1-11个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if (email.getText().length()>30)
        			JOptionPane.showMessageDialog(null, "email输入有误，长度为1-30个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if(QQ.getText().length()>12)
        			JOptionPane.showMessageDialog(null, "QQ输入有误，长度为1-8个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if(phone3.getText().length()>11)
        			JOptionPane.showMessageDialog(null, "备用电话输入有误，长度为1-11个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if (company.getText().length()>100)
        			JOptionPane.showMessageDialog(null, "公司输入有误，长度为1-00个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if (position.getText().length()>20)
        			JOptionPane.showMessageDialog(null, "职位输入有误，长度为1-20个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else if(ta.getText().length()>100)
        			JOptionPane.showMessageDialog(null, "备注输入有误，长度为1-100个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else{
        		String year=jcb2.getSelectedItem().toString();
            	String month=jcb1.getSelectedItem().toString();
            	String day=jcb3.getSelectedItem().toString();       	
            	if(Integer.parseInt(month)<10)month="0"+month;
            	if(Integer.parseInt(day)<10)day="0"+day;
        		String  birthday=year+"-"+month+"-"+day;
        		friends_info u=new friends_info();
        		if(data==null){
            		u.setdata("",name.getText(),jcb.getSelectedItem().toString(), age.getText(),phone.getText(),birthday,phone2.getText(), email.getText(), QQ.getText(),user_id,phone3.getText(),company.getText(),position.getText(),ta.getText());
            		M_friends_info run=new M_friends_info(user_id);
            		try {
        				run.insert_friends_info(u);
        				JOptionPane.showMessageDialog(jl2, "插入成功","", JOptionPane.INFORMATION_MESSAGE);
        				M_friends_info create=new M_friends_info (user_id);
        				main_pane.fi_data=create.return_f_i();
        				main_pane.create_table(user_id,main_pane.source);
        			} catch (ClassNotFoundException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			} catch (SQLException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
        		}
        		else{
        			u.setdata(data.getid(),name.getText(),jcb.getSelectedItem().toString(), age.getText(),phone.getText(),birthday,phone2.getText(), email.getText(), QQ.getText(),user_id,phone3.getText(),company.getText(),position.getText(),ta.getText());
            		M_friends_info run=new M_friends_info(user_id);
            		try {
        				run.updata(user_id,u);
        				JOptionPane.showMessageDialog(jl2, "修改成功","", JOptionPane.INFORMATION_MESSAGE);
        				M_friends_info create=new M_friends_info (user_id);
        				main_pane.fi_data=create.return_f_i();
        				main_pane.create_table(user_id,main_pane.source);
        			} catch (ClassNotFoundException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			} catch (SQLException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
            	}
    		}
        }
    		if(e.getSource()==canle){
    			if(data==null)
					try {
						main_pane.create_table(user_id,main_pane.source);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else main_pane.updata_panel(user_id, main_pane.source, main_pane.tip);
    		}
    		}
 }
    class keylistener implements KeyListener{

    	public void keyTyped(KeyEvent e) {
    		char c=e.getKeyChar();
    		if(c<'0'||c>'9'){
    			e.consume();
    		}

    	}

    	public void keyPressed(KeyEvent e) {
    		// TODO Auto-generated method stub
    		
    	}

    	public void keyReleased(KeyEvent e) {
    		// TODO Auto-generated method stub
    		
    	}
    	 
     }
}