package s12;
import java.io.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
class windows extends JFrame{
	JPanel bot =new JPanel();
	JPanel nor_1 =new JPanel();
	JPanel nor_2 =new JPanel();
	JPanel nor =new JPanel();
	JLabel t_1=new JLabel("源文件");
	JLabel t_2=new JLabel("目标文件");
	JTextArea nrw = new  JTextArea(10,10);
	JScrollPane nr =new JScrollPane(nrw);
	JTextField y=new JTextField(25);
	JTextField tag=new JTextField(25);
	JButton copy=new JButton("复制");
	JButton cheak=new JButton("浏览");
	FileDialog cheak_1=new FileDialog(this);
	public windows (String name){
		super(name);
		setSize(426,400);
		addtool();
		centerWindow();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void addtool(){
		Container c=getContentPane();
		bot.setLayout(new BorderLayout());
		nor.setLayout(new BorderLayout());
		copy.addActionListener(new copy());
		cheak.addActionListener(new cheak());
		nor_1.add(t_1);
		nor_1.add(y);
		nor_1.add(cheak);
		nor_2.add(t_2);
		nor_2.add(tag);
		nor_2.add(copy);
		nor.add("North",nor_1);
		nor.add("South",nor_2);
		bot.add("North",nor);
		bot.add("Center",nr);
		c.add(bot);
	}
	public void centerWindow(){
		Toolkit tk= getToolkit();
		Dimension dm=tk.getScreenSize();
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
	} 
	class cheak implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cheak_1.show();
			if(cheak_1.getDirectory()!=null)y.setText(cheak_1.getDirectory()+cheak_1.getFile());
			// TODO Auto-generated method stub
			
		}
		
	}
	class copy implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				FileInputStream rf=new FileInputStream(y.getText());
				FileOutputStream wf=new FileOutputStream(tag.getText());
				String strline;
				byte b[]=new byte[1024];
				int count=-1;
				nrw.setText(nrw.getText()+"read form the file:"+y.getText());
				nrw.setText(nrw.getText()+"\n"+"write to file:"+tag.getText());
				while ((count=rf.read(b,0,1024))!=-1){
					wf.write(b, 0, count);
					nrw.setText(nrw.getText()+"\n"+"Read 1024B writh 1024B");
				}
				rf.close();
				wf.close();
			}
			catch(IOException c){
				JOptionPane.showMessageDialog(null, "文件打开有误");
			}
			// TODO Auto-generated method stub
			
		}
		
	}
}
public class t_copy {

	public static void main(String[] args) {
		windows a=new windows("复制文件");
		a.setVisible(true);
		// TODO Auto-generated method stub

	}

}
