package SwingTest;

import javax.swing.*;

import java.awt.*;
public class Menutest extends JFrame {
 public  Menutest(String title) {
	 super(title);
	 JMenuBar mb = new JMenuBar();
	 JMenu fileMenu = new JMenu("��ʾ");
	 JMenu pullRightMenu = new JMenu("�ʺ�");
	 fileMenu.add("��ӭ");
	 fileMenu.addSeparator();
	 fileMenu.add(pullRightMenu);
	 fileMenu.add("�˳�");
	 pullRightMenu.add(new JCheckBoxMenuItem("���Ϻã�"));
	 pullRightMenu.add(new JCheckBoxMenuItem("����ã�"));
	 pullRightMenu.add(new JCheckBoxMenuItem("�����ټ���"));
	 mb.add(fileMenu);  
	 setJMenuBar(mb);
	 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  
  }
 public static void main(String args[]){
	 Menutest fr=new Menutest("�����˵��Ĳ��Գ���");
	 fr.setSize(300, 200);
	 fr.setLocation(400, 300);
	 fr.setVisible(true);
 }
} 
