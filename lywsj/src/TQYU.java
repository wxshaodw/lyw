import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TQYU extends JPanel{

	JButton btn4;
	JButton btn7;
	JButton btn8;
	JButton btn9;
	Container c;

public TQYU() {
setLayout(null);

JLabel label_4 = new JLabel("��Ϣ��ʾ��");
label_4.setForeground(Color.ORANGE);
label_4.setFont(new Font("��������", Font.PLAIN, 26));
label_4.setBounds(10, 53, 135, 34);
this.add(label_4);
btn4 = new JButton("�����");
btn4.setBounds(36, 361, 163, 27);
btn4.setFont(new Font("������κ", Font.PLAIN, 18));
btn4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	}
});
this.add(btn4);
btn7 = new JButton("��ʦ��Ϣ");
btn7.setBounds(36, 140, 163, 27);
btn7.setFont(new Font("������κ", Font.PLAIN, 18));
btn7.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	}
});
this.add(btn7);

btn8 = new JButton("��������");
btn8.setBounds(36, 213, 163, 27);
btn8.setFont(new Font("������κ", Font.PLAIN, 18));
btn8.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
	}
});
this.add(btn8);

btn9 = new JButton("������Ŀ");
btn9.setBounds(36, 286, 163, 27);
btn9.setFont(new Font("������κ", Font.PLAIN, 18));
btn9.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	}
});
this.add(btn9);
}
}
