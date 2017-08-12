package SwingTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class JComBoxDemo extends JFrame{
	private JComboBox jcb;
   	private JLabel lbl;
   	private Object cities[]={"������","�Ϻ���","�����","������","֣����","̫ԭ��","ʯ��ׯ��"};
   	public JComBoxDemo() {   
     		super("JComboBox������ʾ" );
     		Container c=getContentPane();
     		c.setLayout(new FlowLayout());      
     		jcb=new JComboBox(cities); 
     		jcb.setMaximumRowCount(4);  
    		lbl=new JLabel("�����Ͽ���ѡ�� ");
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
			lbl.setText("��ѡ���ˣ�"+jcb.getSelectedItem());      
        	} 
     	} 
    static class Handler2 extends WindowAdapter{     
       	public void windowClosing(WindowEvent e) { 
			System.exit(0);          
		} 
      }   
 } //end of JComBoxDemo
