package pane;
import javax.swing.*;

import function.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
public class main_pane extends JFrame{
	static String user_id;
	static Object source;
	static friends_info[] fi_data;
	static finance[] f_data;
	static diary[] d_data;
	static data_table data; 
	static int tip;
	JLabel wellcome =new JLabel();
	JLabel logo=new JLabel();
	JLabel background=new JLabel();
	static JButton address_list= new JButton();
	static JButton daily_record=new JButton();
	static JButton finance=new JButton();
	JButton insert=new JButton("插入");
	JButton updata=new JButton("查看");
	JButton delete=new JButton("删除");
	JButton cheak=new JButton("查询");
	JButton change_password= new JButton("修改个人密码");
	JButton u_personal_b=new JButton("查看个人名片");
	static JButton out=new JButton("报表输出");
	static JTextField key=new JTextField(40);
	JTextField key_1=new JTextField(40);
	ImageIcon i_background=new ImageIcon("./img/背景.jpg");
	ImageIcon logo_wellcome=new ImageIcon("./img/伟文个人事务管理系统.png");
	ImageIcon i_address_list=new ImageIcon("./img/通讯录管理.png");
	ImageIcon i_daily_record=new ImageIcon("./img/日志管理.png");
	ImageIcon i_finance= new ImageIcon("./img/财务管理.png");
	JPanel p_wellcome_info=new JPanel();
	JPanel p_wellcome=new JPanel();
	static JPanel title=new JPanel();
	static JPanel b_cheak=new JPanel();
	static JPanel p_cheak=new JPanel();
	JPanel p_function=new JPanel();
	JPanel p_friend_info=new JPanel();
	JPanel p_finance=new JPanel();
	JPanel p_users_info=new JPanel();
	JPanel p_daily_record=new JPanel();
	static JPanel p_data=new JPanel();
	JPanel p_system=new JPanel();
	static JScrollPane SP = null;
	static JPanel P_data_b=new JPanel();
	FileDialog fd = new FileDialog(this, "保存", FileDialog.SAVE);
	private static JComboBox jcb;
    private static JComboBox jcb1;
    private static JComboBox jcb2;
    private static JLabel jl2;
    private JLabel jl3;
    
	public main_pane(String user_name,String user_id){
		this.user_id=user_id;
		wellcome.setText(user_name+"，欢迎你");
		wellcome.setFont(new Font("黑体", Font.PLAIN, 20));
		addtool();
		setSize(1448,990);
		setVisible(true);
		this.setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void addtool(){
		Container c=getContentPane();
		p_system.setLayout(new BoxLayout(p_system,BoxLayout.X_AXIS));
		background.setLayout(new BorderLayout());
		addwellcome();
		addcenter();
		background.setIcon(i_background);
		p_system.setOpaque(false);
		background.add("North",p_wellcome);
		background.add("Center",p_system);
		c.add(background);
	}
	public void addwellcome(){
		p_wellcome.setLayout(new BorderLayout());
		logo.setIcon(logo_wellcome);
		p_wellcome_info.add(wellcome);
		p_wellcome.add("Center",logo);
		p_wellcome.add("East",p_wellcome_info);
		p_wellcome_info.setOpaque(false);
		p_wellcome.setOpaque(false);
	}
	public void addcheak(){
		p_cheak.setLayout(new BoxLayout(p_cheak,BoxLayout.X_AXIS));
		b_cheak.setLayout(new BorderLayout());
		jl2=new JLabel(" ");
		jl2.setBounds(260,120,80,20);
		jl2.setFont(new Font("黑体", Font.PLAIN, 50));
		jcb = new JComboBox();
        jcb.addItem("时间");
        jcb.addItem("标题");
        jcb.setBounds(310, 120, 80, 20);
        jcb1 = new JComboBox();
        jcb1.addItem("姓名");
        jcb1.addItem("固定电话");
        jcb1.addItem("QQ");
        jcb1.addItem("电子邮箱");
        jcb1.addItem("移动电话");
        jcb1.addItem("备用电话");
        jcb1.setBounds(260, 140, 80, 20);
        jcb2 = new JComboBox();
        jcb2.addItem("收支额");
        jcb2.addItem("时间");
        jcb2.addItem("来源");
        jcb2.setBounds(260, 160, 80, 20);
        p_cheak.add(jl2);
		p_cheak.add(key);
		p_cheak.add(cheak);
		p_cheak.add(jcb);
		p_cheak.add(jcb1);
		p_cheak.add(jcb2);
		p_cheak.add(insert);
		p_cheak.add(updata);
		p_cheak.add(delete);
		p_cheak.add(u_personal_b);
		p_cheak.add(change_password);
		p_cheak.add(out);
		title.add(jl2);
		b_cheak.add("North",p_cheak);
		b_cheak.add("Center",title);
		b_cheak.setBackground(null);
		title.setBackground(null);
		jcb.setVisible(false);
		jcb1.setVisible(false);
		jcb2.setVisible(false);
		out.setVisible(false);
		change_password.addActionListener(new cheak_Listener());
		cheak.addActionListener(new cheak_Listener());
		u_personal_b.addActionListener(new cheak_Listener());
		cheak.addActionListener(new cheak_Listener());
		insert.addActionListener(new cheak_Listener());
		updata.addActionListener(new cheak_Listener());
		delete.addActionListener(new cheak_Listener());
		out.addActionListener(new cheak_Listener());
		key.setAlignmentX(Component.RIGHT_ALIGNMENT);
		cheak.setAlignmentX(Component.RIGHT_ALIGNMENT);
		}
	public void addfunction(){
		p_function.setLayout(new GridLayout(3,1,3,10));
		p_function.setSize(i_address_list.getIconWidth(), i_address_list.getIconHeight());
		address_list.setBorderPainted(false);
		address_list.setContentAreaFilled(false);
		address_list.addActionListener(new Listener());
		daily_record.setBorderPainted(false);
		daily_record.setContentAreaFilled(false);
		daily_record.addActionListener(new Listener());
		finance.setBorderPainted(false);
		finance.setContentAreaFilled(false);
		finance.addActionListener(new Listener());
		finance.addActionListener(new Listener());
		address_list.setSize(i_address_list.getIconWidth(), i_address_list.getIconHeight());
		address_list.setIcon(i_address_list);
		daily_record.setSize(i_daily_record.getIconWidth(), i_daily_record.getIconWidth());
		daily_record.setIcon(i_daily_record);
		finance.setSize(i_finance.getIconWidth(), i_finance.getIconWidth());
		finance.setIcon(i_finance);
		p_function.add(address_list);
		p_function.add(daily_record);
		p_function.add(finance);
		p_function.setOpaque(false);
	}
	public void addcenter(){
		addcheak();
		addfunction();
		p_data.setLayout(new BorderLayout());
		p_data.add("North",key_1);
		p_data.setOpaque(false);
		key_1.setVisible(false);
		p_system.add(p_function);
		p_system.add(p_data);
	}


	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			source=e.getSource();
			key.setText("");
			if(e.getSource()==address_list){
				try {
					finance.setContentAreaFilled(false);
					daily_record.setContentAreaFilled(false);
					address_list.setContentAreaFilled(true);
					address_list.setBackground(Color.lightGray);
					p_function.updateUI();
					M_friends_info create=new M_friends_info (user_id);
					fi_data=create.return_f_i();
					create_table(user_id,source);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if(e.getSource()==finance){
				try {
					address_list.setContentAreaFilled(false);
					daily_record.setContentAreaFilled(false);
					finance.setContentAreaFilled(true);
					finance.setBackground(Color.lightGray);
					M_finance create=new M_finance(user_id);
					f_data = create.return_finance();
					create_table(user_id,source);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getSource()==daily_record){
				try {
					finance.setContentAreaFilled(false);
					address_list.setContentAreaFilled(false);
					daily_record.setContentAreaFilled(true);
					daily_record.setBackground(Color.lightGray);
					M_diary create=new M_diary(user_id);
					d_data= create.return_diary();
					create_table(user_id,source);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	class cheak_Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==cheak){
				if(source==address_list){
						try {
							p_data.removeAll();
							String type = null;
							if(jcb1.getSelectedItem().toString().equals("姓名"))type="FI_name";
							if(jcb1.getSelectedItem().toString().equals("固定电话"))type="FI_phone";
							if(jcb1.getSelectedItem().toString().equals("移动电话"))type="FI_mobile";
							if(jcb1.getSelectedItem().toString().equals("备用电话"))type="FI_mobile2";
							if(jcb1.getSelectedItem().toString().equals("电子邮箱"))type="FI_emall";
							if(jcb1.getSelectedItem().toString().equals("QQ"))type="FI_QQ";
							M_friends_info u=new M_friends_info(user_id);
							fi_data=u.cheak_friends_info(type,key.getText());
							create_table(user_id,source);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
				if(source==finance){
					try {
						p_data.removeAll();
						String type = null;
						if(jcb2.getSelectedItem().toString().equals("时间"))type="F_date";
						if(jcb2.getSelectedItem().toString().equals("来源"))type="F_source";
						if(jcb2.getSelectedItem().toString().equals("收支额"))type="F_payment";
						M_finance u=new M_finance(user_id);
						f_data=u.cheak_finance(type, key.getText());
						create_table(user_id,source);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(source==daily_record){
					try {
						p_data.removeAll();
						String type = null;
						if(jcb.getSelectedItem().toString().equals("时间"))type="D_date";
						if(jcb.getSelectedItem().toString().equals("标题"))type="D_title";
						M_diary u=new M_diary(user_id);
						d_data=u.cheak_diary(type, key.getText());
						create_table(user_id,source);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			if(e.getSource()==insert)updata_panel(user_id,source,-1);
			if(e.getSource()==out){
				if(source==address_list){
				     fd.setLocation(400, 250);
				     fd.setVisible(true);
				     String stringfile = fd.getDirectory()+fd.getFile()+".xls";
				     if(!stringfile.equals("nullnull.xls")){
					        try {
						         output a = new output();
						         a.exportTable(data, new File(stringfile));
						        } catch (IOException ex) {
						            ex.printStackTrace();
						        }
				     }
				     }
			}
			if(e.getSource()==updata){
				tip=data.getSelectedRow();
				if(tip==-1)JOptionPane.showMessageDialog(null, "请先选定表格再进行操作","提示", JOptionPane.INFORMATION_MESSAGE);
				else updata_panel(user_id,source,tip);}
			if(e.getSource()==delete){
				tip=data.getSelectedRow();
				if(tip==-1)JOptionPane.showMessageDialog(null, "请先选定表格再进行操作","提示", JOptionPane.INFORMATION_MESSAGE);
				else{
					if(source==address_list){
						try {
							M_friends_info d=new M_friends_info(user_id);
							d.delete_f_i(fi_data[tip].getid());
							JOptionPane.showMessageDialog(null, "删除成功","", JOptionPane.INFORMATION_MESSAGE);
							M_friends_info create=new M_friends_info (user_id);
							fi_data=create.return_f_i();
							create_table(user_id,source);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}		
				if(source==finance){
						try {
							M_finance d=new M_finance(user_id);
							d.delete__finance(f_data[tip].getid());
							JOptionPane.showMessageDialog(null, "删除成功","", JOptionPane.INFORMATION_MESSAGE);
							M_finance create=new M_finance(user_id);
							f_data = create.return_finance();
							create_table(user_id,source);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}		
				if(source==daily_record){
						try {
							M_diary d=new M_diary(user_id);
							d.delete_diary(d_data[tip].getid());
							file.deleteFile(d_data[tip].getaddress());
							JOptionPane.showMessageDialog(null, "删除成功","", JOptionPane.INFORMATION_MESSAGE);
							M_diary create=new M_diary(user_id);
							d_data= create.return_diary();
							create_table(user_id,source);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				}
			if(e.getSource()==u_personal_b){
				p_i_return a=new p_i_return(user_id);
			}
			if(e.getSource()==change_password) new change_password();
		}
		}
	public static  void create_table(String user_id,Object source)throws ClassNotFoundException, SQLException, IOException{
		if(source==address_list){
			Object [] columnNames={"姓名","性别","年龄","生日","固定电话","移动电话","备用电话","邮箱","QQ","公司","职位","备注"};
			Object[][] rowData=new Object[fi_data.length][12];
			for(int i=0;i<fi_data.length;i++){
				rowData[i][0]=fi_data[i].getname();
				rowData[i][1]=fi_data[i].getsex();
				rowData[i][2]=fi_data[i].getage();
				rowData[i][3]=fi_data[i].getbirthday();
				rowData[i][4]=fi_data[i].getphone();
				rowData[i][5]=fi_data[i].getmobile();
				rowData[i][6]=fi_data[i].getmobile2();
				rowData[i][7]=fi_data[i].getemail();
				rowData[i][8]=fi_data[i].getQQ();
				rowData[i][9]=fi_data[i].getcompany();
				rowData[i][10]=fi_data[i].getposition();
				rowData[i][11]=fi_data[i].getremark();
			}
			data=new data_table(rowData,columnNames);
			data.setRowSelectionAllowed(true);
			data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			SP=new JScrollPane(data);
			jl2.setText("通讯录管理");
			jcb.setVisible(false);
			jcb1.setVisible(true);
			jcb2.setVisible(false);
			out.setVisible(true);
			}
		if(source==finance){
			final Object [] columnNames={"日期","收支额","来源","备注"};
			Object[][] rowData=new Object[f_data.length][4];
			for(int i=0;i<f_data.length;i++){
					rowData[i][0]=f_data[i].getdate();
					rowData[i][1]=f_data[i].getpayment();
					rowData[i][2]=f_data[i].getsource();
					rowData[i][3]=f_data[i].getremark();
				}
			data=new data_table(rowData,columnNames);
			data.setRowSelectionAllowed(true);
			data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			SP=new JScrollPane(data);
			jl2.setText("财务信息管理");
			out.setVisible(false);
			jcb.setVisible(false);
			jcb1.setVisible(false);
			jcb2.setVisible(true);
		}
		if(source==daily_record){
			final Object [] columnNames={"日期","标题","内容"};
			Object[][] rowData=new Object[d_data.length][3];
			for(int i=0;i<d_data.length;i++){
						rowData[i][0]=d_data[i].getdate();
						rowData[i][1]=d_data[i].gettitle();
						rowData[i][2]=d_data[i].getdiary_data();
					}
			data=new data_table(rowData,columnNames);
			data.setRowSelectionAllowed(true);
			data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			SP=new JScrollPane(data);
			data.setRowSelectionAllowed(true);
			jl2.setText("日志管理");
			out.setVisible(false);
			jcb.setVisible(true);
			jcb1.setVisible(false);
			jcb2.setVisible(false);
		}
		data.setRowHeight(25);
		data.setFont(new Font("黑体", Font.PLAIN, 20));
		p_data.setBackground(null);
		p_data.removeAll();
		p_data.add("North",b_cheak);
		p_data.add("Center",SP);
		p_cheak.updateUI();
		p_data.updateUI();
		}
	public static void updata_panel(String user_id,Object source,int tip){
		JPanel i=null;
		if(source==address_list){
			if(tip==-1)i=new f_i_updata(user_id,null);
			else i=new f_i_updata(user_id,fi_data[tip]);
		}
		if(source==finance){
			if(tip==-1)i=new finance_updata(user_id,null);
			else i=new finance_updata(user_id,f_data[tip]);
		}
		if(source==daily_record){
			if(tip==-1)i=new diary_updata(user_id,null);
			else i=new diary_updata(user_id,d_data[tip]);
		}
		p_data.removeAll();
		P_data_b.removeAll();
		P_data_b.setLayout(null);
		i.setBounds(800, 0, 800,1000);
		SP.setBounds(0, 0, 800, 1000);
		P_data_b.add(i);
		P_data_b.add(SP);
		p_data.add("North", b_cheak);
		p_data.add("Center",P_data_b);
		P_data_b.updateUI();
		p_data.updateUI();
	}
}
