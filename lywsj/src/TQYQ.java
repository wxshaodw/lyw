import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TQYQ extends JPanel{

	JButton btn;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	public TQYQ() {
		setLayout(null);
		btn = new JButton("��ʦ��Ϣ¼��");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btn.setFont(new Font("������κ", Font.PLAIN, 18));
		btn.setBounds(36, 105, 163, 27);
		this.add(btn);
		btn1 = new JButton("������Ŀ¼��");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btn1.setFont(new Font("������κ", Font.PLAIN, 18));
		btn1.setBounds(297, 105, 163, 27);
		this.add(btn1);
		btn2 = new JButton("�������ĵǼ�");
		btn2.setBounds(566, 105, 163, 27);
		btn2.setFont(new Font("������κ", Font.PLAIN, 18));
		this.add(btn2);
		btn3 = new JButton("ѧ����������");
		btn3.setBounds(813, 105, 163, 27);
		btn3.setFont(new Font("������κ", Font.PLAIN, 18));
		this.add(btn3);
		  JLabel label_1 = new JLabel("��ʦ������Ϣ����ϵͳ");
		    label_1.setForeground(Color.ORANGE);
		    label_1.setFont(new Font("��������", Font.PLAIN, 50));
		    label_1.setBounds(36, 10, 513, 49);
		    this.add(label_1);
	}
	}
	