package ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Allcomboboxdemo extends JFrame implements ActionListener {
 String s[] = { "��ѡ��ʡ","�㶫ʡ", "����ʡ", "����ʡ" };
 String ss[][] = {{""}, { "������", "������", "��ݸ��","��ɽ��" }, 
		 { "�ϲ���", "������", "������","Ƽ����","�Ž���" },
		 { "��ɳ��", "��̶��", "������","������" } };
 String result;
 JLabel jl1=new JLabel("��ѡ��ʡ�ݣ�");
 JComboBox jb1 = new JComboBox(s);
 JLabel jl2=new JLabel("��ѡ�����أ�");
 JComboBox jb2 = new JComboBox();
 JLabel jl3=new JLabel("");
 JPanel panel = new JPanel();

 public Allcomboboxdemo() {
	 panel.add(jl1);
	 panel.add(jb1);
	 panel.add(jl2);
	 panel.add(jb2);
	 panel.add(jl3);
	 jb1.addActionListener(this);
	 jb2.addActionListener(this);
	 this.getContentPane().add(panel);
	 this.setBounds(100, 100, 400, 300);
	 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 this.setVisible(true);
}

 public static void main(String[] args) {
  new Allcomboboxdemo();
 }

 public void actionPerformed(ActionEvent e) {
	 JComboBox temp = (JComboBox) e.getSource();
	 if( result==null) result=new String();
	 String province;
	 if(temp.equals(jb1)){
		 int li=temp.getSelectedIndex();
		 if (li==0) result="";
		 if(jb2.getItemCount()!=0){
			 jb2.removeAllItems();
			 jb2.updateUI();
			 jb2.setSelectedItem("      ");
			 result="";
			}
		 for(int i=0;i<ss[li].length;i++){
				 jb2.addItem(ss[li][i]);
			}
	 }
	 if(temp.equals(jb2)){
		 String name = (String) jb2.getSelectedItem();
		 result=jb1.getSelectedItem()+name;
		 if(jb1.getSelectedIndex()==0) 
			 result="";
		 jl3.setText(result);
	 }
  }

 }