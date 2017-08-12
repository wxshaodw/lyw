package SwingTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AllListDemo extends JFrame {
	private JList jList1;
	private JButton jButton1;
	private JButton jButton2;
	private JList jList2;
	private DefaultListModel listModel1;
	private DefaultListModel listModel2;
	private JButton jButton4;
	private JButton jButton3;
	public static void main(String[] args) {
		AllListDemo inst = new AllListDemo();
		inst.setTitle("列表框演示");
		inst.setVisible(true);
	}
	public AllListDemo() {
		super();
		initGUI();
	}
	private void initGUI() {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			
			listModel1 = new DefaultListModel();
			listModel1.addElement("item 1");
			listModel1.addElement("item 2");
			listModel1.addElement("item 3");
			listModel1.addElement("item 4");
			listModel1.addElement("item 5");
			listModel1.addElement("item 6");
			listModel1.addElement("item 7");
			listModel1.addElement("item 8");
			jList1 = new JList(listModel1);
			JScrollPane leftsp=new JScrollPane(jList1);
			//leftsp.add(jList1);
			leftsp.setBounds(42, 28, 119, 203);
			getContentPane().add(leftsp);
			
			listModel2 = new DefaultListModel();
			jList2 = new JList(listModel2);
			JScrollPane rightsp=new JScrollPane(jList2);
			rightsp.setBounds(238, 28, 119, 203);
			getContentPane().add(rightsp);
			jButton1 = new JButton();
			getContentPane().add(jButton1);
			jButton1.setText(">");
			jButton1.setBounds(168, 84, 63, 28);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
			jButton2 = new JButton();
			getContentPane().add(jButton2);
			jButton2.setText("<");
			jButton2.setBounds(168, 133, 63, 28);
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton2ActionPerformed(evt);
				}
			});
			jButton3 = new JButton();
			getContentPane().add(jButton3);
			jButton3.setText("添加");
			jButton3.setBounds(168, 35, 63, 28);
			jButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton3ActionPerformed(evt);
				}
			});
			jButton4 = new JButton();
			getContentPane().add(jButton4);
			jButton4.setText("删除");
			jButton4.setBounds(168, 189, 63, 28);
			jButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton4ActionPerformed(evt);
				}
			});
   pack();
   setSize(400, 300);
   setLocationRelativeTo(null);
 }
 /** jList1移动到jList2*/
 private void jButton1ActionPerformed(ActionEvent evt) {
	 if(jList1.getSelectedIndex()!=-1){
		 listModel2.addElement(jList1.getSelectedValue());
		 int i=jList1.getSelectedIndex();
		 listModel1.remove(i);   
		 jList1.setSelectedIndex(i>0? i-1:0);
		 jList2.setSelectedIndex(listModel2.size()-1);
	} 
}
 
 /** jList2移动到jList1*/
 private void jButton2ActionPerformed(ActionEvent evt) {
	 if(jList2.getSelectedIndex()!=-1){
		 listModel1.addElement(jList2.getSelectedValue());
		 int i=jList2.getSelectedIndex();
		 listModel2.remove(i);
		 jList2.setSelectedIndex(i>0? i-1:0);
	}
 }
 /** jList1增加项*/
 private void jButton3ActionPerformed(ActionEvent evt) {
	 listModel1.addElement("new item");
 }
 /** jList1删除项*/
 private void jButton4ActionPerformed(ActionEvent evt) {
	 if(jList1.getSelectedIndex()!=-1){
		 listModel1.remove(jList1.getSelectedIndex());   
	}
 }
}