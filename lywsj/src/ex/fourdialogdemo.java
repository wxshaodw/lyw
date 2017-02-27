package SwingTest;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class  FourDialogDemo extends JFrame implements ActionListener{
	JButton btnMessage=new JButton("消息");
	JButton btnInput=new JButton("输入");
	JButton btnConfirm=new JButton("确认");
	JButton btnOption=new JButton("选择");
	public FourDialogDemo(){
		super("四种对话框的演示");
		btnMessage.addActionListener(this);
		btnInput.addActionListener(this);
		btnConfirm.addActionListener(this);
		btnOption.addActionListener(this);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(btnMessage);
		getContentPane().add(btnInput);
		getContentPane().add(btnConfirm);
		getContentPane().add(btnOption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		FourDialogDemo fr=new FourDialogDemo();
		fr.setSize(400, 300);
		fr.setLocation(200, 200);
		//fr.pack();
		fr.setVisible(true);
	}
 
 public void actionPerformed(ActionEvent e) {
	 Object[] opt={"确认","取消"};
	 JButton instance=(JButton)e.getSource();
	 if(instance==btnMessage)
		 JOptionPane.showMessageDialog(this,"消息对话框");
	 else if(instance==btnInput)
		 JOptionPane.showInputDialog(this,"输入对话框");
	 else if(instance==btnConfirm)
		 JOptionPane.showConfirmDialog(this,"确认对话框");
	 else
		 JOptionPane.showOptionDialog(this,"选择对话框","选择",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opt,opt[1]);
  }
}
