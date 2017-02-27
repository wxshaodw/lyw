package ex;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
public class Login extends JFrame{
	JTextField f1;
    JTextField f2;
    JButton b1;
    JButton b2;
    String power;//表示权限
    String imgePath = "img/login.jpg";
    JPanel p5;
    Image img = Toolkit.getDefaultToolkit().createImage(imgePath);
 Login(){
	 Container cp=getContentPane();
	 Label l1=new Label("用户名：");
	 Label l2=new Label("密   码：");
	 JPanel p1=new JPanel();
	 JPanel p2=new JPanel();
	 JPanel p3=new JPanel();
	 JPanel p4=new JPanel();
     p5=new JPanel(){
           protected  void paintChildren(Graphics g) {
                g.drawImage(img,0,0,this);
                super.paintChildren(g);
            }
        };
        f1=new JTextField(15);
        f2=new JPasswordField(15);
        f2.addActionListener(new Enter());
        b1=new JButton("登录");
        b2=new JButton("重置");
        p1.setBackground(Color.orange);
        p2.add(l1);
        p2.add(f1);
        p2.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
        p2.setBackground(Color.ORANGE);
        p3.add(l2);
        p3.add(f2);
        p3.setBackground(Color.ORANGE);
        p3.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
        p4.add(b1);
        p4.add(b2);
        p4.setBorder(new MatteBorder(-3,-3,-3,-3,Color.CYAN));
        p4.setBackground(Color.ORANGE);
        p5.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        p5.add(p2);
        p5.add(p3);
        p5.add(p4);
        cp.add(p5,BorderLayout.CENTER);
        b1.addActionListener(new Enter());
        b2.addActionListener(new ReWrite());
        addWindowListener(new winClose());
        centerWindow();
    }
//窗口居中，很有参考价值
	public void centerWindow(){
		//获得显示屏桌面窗口的大小
		Toolkit tk=getToolkit();
		Dimension dm=tk.getScreenSize();
		//让窗口居中显示
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
		//setAlwaysOnTop(true);//使窗口永远在最前面
	}
 public static void main(String[] args) {
	 Login log=new Login();
	 log.setTitle("系统登录");
	 log.setSize(360,250);
	 log.setVisible(true);
}
 class Enter implements ActionListener{
	 public void actionPerformed(ActionEvent e){  
		 if((f1.getText()).equals("admin")&&(f2.getText()).equals("123")){
			 JOptionPane.showMessageDialog(null, f1.getText()+"，欢迎您！您的用户权限是adimistrator。");
			 power="adminstrator";
		}
		 else if((f1.getText()).equals("pyc")&&(f2.getText()).equals("123456")){
			JOptionPane.showMessageDialog(null, f1.getText()+"，欢迎您！您的用户权限是普通用户。");
			power="adminstrator";
		}
		else JOptionPane.showMessageDialog(null, "登录失败，请重新登录！");
  }
 }
 class ReWrite implements ActionListener{
	 public void actionPerformed(ActionEvent e) {
		 f1.setText("");
		 f2.setText("");
		 f1.requestFocus();
	}
 }
 class winClose extends WindowAdapter {
	 public void windowClosing(WindowEvent e) {
		 (e.getWindow()).dispose();
		 System.exit(0);
	}
 }
}