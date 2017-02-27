package s11;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.event.*;

class FgButton extends JButton{
	public FgButton(){
		super();
	}
	public FgButton(Icon icon){
		super(icon);
	}
	public FgButton(Icon icon,String strToolTipText){
		super(icon);
		setToolTipText(strToolTipText);
	}
	public FgButton(String text){
		super(text);
	}
	public FgButton(String text,Icon icon,String strToolTipText){
		super(text,icon);
		setToolTipText(strToolTipText);
	}
}
class FgText extends JTextField{
	public boolean lim;
	FgText(String Text,int i,final boolean lim){
		super(Text,i);
		this.lim=lim;
		addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(lim){
					char c=e.getKeyChar();
					if(c<'0'|c>'9')e.consume();
				}
			}
			});
			}
	}
public class GuiQQ extends JFrame{
	JPanel s=new JPanel();
	JPanel s1=new JPanel();
	JPanel s2=new JPanel();
	JPanel cen=new JPanel();
	JPanel e=new JPanel();
	FgText id=new  FgText("QQ号码/手机号/邮箱",15,true);
	JPasswordField passkey=new  JPasswordField(15);
	JLabel loc_1 =new JLabel();
	JLabel loc =new JLabel();
	JLabel in =new JLabel("注册账号");
	JLabel forget =new JLabel("忘记密码");
	FgButton many=new FgButton("多账户");
	FgButton login=new FgButton("登录");
	FgButton set =new FgButton("设置");
	String Str[]={"在线","忙碌","离开","隐身"};
	JComboBox tie =new JComboBox(Str);
	JRadioButton zid=new JRadioButton("自动登录");
	JRadioButton re =new JRadioButton("记住密码");
	Date now =new Date();
	SimpleDateFormat matter1=new SimpleDateFormat("dd");
	static JPanel mtb=new JPanel();
	public GuiQQ(String Name){
		super(Name);
		add(mtb);
		addJPanel();
		setSize(380,250);
		centerWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void addJPanel(){
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		e.setLayout(new FlowLayout(FlowLayout.CENTER));       
		cen.setLayout(new FlowLayout(FlowLayout.LEFT));
		s.setLayout(new BorderLayout());
		login.addActionListener(new login());
		passkey.addActionListener(new login());
		loc_1.setIcon(new ImageIcon(getClass().getResource("..\\qqt.jpg")));
		e.add(loc);
		c.add("North",loc_1);	
		c.add("West",e);
		cen.add(id);
		cen.add(in);
		cen.add(passkey);
		cen.add(forget);
		cen.add(zid);
		cen.add(re);
		cen.add(tie);
		s1.add(many);
		s1.add(set);
		s2.add(login);
		s.add("West",s1);
		s.add("East",s2);
		c.add("South",s);
		c.add("Center",cen);
		setResizable(false);
	}
public void centerWindow(){
			Toolkit tk= getToolkit();
			Dimension dm=tk.getScreenSize();
			setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
		}
class login implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(id.getText().equals("1144379170")&&passkey.getText().equals("123456")){
			JLabel im =new JLabel(id.getText()+"您好！欢迎你！");
			im.setFont(new java.awt.Font("Dialog", 1, 13));
			JOptionPane.showConfirmDialog(null,im );
		}
		else{
			JLabel im =new JLabel("你输入的帐号密码有误请重新输入");
			im.setFont(new java.awt.Font("Dialog", 1, 13));
			JOptionPane.showConfirmDialog(null,im );
		}// TODO Auto-generated method stub
		
	}
}
public static void main(String[] args) {
	GuiQQ qq=new GuiQQ("QQ");	
	qq.setVisible(true);
	// TODO Auto-generated method stub

}
}
