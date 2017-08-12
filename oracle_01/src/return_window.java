import java.awt.Container;
import java.sql.SQLException;

import javax.swing.*;

public class return_window extends JFrame{
	JLabel name =new JLabel();
	JLabel price =new JLabel();
	JLabel img =new JLabel();
	JPanel bot=new JPanel();
	public  return_window(String name,String price,String img){
		this.name.setText("商品名称："+name);
		this.price.setText("价格"+price);
		try{this.img.setIcon(new ImageIcon(getClass().getResource(img)));}
		catch(Exception e){
			System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		}
		Container c=getContentPane();
		bot.add(this.name);
		bot.add(this.price);
		bot.add(this.img);
		c.add(bot);
		setSize(380,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
