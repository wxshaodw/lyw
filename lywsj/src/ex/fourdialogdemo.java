package SwingTest;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class  FourDialogDemo extends JFrame implements ActionListener{
	JButton btnMessage=new JButton("��Ϣ");
	JButton btnInput=new JButton("����");
	JButton btnConfirm=new JButton("ȷ��");
	JButton btnOption=new JButton("ѡ��");
	public FourDialogDemo(){
		super("���ֶԻ������ʾ");
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
	 Object[] opt={"ȷ��","ȡ��"};
	 JButton instance=(JButton)e.getSource();
	 if(instance==btnMessage)
		 JOptionPane.showMessageDialog(this,"��Ϣ�Ի���");
	 else if(instance==btnInput)
		 JOptionPane.showInputDialog(this,"����Ի���");
	 else if(instance==btnConfirm)
		 JOptionPane.showConfirmDialog(this,"ȷ�϶Ի���");
	 else
		 JOptionPane.showOptionDialog(this,"ѡ��Ի���","ѡ��",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opt,opt[1]);
  }
}
