package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class draw_by_lot extends JFrame {
	JPanel mtu=new JPanel();
	JTextField maxf=new JTextField(10);
	JTextField minf=new JTextField(10);
	JTextField munf=new JTextField(10);
	JTextArea result=new JTextArea("恭喜以下同学：");
	JScrollPane sp=new JScrollPane(result);
	JLabel max=new JLabel("最大值：");
	JLabel min=new JLabel("最小值：");
	JLabel mun=new JLabel("取出数量");
	JButton draw=new JButton("抽签");
	public draw_by_lot(String name){
		super(name);
		setVisible(true);
		setSize(670,500);
		addtool();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public void addtool(){
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		mtu.add(max);
		mtu.add(maxf);
		mtu.add(min);
		mtu.add(minf);
		mtu.add(mun);
		mtu.add(munf);
		mtu.add(draw);
		c.add("North",mtu);
		c.add("Center",sp);
		result.setLineWrap(true);
		result.setEditable(false);
		draw.addActionListener(new a());
	}
	class a implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int max,min,mun;
			if(maxf.getText().equals("")||minf.getText().equals("")||munf.getText().equals("")){
				JLabel im =new JLabel("你输入的数据不能为空请重新输入");
				im.setFont(new java.awt.Font("Dialog", 1, 13));
				JOptionPane.showConfirmDialog(null,im );
			}
			else{
				max=Integer.parseInt(maxf.getText());
				min=Integer.parseInt(minf.getText());
				mun=Integer.parseInt(munf.getText());
				if(max-min<mun||max<min||mun==0||max<0||min<0){
					JLabel im =new JLabel("你的数据不符合要求请重新输入");
					im.setFont(new java.awt.Font("Dialog", 1, 13));
					JOptionPane.showConfirmDialog(null,im );
				}
				else{
					int a[]=new int[mun];
					int t,f = 0,i=0;
					String str="恭喜以下同学：";
					Random ran=new Random();
					while(i<mun){
						t=ran.nextInt(max+1);
						f=0;
						if(t<min)f=1;
						for(int j=0;j<i;j++){
							if(t==a[j]){
								f=1;
								break;
							}
						}
						if(f==0){
							a[i]=t;
							i=i+1;
						}
					}
					for(i=0;i<mun;i++){
						for(f=0;f<mun-1-i;f++)
						{
							if(a[f]>a[f+1]){
								t=a[f];
								a[f]=a[f+1];
								a[f+1]=t;
							}
						}
					}
					for(i=0;i<mun;i++)
						str=str+" "+a[i];
					result.setText(str);
				}
			}
		}
		}
	public static void main(String[] args) {
		draw_by_lot draw=new draw_by_lot("抽签");	
		// TODO Auto-generated method stub
	}
}
