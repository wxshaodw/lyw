import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class TQYG extends JPanel{
	Container c;
	JButton btn6;
	JTextArea ta;
	public TQYG() {
		setLayout(null);
		btn6 = new JButton("统计");
		btn6.setBounds(891, 210, 81, 27);
		btn6.setFont(new Font("华文新魏", Font.PLAIN, 18));
		this.add(btn6);
		final Object [] columnNames={"教师名","教师编号","课程号","课程名","课时","学分","课程性质"};
		Object[][] rowData=new Object[15][7];/*行数*/
		for(int i=0;i<3;i++){
				rowData[i][0]="";
				rowData[i][1]="";
				rowData[i][2]="";
				rowData[i][3]="";
			}
		JTable bg=new JTable(rowData,columnNames);
		JScrollPane ta=new JScrollPane(bg);
		ta.setBounds(120, 78, 664, 293);
		this.add(ta);
		JLabel label_2 = new JLabel("打印输出:");
		label_2.setFont(new Font("华文新魏", Font.PLAIN, 20));
		label_2.setBounds(121, 31, 86, 48);
		this.add(label_2);
	}
}