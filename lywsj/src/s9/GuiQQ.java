package s9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
public class GuiQQ extends JFrame{
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
		JPanel s=new JPanel();
		JPanel s1=new JPanel();
		JPanel s2=new JPanel();
		JPanel cen=new JPanel();
		JPanel e=new JPanel();
		JTextField id=new  JTextField("QQ号码/手机号/邮箱",15);
		JPasswordField passkey=new  JPasswordField(15);
		JLabel loc_1 =new JLabel(new ImageIcon(getClass().getResource("qqt.jpg")));
		JLabel loc =new JLabel(new ImageIcon(getClass().getResource("qq.jpg")));
		JLabel in =new JLabel("注册账号");
		JLabel forget =new JLabel("忘记密码");
		FgButton many=new FgButton("多账户");
		FgButton login=new FgButton("登录");
		FgButton set =new FgButton("设置");
		String Str[]={"在线","忙碌","离开","隐身"};
		JComboBox tie =new JComboBox(Str);
		JRadioButton zid=new JRadioButton("自动登录");
		JRadioButton re =new JRadioButton("记住密码");
		e.setLayout(new FlowLayout(FlowLayout.CENTER));       
		cen.setLayout(new FlowLayout(FlowLayout.LEFT));
		s.setLayout(new BorderLayout());
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
public static void main(String[] args) {
	GuiQQ qq=new GuiQQ("QQ");	
	qq.setVisible(true);
	// TODO Auto-generated method stub

}
}
