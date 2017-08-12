package ks;
import java.awt.*;
import javax.swing.*;

public class textcheak extends JFrame{
	JTextField a1=new JTextField(10);
	JTextField a2=new JTextField(10);
	JLabel cr=new JLabel("不同行的数量：");
	JTextArea str1=new JTextArea();
	JTextArea str2=new JTextArea();
	JScrollPane s1=new JScrollPane(str1);
	JScrollPane s2=new JScrollPane(str2);
	JButton ac1=new JButton("浏览");
	JButton ac2=new JButton("浏览");
	FileDialog acs1=new FileDialog(this,"文件1");
	FileDialog acs2=new FileDialog(this,"文件2");
	JPanel nl=new JPanel();
	JPanel nr=new JPanel();
	JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,nl,s1);
	JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,nr,s2);
	JSplitPane sp3=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp1,sp2);
	void addtool(){
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		sp1.setSize((int) (this.getWidth()*0.2),this.getHeight());
		sp2.setSize((int) (this.getWidth()*0.2),this.getHeight());
		nl.add(a1);
		nl.add(ac1);
		nr.add(a2);
		nr.add(ac2);
		c.add("East",cr);
		c.add("Center",sp3);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public textcheak (String name){
		super(name);
		setSize(700,500);
		addtool();
	}
	
	public static void main(String[] args) {
		textcheak c1=new textcheak("T1");
		// TODO Auto-generated method stub

	}

}
