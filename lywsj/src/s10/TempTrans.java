package s10;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

public class TempTrans extends JFrame {
	JButton change=new JButton("转换");
	JTextField F=new JTextField(7);
	JTextField C=new JTextField(7);
	JLabel F_label=new JLabel("华氏温度");
	JLabel C_label=new JLabel("摄氏温度");
	JPanel cen=new JPanel();
	public TempTrans(String name){
		super(name);
		addTool();
		setSize(380,200);
		centerWindow();
		setResizable(false);
	}
	public void  addTool(){
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		C.setEditable(false);
		change.addActionListener(new change_F());
		cen.add(F_label);
		cen.add(F);
		cen.add(C_label);
		cen.add(C);
		cen.add(change);
		c.add(cen);
	}
	public void centerWindow(){
		Toolkit tk= getToolkit();
		Dimension dm=tk.getScreenSize();
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
	}
	class change_F implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			double data,out;
			java.text.DecimalFormat df = new java.text.DecimalFormat("###.##"); 
			data=Double.parseDouble(F.getText());	
			out=(data-32)*5/9;
			df.format(out);
			C.setText(""+df.format(out));
		}}
	public static void main(String[] args) {
		 TempTrans t=new TempTrans("225梁烨文");
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setVisible(true);// TODO Auto-generated method stub

	}

}
