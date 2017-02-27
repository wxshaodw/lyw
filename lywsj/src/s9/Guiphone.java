package s9;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Guiphone extends JFrame{

	public Guiphone(String name){
		super(name);
		addJPane();
		setSize(220,300);
		centerWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void centerWindow(){
		Toolkit tk= getToolkit();
		Dimension dm=tk.getScreenSize();
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
	}
	public void addJPane(){
		FgButton [] btn = {new FgButton("1"),
				new FgButton("2"),
				new FgButton("3"),
				new FgButton("4"),
				new FgButton("5"),
				new FgButton("6"),
				new FgButton("7"),
				new FgButton("8"),
				new FgButton("9"),
				new FgButton("*"),
				new FgButton("0"),
				new FgButton("#")
		};
		FgButton add = new FgButton(new ImageIcon(getClass().getResource("add.png")));
		FgButton call = new FgButton(new ImageIcon(getClass().getResource("call.png")));
		FgButton delete = new FgButton(new ImageIcon(getClass().getResource("delete.jpg")));
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		JPanel d=new  JPanel();
		d.setLayout(new BorderLayout());
		JTextField number=new JTextField(20);
		JPanel p=new  JPanel();
		JPanel s=new  JPanel();
		JLabel loc_1 =new JLabel(new ImageIcon(getClass().getResource("top.png")));
		FgButton mr = new FgButton(new ImageIcon(getClass().getResource("mr.jpg")));
		FgButton ed = new FgButton(new ImageIcon(getClass().getResource("ed.jpg")));
		FgButton save = new FgButton(new ImageIcon(getClass().getResource("save.jpg")));
		FgButton kb = new FgButton(new ImageIcon(getClass().getResource("kb.jpg")));
		FgButton sy = new FgButton(new ImageIcon(getClass().getResource("sy.jpg")));
		s.setLayout(new GridLayout(1,5));
		p.setLayout(new GridLayout(5,3));
		d.add("North",number);
		d.add("Center",p);
		loc_1.getWidth();
		for(int i=0;i<12;i++){
			p.add(btn[i]);
		 }
		s.add(mr);
		s.add(ed);
		s.add(save);
		s.add(kb);
		s.add(sy);
		p.add(add);
		p.add(call);
		p.add(delete);
		c.add("North", loc_1);
		c.add("Center",d);
		c.add("South",s);
		setResizable(false);
	}
	public static void main(String[] args) {
		Guiphone phone=new Guiphone("225ÁºìÇÎÄ");	
		phone.setVisible(true);
		// TODO Auto-generated method stub

	}

}