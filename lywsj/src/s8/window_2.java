package s8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class window_2 extends JFrame{
	JPanel a=new JPanel();
	JPanel b=new JPanel();
	JPanel d=new JPanel();
	JLabel l_1=new JLabel("1");
	JLabel l_2=new JLabel("1");
	JLabel l_3=new JLabel("1");
	JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,a,b);
	JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,d);
	public window_2(){
		Container c=getContentPane();
		a.add(l_1);
		b.add(l_2);
		d.add(l_3);
		a.setBackground(Color.red);
		b.setBackground(Color.blue);
		d.setBackground(Color.GREEN);
		sp2.setDividerLocation(1);
		c.add(sp2);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		window_2 w1=new window_2 ();
		// TODO Auto-generated method stub

	}

}
