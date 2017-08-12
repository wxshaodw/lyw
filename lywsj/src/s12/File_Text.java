package s12;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class FgMenu extends JMenu{
	public FgMenu(String name,int a){
		super(name);
		setMnemonic(a);
	}
}
public class File_Text extends JFrame{
	JMenuBar mb =new JMenuBar();
	FgMenu a=new FgMenu("文件（F）",KeyEvent.VK_F);
	JMenuItem new_1=new JMenuItem("新建(N)");
	JMenuItem open=new JMenuItem("打开(O)");
	JMenuItem save =new JMenuItem("保存");
	JMenuItem save_as=new JMenuItem("另存为");
	JMenuItem close=new JMenuItem("关闭");
	JMenuItem quit=new JMenuItem("退出");
	JTextArea n=new JTextArea();
	JScrollPane bot= new JScrollPane(n);
	FileDialog w_1=new FileDialog(this,"保存", FileDialog.SAVE);
	FileDialog w_2=new FileDialog(this,"打开", FileDialog.LOAD);
	FileDialog w_3=new FileDialog(this,"另存为", FileDialog.SAVE);
	String save_r="1";
	public void addmenu(){
		Container c=getContentPane();
		new_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		new_1.addActionListener(new lister());
		open.addActionListener(new lister());
		save.addActionListener(new lister());
		save_as.addActionListener(new lister());
		quit.addActionListener(new lister());
		a.add(new_1);
		a.add(open);
		a.addSeparator();
		a.add(close);
		a.addSeparator();
		a.add(save);
		a.add(save_as);
		a.addSeparator();
		a.add(quit);
		mb.add(a);
		setJMenuBar(mb);
		c.add(bot);
		setSize(500,400);
	}
	public File_Text (String name){
		super(name);
		addmenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
class lister implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a;
		a=e.getSource();
		try{
			if(a==new_1){
				File_Text f=new File_Text("225梁烨文");
				f.setVisible(true);
			}
			if(a==open){
				w_2.show();
				FileReader fr=new FileReader(w_2.getDirectory()+w_2.getFile());
				BufferedReader br=new BufferedReader(fr);
				String strline;
				while(br.ready()){
					strline=br.readLine();
					n.setText(n.getText()+strline+"\n");
				}
				br.close();
			}
			if(a==save){
				if(save_r.equals("1"))w_1.show();
				save_r=w_1.getDirectory()+w_1.getFile();
				FileWriter fw=new FileWriter(w_1.getDirectory()+w_1.getFile());
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write(n.getText());
				bw.flush();
				fw.close();
				bw.close();
			}
			if(a==save_as){
				w_3.show();
				FileReader fr=new FileReader(w_1.getDirectory()+w_1.getFile());
				BufferedReader br=new BufferedReader(fr);
				FileWriter fw=new FileWriter(w_3.getDirectory()+w_3.getFile());
				BufferedWriter bw =new BufferedWriter(fw);
				String strline;
				while (br.ready()){
					strline=br.readLine();
					bw.write(strline);
					bw.newLine();
				}
				bw.flush();
				bw.close();
				br.close();
				fw.close();
				fr.close();
			}
			if(a==quit)System.exit(0);
			}
		catch(IOException e1){
			e1.printStackTrace();
		}// TODO Auto-generated method stub
		
	}
	
}
	public static void main(String[] args) {
		File_Text f=new File_Text("225梁烨文");
		f.setVisible(true);
		// TODO Auto-generated method stub

	}

}
