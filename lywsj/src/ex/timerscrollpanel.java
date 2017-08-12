package SwingTest;

import java.awt.AWTEvent;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class TimerScrollPanel extends JFrame{
   private JTextArea ta = new JTextArea();
   private Timer   timer = new Timer();

   public TimerScrollPanel(){
	   super();
	   enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	   init();
   }

   private void init(){
	   setBounds(0, 0, 300, 150);
	   final JScrollPane sp = new JScrollPane(ta);//将文本域添加到滚动面板中
	   getContentPane().add(sp, "Center");
	   ta.setText("Start.....\n");
	   TimerTask task = new TimerTask(){
		   public void run(){
			   ta.append("Time: " + (System.currentTimeMillis() / 1000) + "\n");
			   scrollAndSetCursor();
			 }
	   };
	   timer.schedule(task, 0, 1000);
   }

   /** 该方法用于实现滚动以及光标相关效果 */
  public void scrollAndSetCursor(){
    // ta.requestFocus();
    ta.setSelectionStart(ta.getText().length());
  }

   protected void processWindowEvent(WindowEvent e){
	   super.processWindowEvent(e);
	   if(e.getID() == WindowEvent.WINDOW_CLOSING)
		   System.exit(0);
   }

   public static void main(String[] args){
     TimerScrollPanel scroll = new TimerScrollPanel();
     scroll.setVisible(true);
   }
}