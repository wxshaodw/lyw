package SwingTest;
import javax.swing.*;
import java.awt.event.*;

public class FirstFrame extends JFrame {
  /*���췽��*/
  public FirstFrame() {
    this.setTitle("�ҵĵ�һ��GUI����");  //���ô���ı���
    this.setSize(300, 200);       //���ô���Ĵ�С
    this. setVisible (true);         //��������ʾ
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    		int value=JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�ر���");
        	if (value==JOptionPane.OK_OPTION) {
        		System.exit(0);
        	}
    	}
    }
    );
  }
	public static void main(String[] args){
    //���������ʵ������������
    new FirstFrame();
  }
	public void windowClosing(WindowEvent e) {
		int returnValue;
		returnValue = JOptionPane.showConfirmDialog(null, "ȷʵҪ�˳�������", "�˳�����", JOptionPane.YES_NO_OPTION);
		if (returnValue == JOptionPane.YES_OPTION)
 		 System.exit(0);
}

}
