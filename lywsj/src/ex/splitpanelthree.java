package SwingTest;
import java.awt.*;

import javax.swing.*;
public class SplitPanelThree extends JFrame{
	public static void main(String args[]){ 
		JFrame fr=new JFrame("JFrame with JSplitPane");
		Container c = fr.getContentPane();
		JPanel LeftPanel = new JPanel(); 
		LeftPanel.setSize(200,200);
		LeftPanel.setBackground(Color.BLUE);
		LeftPanel.add(new JLabel("label1"));
		JPanel Rightpanel = new JPanel(); 
		Rightpanel.setSize(200,100);
		Rightpanel.add(new JLabel("label2")); 
		JPanel RightDownPanel = new JPanel(); 
		RightDownPanel.setSize(100,100);
		RightDownPanel.add(new JLabel("label3"));
		RightDownPanel.setBackground(Color.red);
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,LeftPanel,Rightpanel);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,RightDownPanel);
		c.add(sp2);
		fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fr.setSize(600, 400);
		fr.setVisible(true);
	}
}
