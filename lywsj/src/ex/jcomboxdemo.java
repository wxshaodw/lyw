package SwingTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class JComBoxDemo extends JFrame{
	private JComboBox jcb;
   	private JLabel lbl;
   	private Object cities[]={"北京市","上海市","天津市","重庆市","郑州市","太原市","石家庄市"};
   	public JComBoxDemo() {   
     		super("JComboBox例子演示" );
     		Container c=getContentPane();
     		c.setLayout(new FlowLayout());      
     		jcb=new JComboBox(cities); 
     		jcb.setMaximumRowCount(4);  
    		lbl=new JLabel("请从组合框中选择 ");
     		c.add(jcb);         
     		c.add(lbl);   
     		jcb.addItemListener( new Handler1());
    		setSize(300,250);
    		setVisible(true);     
	}
   	public static void main(String args[]) {   
   		JComBoxDemo app=new JComBoxDemo();
      	app.addWindowListener(new Handler2());
    }     
    class Handler1 implements ItemListener{	
       	public void itemStateChanged( ItemEvent e ) {
			lbl.setText("您选中了："+jcb.getSelectedItem());      
        	} 
     	} 
    static class Handler2 extends WindowAdapter{     
       	public void windowClosing(WindowEvent e) { 
			System.exit(0);          
		} 
      }   
 } //end of JComBoxDemo
