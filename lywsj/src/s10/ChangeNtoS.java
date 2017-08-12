package s10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class ChangeNtoS extends JFrame{
	JLabel Str=new JLabel();
	JTextField mun=new JTextField(null,15);
	JPanel cen=new JPanel();
	public ChangeNtoS(String name){
		super(name);
		addTool();
	setSize(400, 100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);
	}
	public void addTool(){
		Container c=getContentPane();
		mun.addActionListener(new Enter());
		cen.add(mun);
		cen.add(Str);
		c.add(cen);
		centerWindow();
	}
	public class Enter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String n[]={"0","1","2","3","4","5","6","7","8","9"};
			String Str_1[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
			if(Str.getText().compareTo("9")>0)Str.setText("你输入的数据超出范围");
			if(isNumeric(Str.getText()))Str.setText("输入出错！");
			for(int i=0;i<10;i++){if(mun.getText().equals(n[i]))Str.setText(Str_1[i]);}
			// TODO Auto-generated method stub
			}
		}
	public static boolean isNumeric(String str){  
		  for (int i = str.length();--i>=0;){    
		   if (!Character.isDigit(str.charAt(i))){  
		    return false;  
		   }  
		  }  
		  return true;  
		}  
	public void centerWindow(){
		Toolkit tk= getToolkit();
		Dimension dm=tk.getScreenSize();
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
	}
	public static void main(String[] args) {
		ChangeNtoS text=new ChangeNtoS("数字转换");
		// TODO Auto-generated method stub

	}

}
