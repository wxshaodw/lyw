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
 * ��QQ��¼����
 * 
 * @author jiang
 */
public class  login extends JFrame {
    // �û���
    private JTextField username;
    // ����
    private JPasswordField password;
    // С����
    private JLabel jl1;

    // С��ť
    private JButton bu1;
    private JButton bu2;
    private JButton bu3;
    private JButton bu4;
    private JLabel jl2;
    private JLabel jl3;
    // �б��
    private JComboBox jcb;

    public login() {
        // ���ô��ڱ���
        this.setTitle("ΰ�ĸ����������ϵͳ");
        // ���������ʼ��
        init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // ���ò��ַ�ʽΪ���Զ�λ
        this.setLayout(null);
         
        this.setBounds(0, 0, 355, 265);
        // ���ô���ı���ͼ��
        Image image = new ImageIcon("./img/ͼ��.jpg").getImage();
        this.setIconImage(image);
         
        // �����С���ܸı�
        this.setResizable(false);
         
        // ������ʾ
        this.setLocationRelativeTo(null);
 
        // ����ɼ�
        this.setVisible(true);
    }
 

    public void init() {
        // ����һ������
        Container con = this.getContentPane();
        jl1 = new JLabel();
        // ���ñ���ͼƬ
        Image image1 = new ImageIcon("./img/��¼���汳��.jpg").getImage();
        jl1.setIcon(new ImageIcon(image1));
        jl1.setBounds(0, -20, 355, 265);
        username = new JTextField();
        username.setBounds(100, 100, 150, 20);

 
        // ���������
        password = new JPasswordField();
        password.setBounds(100, 130, 150, 20);
        password.addActionListener(new listener());
        jl2=new JLabel("�û���");
        jl2.setBounds(40, 100, 80, 20);
        jl3=new JLabel("����");
        jl3.setBounds(50, 130, 80, 20);
        // ��ť�趨
        bu1 = new JButton("�˳�");
        bu1.setBounds(280, 180, 65, 20);// ����ť���1���¼�
        bu1.addActionListener(new listener());
        bu2 = new JButton("ע��");
        bu2.setBounds(5, 220, 75, 20);
        bu2.addActionListener(new listener());
        bu3 = new JButton("��½");
        bu3.setBounds(5, 180, 75, 20);
        bu3.addActionListener(new listener());
        bu4 = new JButton("����");
        bu4.setBounds(280, 220, 65, 20);// ����ť���1���¼�
        bu4.addActionListener(new listener());
        // �������������װ��
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
		File config =new File("./���ݿ�/config.txt");
		if(!config.exists()){
			new set_database();
			return false;
		}
		else{
			 int i=0;
			 String link_data[]=new String[4];
			 FileReader fr=new FileReader("./���ݿ�/config.txt");
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
    			File config =new File("./���ݿ�/config.txt");
    			if(!config.exists()){
    				new set_database();
    			}
    			else{
    				 int i=0;
    				 String link_data[]=new String[4];
    				 FileReader fr;
					try {
						fr = new FileReader("./���ݿ�/config.txt");
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