package s10;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;
public class login extends JFrame {
	String str[]={"ѧ���û�","��ʦ�û�"};
	Button exit=new Button("�˳�");
	Button q=new Button("ȷ��");
	Button cancle=new Button("ȡ��");
	JTextField Id=new JTextField(12);
	JPasswordField Key=new JPasswordField(12);
	JComboBox Typ=new JComboBox(str);
	JLabel Typ_Label=new JLabel("�û�����          ");
	JLabel Id_Label=new JLabel("�û�");
	JLabel Key_Label=new JLabel("����");
	JPanel cen=new JPanel();
	JPanel sou=new JPanel();
	public login(String Name){
		super(Name);
		Bulit_window();
		setSize(200,160);
		centerWindow();
	}
	public void Bulit_window(){
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		q.addActionListener(new Enter());
		cancle.addActionListener(new ReWrite());
		exit.addActionListener(new exit());
		Typ.setSelectedItem(str[0]);
		Key.addActionListener(new Enter());
		cen.add(Typ_Label);
		cen.add(Typ);
		cen.add(Id_Label);
		cen.add(Id);
		cen.add(Key_Label);
		cen.add(Key);
		sou.add(q);
		sou.add(cancle);
		sou.add(exit);
		c.add("Center",cen);
		c.add("South",sou);
		setResizable(false);
	}
	public void centerWindow(){
		Toolkit tk= getToolkit();
		Dimension dm=tk.getScreenSize();
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
	}
	class Enter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(Id.getText().equals(""))JOptionPane.showMessageDialog(null, "�û�������Ϊ��!");
			else if(Key.getText().equals(""))JOptionPane.showMessageDialog(null, "���벻��Ϊ��!");
			else if(Id.getText().equals("t")&&Key.getText().equals("t")&&Typ.getSelectedItem()==str[1])JOptionPane.showMessageDialog(null, "��ʦ�û���½�ɹ�");
			else if(Id.getText().equals("s")&&Key.getText().equals("s")&&Typ.getSelectedItem()==str[0])JOptionPane.showMessageDialog(null, "ѧ���û���½�ɹ�");
			else JOptionPane.showMessageDialog(null, "�û��������ڻ������벻��ȷ!");
		}
		}
	 class ReWrite implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 Id.setText("");
			 Key.setText("");
			 Id.requestFocus();
		}
		}
	 class exit implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 System.exit(0);}
		}
	public static void main(String[] args) {
		login window=new login("225������");
		window.setDefaultCloseOperation(0);
		window.setVisible(true);// TODO Auto-generated method stub
	}
}
