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
	JToolBar tb =new JToolBar();//������
	private JButton b1,b2,b3,b4,b5,b6; //����6����ť���ֱ�Ϊ�����򿪡��������桱�������ơ��������С�����ճ���������رա�
	Container c;
	private Font f=new Font("sanserif",Font.PLAIN,12);
	public AllComponent(){
		super();
    
		ImageIcon icon=new ImageIcon("img/xiaohui.jpg"); 
		setIconImage(icon.getImage());  
		this.setTitle("�����������������");
		this.setJMenuBar(menuTest);
		//������
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
		private JMenuBar mb;        //�˵���
	    private JMenu fileMenu;     //�ļ��˵�
	    private JMenu editMenu;     //�༭�˵�
	    private JMenu formatMenu;   //��ʽ�˵�
	    private JMenu helpMenu;//�����˵�
	    private JMenuItem fileMenuOpen,fileMenuSave,fileMenuExit;   //�ļ��˵��Ĳ˵���
	    private JMenuItem editMenuCopy,editMenuCut,editMenuPaste;   //�༭�˵��Ĳ˵���
	    private JMenu formatSet;//��ʽ�˵���һ���˵�
	    private JMenuItem lineWrap,cancleLineWrap,wrapStyleWord,cancleWrapStyleWord;//��ʽ�˵��ĵڶ����˵�
	  	
	    public MenuTest(){ 
	    	//super();
	        fileMenu = new JMenu("�ļ�(F)");//�����˵�
	        fileMenuOpen = new JMenuItem("��(O)...Ctrl+O");
	        fileMenuOpen.setIcon(new ImageIcon("img/opensmall.jpg"));        
	        fileMenuSave = new JMenuItem("����(S)...Ctrl+S");
	        fileMenuSave.setIcon(new ImageIcon("img/savesmall.jpg"));    
	        fileMenuExit = new JMenuItem("�˳�");
	        fileMenuExit.setIcon(new ImageIcon("img/closesmall.jpg"));  
	        JMHandler JM=new JMHandler();       //����������
	        fileMenuOpen.addActionListener(JM); //ע�������
	        fileMenuSave.addActionListener(JM);
	        fileMenuExit.addActionListener(JM);
	        fileMenu.add(fileMenuOpen);
	        fileMenu.add(fileMenuSave);
	        fileMenu.addSeparator();    //��ӷָ���
	        fileMenu.add(fileMenuExit);
	        fileMenu.setFont(f);        //���ò˵������������
	         
	        //�༭�˵���ʵ��
	        editMenu = new JMenu("�༭(E)");
	        editMenuCopy = new JMenuItem("����(C) Ctrl+C");
	        editMenuCut = new JMenuItem("����(T) Ctrl+X");
	        editMenuPaste = new JMenuItem("ճ��(P) Ctrl+v");
	         EMHandler EM=new EMHandler();   //����������
	        editMenuCopy.addActionListener(EM);//ע�������
	        editMenuCut.addActionListener(EM);
	        editMenuPaste.addActionListener(EM);
	        editMenu.add(editMenuCopy);
	        editMenu.add(editMenuCut);
	        editMenu.add(editMenuPaste);
	        editMenu.setFont(f);
	   
	        //��ʽ�˵���ʵ��
	        formatMenu = new JMenu("��ʽ(O)");            //�����˵�
	        formatSet = new JMenu("��ʽ����");          //�����˵�
	        lineWrap = new JMenuItem("�Զ�����");       //�����˵���
	        cancleLineWrap = new JMenuItem("ȡ���Զ�����");
	        wrapStyleWord = new JMenuItem("���в�����");
	        cancleWrapStyleWord = new JMenuItem("ȡ�����в�����");
	        FMHandler FM=new FMHandler();               //�����¼�������
	        lineWrap.addActionListener(FM);             //ע������˵���ļ�����
	        cancleLineWrap.addActionListener(FM);
	        wrapStyleWord.addActionListener(FM);
	        cancleWrapStyleWord.addActionListener(FM);
	        formatSet.add(lineWrap);
	        formatSet.add(cancleLineWrap);
	        formatSet.addSeparator();   //��ӷָ���
	        formatSet.add(wrapStyleWord);
	        formatSet.add(cancleWrapStyleWord);
	        formatMenu.add(formatSet);
	        formatMenu.setFont(f);
	  
	        //�����˵���ʵ��
	        helpMenu=new JMenu("����");
	        JMenuItem aboutMenuItem=new JMenuItem("����..",KeyEvent.VK_A);
	        JMenuItem exitMenuItem=new JMenuItem("�˳�",KeyEvent.VK_E);
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
	             
	        //���˵�ȫ����Ӳ˵�����
	        add(fileMenu);
	        add(editMenu);
	        add(formatMenu);
	        add(helpMenu);
		} 
	  	
		public JDialog get(){ 
			return aboutDialog;
		} 
		
		public void initAboutDialog(){ 
			aboutDialog.setTitle("����");
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
	            if(e.getSource()==editMenuCopy)     //ʵ�ָ��ƹ���
	            {
	                editor.copy();
	                editor.requestFocus();
	            }
	            else if(e.getSource()==editMenuCut)//ʵ�ּ��й���
	            {
	                editor.cut();
	                editor.requestFocus();
	            }
	            else                                //ʵ��ճ������
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
			JCheckBox checkBox=new JCheckBox("��ѡ��ť");
			JButton button=new JButton("���ļ�"); 
			button.setIcon(new ImageIcon("img/opensmall.jpg"));// Ϊ��ť����ͼ��
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JFileChooser file=new JFileChooser();
					int resule=file.showOpenDialog(new JPanel()); 
					if(resule==file.APPROVE_OPTION){
						String fileName=file.getSelectedFile().getName();
						String dir=file.getSelectedFile().getAbsolutePath(); 
						textField.setText(dir);
						JOptionPane.showConfirmDialog(null,dir,"ѡ����ļ�",JOptionPane.YES_OPTION);
					}
				} 
			}); 
			JToggleButton toggleButton=new JToggleButton("˫ɫ��ť");
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
			JRadioButton radioButton1=new JRadioButton("�������ѧ�뼼��",false);
			JRadioButton radioButton2=new JRadioButton("�������",false);
			JComboBox comboBox=new JComboBox(); 
			comboBox.addItem("����Ա");
			comboBox.addItem("����Ա");
			comboBox.setToolTipText("��������б�����ѡ��");
			comboBox.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent e){
					JComboBox comBox=(JComboBox)e.getSource(); 
				} 
			}); 
			DefaultListModel litem=new DefaultListModel();
			litem.addElement("��"); 
			litem.addElement("Ů");
			JList list=new JList(litem); 
			list.addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent e){
					JList l=(JList)e.getSource();
					Object s=l.getSelectedValue(); 
					JOptionPane.showMessageDialog(null,s,"��Ϣ��",JOptionPane.YES_OPTION);
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
			textField=new JTextField("�ı��򣬵��<���ļ�>��ť��ѡ���ļ�");
			textField.setActionCommand("textField");   
			JTabbedPane tab=new JTabbedPane(JTabbedPane.TOP);
			editor=new JTextArea(); 
			editor.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			editor.setText("�༭�������ŵ���ı��������������ָ�����"); 
			editor.addMouseListener(new MouseAdapter(){ 
				public void mousePressed(MouseEvent e){
					JTextPane textPane=(JTextPane)e.getSource();
					textPane.setText("�༭���������ɹ�"); 
				} 
			}); 
			JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,textField,editor); 
			JTable table=new JTable(10,10); 
			JPanel pane=new JPanel(); 
			pane.add(table.getTableHeader(),BorderLayout.NORTH);
			pane.add(table);
			tab.addTab("�ı���ʾ",splitPane); 
			tab.addTab("�����ʾ", pane);
			tab.setPreferredSize(new Dimension(500,400));
			this.add(tab);
			this.setEnabled(true); 
		}
	} 
	
public void loadFile()  //���ļ�����
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
          
    public void saveFile() { /*�����ļ��ķ���*/
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
