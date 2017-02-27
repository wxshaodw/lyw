package SwingTest;

import javax.swing.*;

import java.awt.*;
public class Menutest extends JFrame {
 public  Menutest(String title) {
	 super(title);
	 JMenuBar mb = new JMenuBar();
	 JMenu fileMenu = new JMenu("显示");
	 JMenu pullRightMenu = new JMenu("问好");
	 fileMenu.add("欢迎");
	 fileMenu.addSeparator();
	 fileMenu.add(pullRightMenu);
	 fileMenu.add("退出");
	 pullRightMenu.add(new JCheckBoxMenuItem("早上好！"));
	 pullRightMenu.add(new JCheckBoxMenuItem("下午好！"));
	 pullRightMenu.add(new JCheckBoxMenuItem("晚安！再见！"));
	 mb.add(fileMenu);  
	 setJMenuBar(mb);
	 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  
  }
 public static void main(String args[]){
	 Menutest fr=new Menutest("包括菜单的测试程序");
	 fr.setSize(300, 200);
	 fr.setLocation(400, 300);
	 fr.setVisible(true);
 }
} 
