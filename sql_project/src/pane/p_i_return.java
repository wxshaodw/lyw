package pane;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import function.jdbc;
 
public class p_i_return extends JFrame {
	String user_id;

    private JLabel jl1;
    private JButton bu1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;
    private JLabel jl9;
    private JLabel jl10;
    private JLabel jl11;
    private JLabel jl12;
    private JLabel jl2l;
    private JLabel jl3l;
    private JLabel jl4l;
    private JLabel jl5l;
    private JLabel jl8l;
    private JLabel jl9l;
    private JLabel jl10l;
    private JLabel jl13;
    private JLabel jl14;
    private JLabel jl13l;
    private JLabel jl14l;


    public p_i_return(String user_id) {
    	this.user_id=user_id;

        this.setTitle("个人名片");

        init();
        getdata();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(null);
         
        this.setBounds(0, 0, 450, 600);

        Image image = new ImageIcon(" ").getImage();
        this.setIconImage(image);

        this.setResizable(false);

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
 

    public void init() {
        Container con = this.getContentPane();
        jl1 = new JLabel();
        Image image1 = new ImageIcon("./img/6.0.jpg").getImage();
        jl1.setIcon(new ImageIcon(image1));
        jl1.setBounds(0,-12, 900, 200);
        jl3l=new JLabel(" ");
        jl3l.setBounds(150, 200, 150, 20);

        jl2l=new JLabel(" ");
        jl2l.setBounds(150, 230, 150, 20);
        
        jl2=new JLabel("姓名");
        jl2.setBounds(100, 200, 80, 20);
        jl3=new JLabel("手机号码");
        jl3.setBounds(80, 230, 80, 20);
        jl4=new JLabel("性别");
        jl4.setBounds(320, 200, 40, 20);
        
        jl4l=new JLabel(" ");

       jl4l.setBounds(360, 200, 40, 20);
        
        jl5=new JLabel("出生于");
        jl5.setBounds(95, 260, 40, 20);
        jl5l=new JLabel(" ");
        jl5l.setBounds(150, 260,150, 20);
        
        jl8l =new JLabel("11");
        jl8l.setBounds(360, 260,25, 20);
        
        jl11=new JLabel("年龄");
        jl11.setBounds(320, 260, 30, 20);
        
        jl12=new JLabel("岁");
        jl12.setBounds(390, 260, 15, 20);
        
        jl9=new JLabel("E-mail");
        jl9.setBounds(95, 290, 80, 20);
        
        jl9l=new JLabel(" ");
        jl9l.setBounds(150, 290,150, 20);

        jl10=new JLabel("QQ");
        jl10.setBounds(110, 320, 80, 20);
        
        jl10l = new JLabel(" ");
        jl10l.setBounds(150, 320,150, 20);
        
        jl13=new JLabel("公司");
        jl13.setBounds(105, 350, 80, 20);
        
        jl13l = new JLabel(" ");
        jl13l.setBounds(150, 350,150, 20);
        
        jl14=new JLabel("职位");
        jl14.setBounds(105, 380, 80, 20);
        
        jl14l = new JLabel(" ");
        jl14l.setBounds(150, 380,150, 20);
        bu1 =new JButton ("编辑");
        bu1.setBounds(180, 500,80, 20);
        bu1.addActionListener(new Listener());
        
        con.add(jl14);
        con.add(jl14l);
        con.add(jl13l);
        con.add(jl13);
        con.add(jl1);
        con.add(bu1);
        con.add(jl2);
        con.add(jl3);
        con.add(jl4);
        con.add(jl5);
        con.add(jl9);
        con.add(jl10);
        con.add(jl11);
        con.add(jl12);
        con.add(jl10);
        con.add(jl2l);
        con.add(jl3l);
        con.add(jl4l);
        con.add(jl5l);
        con.add(jl8l);
        con.add(jl9l);
        con.add(jl10l);
    }
 
    public void getdata(){
    	
		try {
			jdbc j_getdata = new jdbc();
			ResultSet r_getdata=j_getdata.get_state().executeQuery("select * from personalinfo where u_id='"+this.user_id+"'");
			r_getdata.next();
			jl3l.setText(r_getdata.getString("p_name"));
	    	jl2l.setText(r_getdata.getString("p_mobile"));
	    	jl4l.setText(r_getdata.getString("p_sex"));
	    	jl5l.setText(r_getdata.getString("p_birthday"));
	    	jl8l.setText(r_getdata.getString("p_age"));
	    	jl9l.setText(r_getdata.getString("P_email"));
	    	jl10l.setText(r_getdata.getString("p_QQ"));
	    	jl13l.setText(r_getdata.getString("p_company"));
	    	jl14l.setText(r_getdata.getString("p_position"));
	    	j_getdata.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new p_i_updata(user_id,jl3l.getText(),jl2l.getText(),jl4l.getText(),jl5l.getText(),jl8l.getText(),jl9l.getText(),jl10l.getText(),jl13l.getText(),jl14l.getText());
			dispose();
			
		}
		}
}
