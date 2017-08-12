package pane;


import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import function.M_diary;
import function.diary;
import function.file;
import function.personal_info;
import pane.f_i_updata.listener;
 

public class diary_updata extends JPanel {
	String user_id;
	diary data;
    JTextArea  ta=new  JTextArea();
    boolean temp=false;
    private JButton change;
    private JButton save;
    private JButton canle;
    private JLabel w_title =new JLabel();
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl6;
    private JLabel jl7;
    private JLabel jl8;
    private JLabel jl9;
    private JTextField title;
    private JComboBox jcb1;
    private JComboBox jcb2;
    private JComboBox jcb3;
    private int[] days=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    public diary_updata(String user_id,diary data) {
    	this.user_id=user_id;
    	this.data=data;
        init();
        this.setLayout(null);
        this.setBounds(0, 0, 450, 600);
        Image image = new ImageIcon("").getImage();

        if(!(this.data==null)){
        	try {
        		w_title.setText("详细查看");
				this.getdata();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else w_title.setText("添加信息");
        this.setVisible(true);
    }
 

    public void init() {

      
       jl2=new JLabel("日期:");
       jl3=new JLabel("标题:");
       title =new JTextField(50);
       jl2.setBounds(40, 200, 40, 20);
       jl3.setBounds(40, 170, 40, 20);
       w_title.setBounds(180,0,250,250);
       w_title.setFont(new Font("黑体", Font.PLAIN, 30));
       title.setBounds(80, 170,200, 20);
        jcb2 = new JComboBox();
        for(int i=0;i<100;i++)
        { 
        	jcb2.addItem(2050-i);
        }
        jcb2.setBounds(85, 200,55, 20);
        
        jl6=new JLabel("年");
        jl6.setBounds(145, 200, 15, 20);
        
       
        jcb1 = new JComboBox();
        for(int i=1;i<=12;i++)
        { 
        	jcb1.addItem(i);
       }
      
     
        jcb1.setBounds(160, 200,40, 20);
        
        jl7=new JLabel("月");
        jl7.setBounds(205, 200,15, 20);
        
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
        
        jcb3.setBounds(225, 200,40, 20);
        jl8=new JLabel("日");
        jl8.setBounds(270, 200, 15, 20);
		JScrollPane  sp = new JScrollPane(ta);
		ta.setLineWrap(true);
		sp.setBounds(40, 260,380, 230);
        
      jl9=new JLabel("正文:");
       jl9.setBounds(40, 230, 80, 20);
        
  
       change = new JButton("修改");
       change.setBounds(170, 600, 100, 40);
       change.addActionListener(new listener());
       
       save =new JButton("保存");
       save.setBounds(80, 600, 100, 40);
       save.addActionListener(new listener());
       
       canle =new JButton("取消");
       canle.setBounds(320, 600, 100, 40);
       canle.addActionListener(new listener());
       
 	  title.setEditable(false);
      jcb1.setEditable(false);
      jcb2.setEditable(false);
      jcb3.setEditable(false);
      ta.setEditable(false);
      this.add(w_title);
      this.add(jl3);
      this.add(title);
      this.add(jl9);
      this.add(sp);
      this.add(jcb3);
      this.add(jcb1);
      this.add(jcb2);
      this.add(jl2);
      this.add(jl6);
      this.add(jl7);
      this.add(jl8);
      if(this.data==null){
    	  title.setEditable(true);
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
    public void getdata() throws IOException{
    	String year=data.getdate().substring(0, 4);
    	String month=data.getdate().substring(5,7);
    	String day=data.getdate().substring(8,10);
    	title.setText(data.gettitle());
    	ta.setText(data.getdiary_data());
    	jcb1.setSelectedIndex(Integer.parseInt(month)-1);
    	jcb2.setSelectedIndex(2050-Integer.parseInt(year));
    	jcb3.setSelectedIndex(Integer.parseInt(day)-1);
    }
   class listener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
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
    		if(e.getSource()==change){
    			w_title.setText("修改信息");
    	    	  title.setEditable(true);
    		       jcb1.setEditable(true);
    		       jcb2.setEditable(true);
    		       jcb3.setEditable(true);
    		       ta.setEditable(true);
  		       remove(change);
  		       add(save);
  		       add(canle);
  		       updateUI();
    		}
    		if(e.getSource()==save){
        		if (title.getText().length()>10)
        			JOptionPane.showMessageDialog(null, "标题输入有误，长度为1-40个字节","", JOptionPane.INFORMATION_MESSAGE);
        		else {
        		String year=jcb2.getSelectedItem().toString();
            	String month=jcb1.getSelectedItem().toString();
            	String day=jcb3.getSelectedItem().toString();       	
            	if(Integer.parseInt(month)<10)month="0"+month;
            	if(Integer.parseInt(day)<10)day="0"+day;
        		String  date=year+"-"+month+"-"+day;
    			String Path="./diary/"+user_id+"/";
    			File headPath = new File(Path);
    	        if(!headPath.exists()){//判断文件夹是否创建，没有创建则创建新文件夹
    	        	headPath.mkdirs();
    	        }
        		diary u=new diary();
        		if(data==null){
        			u.setdata("",date,ta.getText(),user_id,title.getText(),"");
            		M_diary run=new M_diary(user_id);
            		try {
            			String filename=run.insert_diary(u,Path);
            			if(filename==null||filename.length()<=0)filename="1";
            			else filename=Integer.toString(Integer.parseInt(filename)+1);
            			file.create_file(Path+filename+".txt",ta.getText());
        				JOptionPane.showMessageDialog(jl2, "插入成功","", JOptionPane.INFORMATION_MESSAGE);
    					M_diary create=new M_diary(user_id);
    					main_pane.d_data= create.return_diary();
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
            		u.setdata(data.getid(),date,ta.getText(),user_id,title.getText(),data.getaddress());
            		M_diary run=new M_diary(user_id);
        					try {
        						try {
        							file.deleteFile(data.getaddress());
        							file.create_file(data.getaddress(), ta.getText());
        						} catch (IOException e1) {
        							// TODO Auto-generated catch block
        							e1.printStackTrace();
        						}
        						run.updata_diary(u);
        						JOptionPane.showMessageDialog(jl2, "修改成功","", JOptionPane.INFORMATION_MESSAGE);
        						M_diary create=new M_diary(user_id);
        						main_pane.d_data= create.return_diary();
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
    	}
    }
}