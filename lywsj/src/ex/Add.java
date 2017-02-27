package ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Add extends JFrame {
	public Add() {
		setSize(500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		init();
		setVisible(true);
	}
	protected void init() {
		setTitle("�����������");
		JPanel p = new JPanel();
		add(p);
		JTextField num1 = new JTextField(10);
		p.add(num1);
		
		p.add(new JLabel("+"));
		
		JTextField num2 = new JTextField(10);
		p.add(num2);
	
		p.add(new JLabel("="));
		
		JTextField result = new JTextField(10);
		result.setEditable(false);
		p.add(result);
		
		num2.addActionListener(new CalcListener(num1, num2, result));//������ڶ������ݺ��ûس����Ϳ��Լ���
		
		JButton calc = new JButton("����");
		calc.addActionListener(new CalcListener(num1, num2, result));
		p.add(calc);
	}

	class CalcListener implements ActionListener {
		private JTextField num1, num2, result;
		CalcListener(JTextField num1, JTextField num2, JTextField result) {
			this.num1 = num1;
			this.num2 = num2;
			this.result = result;
		}
		
		public void actionPerformed(ActionEvent e) {
			try {
				double n = Double.parseDouble(num1.getText()) + Double.parseDouble(num2.getText());
				result.setText(String.valueOf(n));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "��������: " + ex.getMessage(), "������ʾ", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public static void main(String[] args) {
		new Add();
	}
}

