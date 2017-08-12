package ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Allcomboboxdemo extends JFrame implements ActionListener {
 String s[] = { "请选择省","广东省", "江西省", "湖南省" };
 String ss[][] = {{""}, { "广州市", "深圳市", "东莞市","中山市" }, 
		 { "南昌市", "赣州市", "吉安市","萍乡市","九江市" },
		 { "长沙市", "湘潭市", "衡阳市","益阳市" } };
 String result;
 JLabel jl1=new JLabel("请选择省份：");
 JComboBox jb1 = new JComboBox(s);
 JLabel jl2=new JLabel("请选择市县：");
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