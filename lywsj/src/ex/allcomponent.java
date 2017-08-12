package SwingTest;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.io.*;

public class AllComponent extends JFrame{ 
	MenuTest menuTest=new MenuTest();
	LeftPanel leftPanel=new LeftPanel();
	RightPanel rightPanel=new RightPanel();
	BottomPanel bottomPanel=new BottomPanel(); 
	CenterPanel centerPanel=new CenterPanel();
	JTextField textField; 
	JTextArea editor;
	JToolBar tb =new JToolBar();//工具栏
	private JButton b1,b2,b3,b4,b5,b6; //声明6个按钮，分别为：“打开”、“保存”、“复制”、“剪切”、“粘贴”、“关闭”
	Container c;
	private Font f=new Font("sanserif",Font.PLAIN,12);
	public AllComponent(){
		super();
    
		ImageIcon icon=new ImageIcon("img/xiaohui.jpg"); 
		setIconImage(icon.getImage());  
		this.setTitle("包括所有组件的例子");
		this.setJMenuBar(menuTest);
		//工具栏
		b1= new JButton(new ImageIcon("img/opensmall.jpg"));
		b2= new JButton(new ImageIcon("img/savesmall.jpg"));
		b3= new JButton(new ImageIcon("img/copysmall.jpg"));
		b4= new JButton(new ImageIcon("img/cutsmall.jpg"));
		b5= new JButton(new ImageIcon("img/pastesmall.jpg"));
		b6= new JButton(new ImageIcon("img/closesmall.jpg"));
		tb.add(b1);    
		tb.add(b2);
		tb.add(b3);   
		tb.add(b4);
		tb.add(b5);
		tb.add(b6);
		
		c=this.getContentPane();
		c.add(tb,BorderLayout.NORTH);
		c.add(leftPanel,BorderLayout.WEST);
		c.add(rightPanel,BorderLayout.EAST);
		c.add(centerPanel,BorderLayout.CENTER);
		c.add(bottomPanel,BorderLayout.SOUTH);
		this.addWindowListener(new WindowAdapter(){ 
			public void WindowClosing(WindowEvent e){
				//dispose();
				System.exit(0);
			} 
		}); 
		setSize(800,560);
		//setUndecorated(true);
		setLocation(200,90); 
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
} 

	class MenuTest extends JMenuBar{ 
		private JDialog aboutDialog;
		private JMenuBar mb;        //菜单棒
	    private JMenu fileMenu;     //文件菜单
	    private JMenu editMenu;     //编辑菜单
	    private JMenu formatMenu;   //格式菜单
	    private JMenu helpMenu;//帮助菜单
	    private JMenuItem fileMenuOpen,fileMenuSave,fileMenuExit;   //文件菜单的菜单项
	    private JMenuItem editMenuCopy,editMenuCut,editMenuPaste;   //编辑菜单的菜单项
	    private JMenu formatSet;//格式菜单第一级菜单
	    private JMenuItem lineWrap,cancleLineWrap,wrapStyleWord,cancleWrapStyleWord;//格式菜单的第二级菜单
	  	
	    public MenuTest(){ 
	    	//super();
	        fileMenu = new JMenu("文件(F)");//创建菜单
	        fileMenuOpen = new JMenuItem("打开(O)...Ctrl+O");
	        fileMenuOpen.setIcon(new ImageIcon("img/opensmall.jpg"));        
	        fileMenuSave = new JMenuItem("保存(S)...Ctrl+S");
	        fileMenuSave.setIcon(new ImageIcon("img/savesmall.jpg"));    
	        fileMenuExit = new JMenuItem("退出");
	        fileMenuExit.setIcon(new ImageIcon("img/closesmall.jpg"));  
	        JMHandler JM=new JMHandler();       //创建监听器
	        fileMenuOpen.addActionListener(JM); //注册监听器
	        fileMenuSave.addActionListener(JM);
	        fileMenuExit.addActionListener(JM);
	        fileMenu.add(fileMenuOpen);
	        fileMenu.add(fileMenuSave);
	        fileMenu.addSeparator();    //添加分隔线
	        fileMenu.add(fileMenuExit);
	        fileMenu.setFont(f);        //设置菜单中文体的字体
	         
	        //编辑菜单的实现
	        editMenu = new JMenu("编辑(E)");
	        editMenuCopy = new JMenuItem("复制(C) Ctrl+C");
	        editMenuCut = new JMenuItem("剪切(T) Ctrl+X");
	        editMenuPaste = new JMenuItem("粘贴(P) Ctrl+v");
	         EMHandler EM=new EMHandler();   //创建监听器
	        editMenuCopy.addActionListener(EM);//注册监听器
	        editMenuCut.addActionListener(EM);
	        editMenuPaste.addActionListener(EM);
	        editMenu.add(editMenuCopy);
	        editMenu.add(editMenuCut);
	        editMenu.add(editMenuPaste);
	        editMenu.setFont(f);
	   
	        //格式菜单的实现
	        formatMenu = new JMenu("格式(O)");            //创建菜单
	        formatSet = new JMenu("格式设置");          //二级菜单
	        lineWrap = new JMenuItem("自动换行");       //二级菜单项
	        cancleLineWrap = new JMenuItem("取消自动换行");
	        wrapStyleWord = new JMenuItem("断行不断字");
	        cancleWrapStyleWord = new JMenuItem("取消断行不断字");
	        FMHandler FM=new FMHandler();               //创建事件监听器
	        lineWrap.addActionListener(FM);             //注册二级菜单项的监听器
	        cancleLineWrap.addActionListener(FM);
	        wrapStyleWord.addActionListener(FM);
	        cancleWrapStyleWord.addActionListener(FM);
	        formatSet.add(lineWrap);
	        formatSet.add(cancleLineWrap);
	        formatSet.addSeparator();   //添加分隔线
	        formatSet.add(wrapStyleWord);
	        formatSet.add(cancleWrapStyleWord);
	        formatMenu.add(formatSet);
	        formatMenu.setFont(f);
	  
	        //帮助菜单的实现
	        helpMenu=new JMenu("帮助");
	        JMenuItem aboutMenuItem=new JMenuItem("关于..",KeyEvent.VK_A);
	        JMenuItem exitMenuItem=new JMenuItem("退出",KeyEvent.VK_E);
	        helpMenu.add(aboutMenuItem);
	        helpMenu.add(exitMenuItem);	
	        aboutDialog=new JDialog();
	        initAboutDialog();
	        exitMenuItem.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		System.exit(0);
	        	}
	        });
	        aboutMenuItem.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		aboutDialog.show();
	        	}
	        });
	             
	        //将菜单全部添加菜单栏里
	        add(fileMenu);
	        add(editMenu);
	        add(formatMenu);
	        add(helpMenu);
		} 
	  	
		public JDialog get(){ 
			return aboutDialog;
		} 
		
		public void initAboutDialog(){ 
			aboutDialog.setTitle("关于");
			Container con=aboutDialog.getContentPane();
			Icon icon=new ImageIcon("img/logo.jpg"); 
			JLabel aboutLabel=new JLabel("<html><b><font size=5>"+"<center>Swing!"+"<br>",icon,JLabel.CENTER);
			con.add(aboutLabel,BorderLayout.CENTER);
			aboutDialog.setSize(450,225); 
			aboutDialog.setLocation(300,300);
			aboutDialog.addWindowListener(new WindowAdapter(){ 
				public void WindowClosing(WindowEvent e){
					dispose();
				} 
			}); 
		} 
		private class JMHandler implements ActionListener
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
	            if(e.getSource()==fileMenuOpen){ loadFile(); }
	            else if(e.getSource()==fileMenuSave){ saveFile(); }
	            else{System.exit(0);}
	        }
	    }
	    
		private class FMHandler implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            if(e.getSource()==lineWrap){ editor.setLineWrap(true); }
	            else if(e.getSource()==cancleLineWrap) { editor.setLineWrap(false);}
	            else if(e.getSource()==wrapStyleWord) { editor.setWrapStyleWord(true);}
	            else{ editor.setWrapStyleWord(false); }
	        }
	    }
		
		private class EMHandler implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            if(e.getSource()==editMenuCopy)     //实现复制功能
	            {
	                editor.copy();
	                editor.requestFocus();
	            }
	            else if(e.getSource()==editMenuCut)//实现剪切功能
	            {
	                editor.cut();
	                editor.requestFocus();
	            }
	            else                                //实现粘贴功能
	            {
	                editor.paste();
	                editor.requestFocus();
	            }
	        }
	    }
		
	} 

	class LeftPanel extends JPanel{ 
		private int i=0;
		public LeftPanel(){
			DefaultMutableTreeNode root=new DefaultMutableTreeNode("Root"); 
			DefaultMutableTreeNode child=new DefaultMutableTreeNode("Child");
			DefaultMutableTreeNode select=new DefaultMutableTreeNode("select");
			DefaultMutableTreeNode child1=new DefaultMutableTreeNode("child"+i);
			root.add(child); 
			root.add(select);
			child.add(child1); 
			JTree tree=new JTree(root);
			tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
			tree.setRowHeight(20); 
			tree.addTreeSelectionListener(new TreeSelectionListener(){ 
				public void valueChanged(TreeSelectionEvent e){
					JTree tree=(JTree)e.getSource();
					DefaultMutableTreeNode selectNode=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					i++; 
					selectNode.add(new DefaultMutableTreeNode(""+i));
				} 
			}); 
			tree.setPreferredSize(new Dimension(100,160));
			JScrollPane scrollPane=new JScrollPane(tree);
			this.add(scrollPane); 
		} 
	} 
	
	class BottomPanel extends JPanel{ 
		private JProgressBar pb;
		public BottomPanel(){ 
			pb=new JProgressBar();
			pb.setPreferredSize(new Dimension(500,20));
			Timer time=new Timer(1,new ActionListener(){
				int counter=0;
				public void actionPerformed(ActionEvent e){
					counter++;
					pb.setValue(counter);
					Timer t=(Timer)e.getSource(); 
					if(counter==pb.getMaximum()){
						t.stop();
						counter=0;
						t.start();
					} 
				}
			}); 
			time.start();
			pb.setStringPainted(true);
			pb.setMinimum(0);
			pb.setMaximum(1000);
			pb.setBackground(Color.white);
			pb.setForeground(Color.red);
			this.add(pb);
		} 
		public void setProcessBar(BoundedRangeModel rangeModel){
			pb.setModel(rangeModel);
		} 
	} 
	
	class RightPanel extends JPanel{
		public RightPanel(){
			this.setLayout(new GridLayout(10,1));
			JCheckBox checkBox=new JCheckBox("复选按钮");
			JButton button=new JButton("打开文件"); 
			button.setIcon(new ImageIcon("img/opensmall.jpg"));// 为按钮增加图标
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JFileChooser file=new JFileChooser();
					int resule=file.showOpenDialog(new JPanel()); 
					if(resule==file.APPROVE_OPTION){
						String fileName=file.getSelectedFile().getName();
						String dir=file.getSelectedFile().getAbsolutePath(); 
						textField.setText(dir);
						JOptionPane.showConfirmDialog(null,dir,"选择的文件",JOptionPane.YES_OPTION);
					}
				} 
			}); 
			JToggleButton toggleButton=new JToggleButton("双色按钮");
			toggleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!((JToggleButton)e.getSource()).getModel().isSelected()) {
                        ((JToggleButton)e.getSource()).setBackground(Color.green);
                    } else {
                        ((JToggleButton)e.getSource()).setBackground(Color.yellow);
                    }
                }
            });
			ButtonGroup buttonGroup=new ButtonGroup();
			JRadioButton radioButton1=new JRadioButton("计算机科学与技术",false);
			JRadioButton radioButton2=new JRadioButton("软件工程",false);
			JComboBox comboBox=new JComboBox(); 
			comboBox.addItem("程序员");
			comboBox.addItem("分析员");
			comboBox.setToolTipText("点击下拉列表增加选项");
			comboBox.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent e){
					JComboBox comBox=(JComboBox)e.getSource(); 
				} 
			}); 
			DefaultListModel litem=new DefaultListModel();
			litem.addElement("男"); 
			litem.addElement("女");
			JList list=new JList(litem); 
			list.addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent e){
					JList l=(JList)e.getSource();
					Object s=l.getSelectedValue(); 
					JOptionPane.showMessageDialog(null,s,"消息框",JOptionPane.YES_OPTION);
				}
			});
			buttonGroup.add(radioButton1); 
			buttonGroup.add(radioButton2);
			add(button);
			add(toggleButton); 
			add(checkBox);
			add(radioButton1);
			add(radioButton2);
			add(comboBox); 
			add(list);
			this.setBorder(new EtchedBorder(EtchedBorder.LOWERED,Color.LIGHT_GRAY,Color.blue));
		}
	} 
	
	class CenterPanel extends JPanel{ 
		public CenterPanel(){
			textField=new JTextField("文本域，点击<打开文件>按钮可选择文件");
			textField.setActionCommand("textField");   
			JTabbedPane tab=new JTabbedPane(JTabbedPane.TOP);
			editor=new JTextArea(); 
			editor.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			editor.setText("编辑器，试着点击文本区，试着拉动分隔条。"); 
			editor.addMouseListener(new MouseAdapter(){ 
				public void mousePressed(MouseEvent e){
					JTextPane textPane=(JTextPane)e.getSource();
					textPane.setText("编辑器点击命令成功"); 
				} 
			}); 
			JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,textField,editor); 
			JTable table=new JTable(10,10); 
			JPanel pane=new JPanel(); 
			pane.add(table.getTableHeader(),BorderLayout.NORTH);
			pane.add(table);
			tab.addTab("文本演示",splitPane); 
			tab.addTab("表格演示", pane);
			tab.setPreferredSize(new Dimension(500,400));
			this.add(tab);
			this.setEnabled(true); 
		}
	} 
	
public void loadFile()  //打开文件方法
    {
        JFileChooser fc=new JFileChooser();
        int r=fc.showOpenDialog(this);
        if(r==JFileChooser.APPROVE_OPTION)
        {
            File file=fc.getSelectedFile();
            try{editor.read(new FileReader(file),null);}
            catch(IOException e){}
        }
    }
          
    public void saveFile() { /*保存文件的方法*/
        JFileChooser fc=new JFileChooser();
        int r=fc.showSaveDialog(this);
        if(r==JFileChooser.APPROVE_OPTION)
        {
            File file=fc.getSelectedFile();
            try{ editor.write(new FileWriter(file));}
            catch(IOException e){}
        }
    }
	
    public static void main(String args[]){
		new AllComponent();
	} 

} 
