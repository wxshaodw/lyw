package SwingTest;
import javax.swing.*;
import java.awt.event.*;

public class FirstFrame extends JFrame {
  /*构造方法*/
  public FirstFrame() {
    this.setTitle("我的第一个GUI程序");  //设置窗体的标题
    this.setSize(300, 200);       //设置窗体的大小
    this. setVisible (true);         //将窗体显示
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    		int value=JOptionPane.showConfirmDialog(null, "确定要关闭吗？");
        	if (value==JOptionPane.OK_OPTION) {
        		System.exit(0);
        	}
    	}
    }
    );
  }
	public static void main(String[] args){
    //创建窗体的实例，匿名对象
    new FirstFrame();
  }
	public void windowClosing(WindowEvent e) {
		int returnValue;
		returnValue = JOptionPane.showConfirmDialog(null, "确实要退出程序吗？", "退出程序", JOptionPane.YES_NO_OPTION);
		if (returnValue == JOptionPane.YES_OPTION)
 		 System.exit(0);
}

}
