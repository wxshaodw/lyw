package ex_t;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ex_2 extends JFrame{
	JPanel s= new JPanel();
	JTextArea n=new JTextArea();
	JScrollPane nr = new JScrollPane(n);
	JButton copy =new JButton("¸´ÖÆ");
	JTextField f=new JTextField(10);
	public ex_2(String name){
		super(name);
		addtool();
		setSize(500, 400);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void addtool (){
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		copy.addActionListener(new lister());
		s.setSize(300, 400);
		s.add(copy);
		s.add(f);
		c.add("Center",nr);
		c.add("North",s);
	}
	class lister implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			f.setText(n.getText());	// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[]args){
		ex_2 a=new ex_2("text");
		a.setVisible(true);
		}
}
