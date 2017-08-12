package SwingTest;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ImageDisplay {
	
	public static void main(String[] args) {
       // TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ImageViewerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
           }
       });
   }
}

class ImageViewerFrame extends JFrame{
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH =300 ;
	private static final int DEFAULT_HEIGHT =400 ;
	
	public ImageViewerFrame(){
       setTitle("ImageViewer");
       setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
       label = new JLabel();
       add(label);
       chooser = new JFileChooser();
       chooser.setCurrentDirectory(new File("."));
       JMenuBar menubar = new JMenuBar();
       setJMenuBar(menubar);
       JMenu menu = new JMenu("文件");
       menubar.add(menu);
       JMenuItem openItem = new JMenuItem("打开");
       menu.add(openItem);
       JMenuItem exitItem = new JMenuItem("关闭");
       menu.add(exitItem);
       openItem.addActionListener(new ActionListener() {
           		public void actionPerformed(ActionEvent arg) {
               // TODO Auto-generated method stub
           			int result = chooser.showOpenDialog(null);
           			if(result == JFileChooser.APPROVE_OPTION){
           				String name = chooser.getSelectedFile().getPath();
           				label.setIcon(new ImageIcon(name));
           			}
           		}
           });
       exitItem.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg) {
               // TODO Auto-generated method stub
               System.exit(0);
           }
       });
   }
   
}

