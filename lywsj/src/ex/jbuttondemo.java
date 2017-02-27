package SwingTest;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class JButtonDemo extends JFrame {
     private JPanel contentPane;
    public static void main(String[] args) {
    	JButtonDemo frame = new JButtonDemo();
    	frame.setVisible(true);
    }
    public JButtonDemo() {
        setTitle("��ťʹ��");// ���ô���ı���
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô����˳�ʱ����
        setBounds(100, 100, 250, 100);// ���ô���λ�úʹ�С
        contentPane = new JPanel();// �����������
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������ı߿�
        setContentPane(contentPane);// Ӧ���������
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));// �����������Ϊ��ʽ����
        
        JButton modifyButton = new JButton("�޸�");// ������ť
        modifyButton.setIcon(new ImageIcon("img/modify.jpg"));// Ϊ��ť����ͼ��
        contentPane.add(modifyButton);// ����������Ӱ�ť
        
        JButton deleteButton = new JButton("ɾ��");// ������ť
        deleteButton.setIcon(new ImageIcon("img/delete.jpg"));// Ϊ��ť����ͼ��
        contentPane.add(deleteButton);// ����������Ӱ�ť
    }
}