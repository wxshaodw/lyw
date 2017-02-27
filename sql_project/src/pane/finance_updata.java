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

import function.M_finance;
import function.finance;
import function.personal_info;
import pane.f_i_updata.listener;
 

public class finance_updata extends JPanel {
	String user_id;
    private JLabel jl1;
    finance data;
    private JTextField from;
    private JTextField much;
    private JButton change;
    private JButton save;
    private JButton canle;
    private JLabel title =new JLabel();
    private JLabel jl2;
    private JLabel jl4;
    private JLabel jl6;
    private JLabel jl7;
    private JLabel jl8;
    private JLabel jl9;
    private JLabel jl12;

    private JComboBox jcb;
    private JComboBox jcb1;
    private JComboBox jcb2;
    private JComboBox jcb3;
    JTextArea  ta=new  JTextArea();
    private int[] days=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    public finance_updata(String user_id,finance data) {
    	this.user_id=user_id;
    	this.data=data;
        init();  
    	if(!(this.data==null||main_pane.tip==-1)){
    		title.setText("详细查看");
    		getdata();
    		}
    	else title.setText("添加信息");
        Image image = new ImageIcon("").getImage();
        this.setVisible(true);
    }
 

    public void init() {
        jl1 = new JLabel();
        Image image1 = new ImageIcon("./img/6.0.jpg").getImage();
        jl1.setIcon(new ImageIcon(image1));
        jl1.setBounds(0,-12, 900, 200);
        
        title.setBounds(180,0,250,250);
        title.setFont(new Font("黑体", Font.PLAIN, 30));

        jl2=new JLabel("日期");
        jl2.setBounds(80, 200, 40, 20);

        jl4=new JLabel("收支类型");
         jl4.setBounds(55, 230, 80, 20);
         jcb = new JComboBox();
         jcb.addItem("收入");
         jcb.addItem("支出");
         jcb.setBounds(120, 230, 55, 20);
         
         jcb2 = new JComboBox();
         for(int i=0;i<100;i++)
         { 
         	jcb2.addItem(2050-i);
         }
         jcb2.setBounds(120, 200,55, 20);
         
         jl6=new JLabel("年");
         jl6.setBounds(177, 200, 15, 20);
         
        
         jcb1 = new JComboBox();
         for(int i=1;i<=12;i++)
         { 
         	jcb1.addItem(i);
        }
       
      
         jcb1.setBounds(192, 200,40, 20);
         
         jl7=new JLabel("月");
         jl7.setBounds(235, 200,15, 20);
         
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
         
         jcb3.setBounds(252, 200,40, 20);
         jl8=new JLabel("日");
         jl8.setBounds(295, 200, 15, 20);
         
 		JScrollPane  sp = new JScrollPane(ta);
 		ta.setLineWrap(true);
 		sp.setBounds(120, 260,300, 200);
         from = new JTextField();
        from.setBounds(210, 230,210, 20);
         
         jl12=new JLabel("来源");
        jl12.setBounds(180, 230,30, 20);
         
       jl9=new JLabel("备注");
        jl9.setBounds(80, 330, 120, 20);
         
   
        change = new JButton("修改");
        change.setBounds(170, 600, 100, 40);
        change.addActionListener(new listener());
        
        save =new JButton("保存");
        save.setBounds(80, 600, 100, 40);
        save.addActionListener(new listener());
        
        canle =new JButton("取消");
        canle.setBounds(320, 600, 100, 40);
        canle.addActionListener(new listener());
        
       JLabel jl9l = new JLabel("数额");
       jl9l.setBounds(320, 200, 30, 20);
      much = new JTextField();
      much.setBounds(350, 200,55, 20);
      much.addKeyListener(new keylistener());
      JLabel jl10l = new JLabel("元");
      jl10l.setBounds(410, 200, 30, 20);
      
  	from.setEditable(false);
  	much.setEditable(false);
	jcb1.setEditable(false);
	jcb2.setEditable(false);
	jcb3.setEditable(false);
	ta.setEditable(false);
      
      this.setLayout(null);
      this.add(title);
      this.add(jl10l);
      this.add(jl9l);
      this.add(much);
      this.add(jl9);
      this.add(sp);
      this.add(jcb3);
      this.add(jcb1);
      this.add(jcb2);
        this.add(jcb);
        this.add(jl2);
        this.add(jl4);
        this.add(jl6);
        this.add(jl7);
        this.add(jl8);
        this.add(from);
        this.add(jl12);
        if(this.data==null){
        	from.setEditable(true);
        	much.setEditable(true);
		       jcb.setEditable(true);
		       jcb1.setEditable(true);
		       jcb2.setEditable(true);
		       jcb3.setEditable(true);
		       ta.setEditable(true);
     	this.add(save);
     	this.add(canle);
     }
     else this.add(change);
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
    	String year=data.getdate().substring(0, 4);
    	String month=data.getdate().substring(5,7);
    	String day=data.getdate().substring(8,10);
    	from.setText(data.getsource());
    	much.setText(data.getpayment());
    	ta.setText(data.getremark());
    	jcb1.setSelectedIndex(Integer.parseInt(month)-1);
    	jcb2.setSelectedIndex(2050-Integer.parseInt(year));
    	jcb3.setSelectedIndex(Integer.parseInt(day)-1);
    }
    class listener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if(e.getSource()==save){
        		if (from.getText().length()>10)
        			JOptionPane.showMessageDialog(null, "来源输入有误，长度为1-20个字节","", JOptionPane.INFORMATION_MESSAGE);
        		
        		if (much.getText().length()==0)
        			JOptionPane.showMessageDialog(null, "数额输入有误，不能为空","", JOptionPane.INFORMATION_MESSAGE);
        		else {
        		String year=jcb2.getSelectedItem().toString();
            	String month=jcb1.getSelectedItem().toString();
            	String day=jcb3.getSelectedItem().toString();       	
            	if(Integer.parseInt(month)<10)month="0"+month;
            	if(Integer.parseInt(day)<10)day="0"+day;
        		personal_info user=new personal_info();
        		String  date=year+"-"+month+"-"+day;
        		finance u=new finance();
        		String much_data=much.getText();
        		if(jcb.getSelectedItem().toString().equals("支出"));much_data="-"+much_data;
        		if(data==null){
        			u.setdata("",date,much.getText(),user_id,from.getText(),ta.getText());
            		M_finance run=new M_finance(user_id);
            		try {
        				run.insert_finance(u);
        				JOptionPane.showMessageDialog(jl2, "插入成功","", JOptionPane.INFORMATION_MESSAGE);
    					M_finance create=new M_finance(user_id);
    					main_pane.f_data = create.return_finance();
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
        		else {
        			u.setdata(data.getid(),date,much_data,user_id,from.getText(),ta.getText());
            		M_finance run=new M_finance(user_id);
            		try {
        				run.updata(u);
        				JOptionPane.showMessageDialog(jl2, "修改成功","", JOptionPane.INFORMATION_MESSAGE);
    					M_finance create=new M_finance(user_id);
    					main_pane.f_data = create.return_finance();
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
    		if(e.getSource()==change){
    			title.setText("修改信息");
            	from.setEditable(true);
            	much.setEditable(true);
    		    jcb.setEditable(true);
    		    jcb1.setEditable(true);
    		    jcb2.setEditable(true);
    		    jcb3.setEditable(true);
    		    ta.setEditable(true);
  		       remove(change);
  		       add(save);
  		       add(canle);
  		       updateUI();
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