package pane;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import function.jdbc;
import function.key;


public class set_database extends JFrame {
	private static JTextField severname =new JTextField();
	private static JTextField database=new JTextField();
    private static JTextField username=new JTextField();
    private static JPasswordField password =new JPasswordField();
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;
    private JLabel jl6;
    private JButton bu1;
    private JButton bu2;
    public set_database() {

        this.setTitle("�������ݿ�");

        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);

        this.setBounds(0, 0,400,300);

        Image image = new ImageIcon("").getImage();
        this.setIconImage(image);

        this.setResizable(false);

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    public void init() {

        Container con = this.getContentPane();
        jl1 = new JLabel();

        Image image1 = new ImageIcon("./img/�������ݿ�2.png").getImage();
        jl1.setIcon(new ImageIcon(image1));
        jl1.setBounds(0, -20, 400, 300);

        jl2 = new JLabel();
        Image image2 = new ImageIcon("e:/a.gif").getImage();
        jl2.setIcon(new ImageIcon(image2));
        jl2.setBounds(40, 95, 50, 60);
        
        severname.setBounds(155, 40, 150, 20);
        
        jl3 = new JLabel("����������");
        jl3.setBounds(85, 20, 70, 20);
        
        database.setBounds(155, 80, 150, 20);
        
        jl4 = new JLabel("���ݿ�����");
        jl4.setBounds(85, 60, 70, 20);
        
        username.setBounds(155, 120, 150, 20);
        
        jl5 = new JLabel("���ݿ��˺�");
        jl5.setBounds(85, 100, 70, 20);

        password.setBounds(155,150, 150, 20);

        jl6 = new JLabel("��������");
        jl6.setBounds(95, 130, 70, 20);

        bu1 = new JButton("����");
        bu1.setBounds(155, 170, 65, 20);
        bu1.addActionListener(new Listener());
        
        bu2 = new JButton("�˳�");
        bu2.setBounds(238, 170, 65, 20);
        bu2.addActionListener(new Listener());

        con.add(jl5);
        con.add(jl6);
        con.add(jl2);
        con.add(jl3);
        con.add(jl4);
        con.add(bu1);
        con.add(bu2);
        con.add(jl1);
      jl1.add(username);
        jl1.add(password);
        jl1.add(severname);
        jl1.add(database);
    }
	class Listener implements ActionListener{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bu1){
				if(severname.getText().equals(""))JOptionPane.showMessageDialog(null, "������������Ϊ��","", JOptionPane.INFORMATION_MESSAGE);
				else if(database.getText().equals(""))JOptionPane.showMessageDialog(null, "���ݿ�������Ϊ��","", JOptionPane.INFORMATION_MESSAGE);
				else if(username.getText().equals(""))JOptionPane.showMessageDialog(null, "���ݿ��˺Ų���Ϊ��","", JOptionPane.INFORMATION_MESSAGE);
				else if(username.getText().equals(""))JOptionPane.showMessageDialog(null, "���ݿ����벻��Ϊ��","", JOptionPane.INFORMATION_MESSAGE);
				else {
					try {
						fileout();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					jdbc.setdata(key.encrypt(severname.getText()),key.encrypt(database.getText()),key.encrypt(username.getText()), key.encrypt(password.getText()));
					try {
						jdbc test=new jdbc();
						test.close();
						new login();
						dispose();
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "���ӷ�����ʧ�ܣ�����������Ϣ","��ʾ", JOptionPane.INFORMATION_MESSAGE);
						// TODO Auto-generated catch block
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "���ӷ�����ʧ�ܣ�����������Ϣ","��ʾ", JOptionPane.INFORMATION_MESSAGE);
						// TODO Auto-generated catch block
					}
				}
			}
			if(e.getSource()==bu2)dispose();;
		}
		}
	public void fileout() throws IOException{
		String path="./���ݿ�";
		String filename="config.txt";
		File headPath = new File(path);
		File file=new File(path+"/"+filename);
        if(!headPath.exists())headPath.mkdirs();//�ж��ļ��Ƿ񴴽���û�д����򴴽����ļ���
        if(!file.exists())file.createNewFile();
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(key.encrypt(severname.getText()));
		bw.newLine();
		bw.write(key.encrypt(database.getText()));
		bw.newLine();
		bw.write(key.encrypt(username.getText()));
		bw.newLine();
		bw.write(key.encrypt(password.getText()));
		bw.newLine();
		bw.flush();
		bw.close();
		fw.close();
	}
	public static void setdata(String severname,String database,String usernam,String password){
		set_database.severname.setText(key.deciphering(severname));
		set_database.database.setText(key.deciphering(database));
		set_database.username.setText(key.deciphering(usernam));
		set_database.password.setText(key.deciphering(password));
	}
    public static void main(String[] args) {
        set_database a = new set_database();
    }
}