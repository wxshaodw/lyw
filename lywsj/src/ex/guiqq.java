package SwingTest;

import java.awt.*; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import javax.swing.*;  
public class GUIQQ extends JFrame implements MouseListener{ 
 //���������ǩ
	JLabel jlb; 
 //�в�����  
	JPanel jp;  
	JComboBox cmbzt;//��Ͽ� ����״̬�õ� 
	JLabel jp_jlbtx,jp_jlbzczh,jp_jlbzhmm; //��ǩ"ע���˺�""�һ�����" 
	JTextField jp_jtusr; // QQ����/�ֻ�/����  
	JPasswordField jp_pw;  //����  
	JCheckBox jp_jcbjzmm,jp_jcbzddl;//��ѡ�� ����"��ס����""�Զ���¼"
	Font f1=new Font("����", Font.PLAIN, 14); //��������  
	JButton jp_jbdzh,jp_jbsz,jp_jbdl;//��ť ���õ�½��
	
	public GUIQQ() {   
		jlb=new JLabel(new ImageIcon("../img/cyqq.jpg")); //�϶˵ĳ���ѧԺͼƬ       
		jp=new JPanel();   
		jp.setLayout(null);
		//��ʾQQͷ��
		jp_jlbtx=new JLabel(new ImageIcon("img/qq.jpg"));   
		jp_jlbtx.setBounds(18, 10, 85, 85); //���ñ�ǩλ�� ǰ����Ҫ�ղ���
		//�˺������ı���
		jp_jtusr=new JTextField("QQ����/�ֻ�/����"); 
		jp_jtusr.setForeground(Color.DARK_GRAY);//������ɫ   
		jp_jtusr.addMouseListener(this); 
		jp_jtusr.setBounds(118, 11, 170, 25);  
		//���������ı���
		jp_pw=new JPasswordField("",24);
		jp_pw.setForeground(Color.DARK_GRAY);   
		jp_pw.addMouseListener(this); 
		jp_pw.setBounds(118, 45, 170, 24); 
		//��ע���˺š��ı������˺�����������ʾ
		jp_jlbzczh=new JLabel("ע���˺�");   
		jp_jlbzczh.setFont(f1); 
		jp_jlbzczh.setForeground(Color.BLUE);   
		jp_jlbzczh.setBounds(300, 10, 70, 25);  
		//���һ����롱�ı�������������������ʾ
		jp_jlbzhmm=new JLabel("�һ�����"); 
		jp_jlbzhmm.setFont(f1);//����"�һ�����"���� 
		jp_jlbzhmm.setForeground(Color.BLUE); //����"�һ�����"������ɫ
		jp_jlbzhmm.setBounds(300, 43, 70, 25);  
		//��¼״̬��Ͽ�
		String[] s={"����","����","æµ","����"}; //����״̬ 
		cmbzt=new JComboBox(s);   
		cmbzt.setFont(f1); 
		cmbzt.setBounds(300, 78, 60, 21);  
		//"��ס����"��ѡ��
		 jp_jcbjzmm=new JCheckBox("��ס����");   
		 jp_jcbjzmm.setFont(f1); 
		 jp_jcbjzmm.setBounds(114, 78, 90, 20); 
		 //"�Զ���¼"��ѡ��
		 jp_jcbzddl=new JCheckBox("�Զ���¼");   
		 jp_jcbzddl.setFont(f1); 
		 jp_jcbzddl.setBounds(206, 78, 90, 20);
		 //"���˺�"��ť
		 jp_jbdzh=new JButton("���˺�");      
		 jp_jbdzh.setFont(f1);      
		 jp_jbdzh.setBounds(10, 120, 76, 21);
		//"����"��ť
		 jp_jbsz=new JButton("����");   
		 jp_jbsz.setFont(f1); 
		 jp_jbsz.setBounds(95, 120, 65, 21);  
		//"��¼"��ť
		 jp_jbdl=new JButton("��¼");   
		 jp_jbdl.setFont(f1); 
		 jp_jbdl.setBounds(297, 120, 65, 21); 
		 //��Ӹ������ 
		 jp.add(jp_jlbtx);//ͷ��   
		 jp.add(jp_jtusr); //�˺��ı���
		 jp.add(jp_jlbzhmm); //�һ������ǩ  
		 jp.add(jp_pw); //�����
		 jp.add(jp_jlbzczh);//ע���˺ű�ǩ
		 jp.add(cmbzt); //��¼״̬��Ͽ�
		 jp.add(jp_jcbjzmm); //��ס���븴ѡ��
		 jp.add(jp_jcbzddl); //�Զ���¼��ѡ��
		 jp.add(jp_jbdzh); //���ʺŰ�ť
		 jp.add(jp_jbsz);  //���ð�ť
		 jp.add(jp_jbdl);//��¼��ť
		 
		 this.add(jlb,"North");//��ǩ�ŵ���� 
		 this.add(jp,BorderLayout.CENTER);// �ŵ��в�    
		 
		 this.setIconImage(new ImageIcon("img/qq.jpg").getImage());//���ô����ϵ�qqСͼƬ  
		 this.setResizable(false);//������Ŵ󣬸ı䴰�ڴ�С��   
		 this.setSize(380,275); 
		 this.setLocation(500,200); 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		 this.setVisible(true);    
	} 
	public void mouseClicked(MouseEvent e) {  
		if(e.getSource()==jp_jtusr)   { 
			jp_jtusr.setText(""); 
			jp_jtusr.setForeground(Color.BLACK);   
		} 
		else if(e.getSource()==jp_pw) {
			jp_pw.setText(""); 
			jp_pw.setForeground(Color.BLACK);
			jp_pw.setEchoChar('��');   
		}
	}
	public static void main(String[] args) {   
		GUIQQ acl=new GUIQQ(); 
		acl.setTitle("2016δ��QQ");
		}   
 public void mousePressed(MouseEvent e) { }      
 public void mouseReleased(MouseEvent e) {}      
 public void mouseEntered(MouseEvent e) {}
 public void mouseExited(MouseEvent e) { }  
}
