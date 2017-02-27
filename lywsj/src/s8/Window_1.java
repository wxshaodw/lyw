package s8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class FgMenu extends JMenu{
	public FgMenu(String label){
		super(label);
	}
	public FgMenu(String label,int nAccelerator){
		super(label);
		setMnemonic(nAccelerator);
	}
}
class FgButton extends JButton{
	public FgButton(){
		super();
	}
	public FgButton(Icon icon){
		super(icon);
	}
	public FgButton(Icon icon,String strToolTipText){
		super(icon);
		setToolTipText(strToolTipText);
	}
	public FgButton(String text){
		super(text);
	}
	public FgButton(String text,Icon icon,String strToolTipText){
		super(text,icon);
		setToolTipText(strToolTipText);
	}
}
class JButtonHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		JOptionPane.showMessageDialog(null,"�����˰�ť\""+e.getActionCommand()+"\"",
	              "��ʾ", JOptionPane.INFORMATION_MESSAGE);
	}
}
class JButtonHandler_1 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.exit(0); 
	}
}
class JTMenu extends JFrame{
	static JMenuBar mb=new JMenuBar();
	static JToolBar mtb=new JToolBar();
	static JTextArea ta=new JTextArea();
	static FgMenu mFile =new FgMenu("�ļ���F��",KeyEvent.VK_F);
	static FgMenu mEdit =new FgMenu("�༭��E��",KeyEvent.VK_E);
	static JMenuItem miNew =new JMenuItem("�½���N��",KeyEvent.VK_N);
	static JMenuItem miOpen =new JMenuItem("�򿪣�O��",KeyEvent.VK_O);
	static JMenuItem miSave =new JMenuItem("���棨S��",KeyEvent.VK_S);
	static JMenuItem miQuit =new JMenuItem("�˳���Q��",KeyEvent.VK_Q);
	static JMenuItem miCopy =new JMenuItem("���ƣ�C��");
	static JMenuItem miPaste =new JMenuItem("ճ����V��");
	public JTMenu(String Stitle){
		super(Stitle);
		addMenu();
		addToolBar();
		addJPanel();
		centerWindow();
		Toolkit tk=getToolkit();
		Image icon=tk.getImage(getClass().getResource("to.jpg"));
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void addMenu(){
		setJMenuBar(mb);
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.addSeparator();
		mFile.add(miQuit);
		mEdit.add(miCopy);
		mEdit.add(miPaste);
		mb.add(mFile);
		mb.add(mEdit);
		miQuit.addActionListener(new JButtonHandler_1());
		miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
		miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_DOWN_MASK));
		setSize(640, 480);
	}
	 public void centerWindow(){
			Toolkit tk=mb.getToolkit();
			Dimension dm=tk.getScreenSize();
			setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
		}
	 public void addToolBar(){
		 Container c=getContentPane();
		 c.add(BorderLayout.NORTH,mtb);
		 mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		 FgButton [] btn = {new FgButton(new ImageIcon(getClass().getResource("new.jpg")),"�½��ļ�"),
					new FgButton(new ImageIcon(getClass().getResource("open.jpg")),"���ļ�"),
					new FgButton(new ImageIcon(getClass().getResource("save.jpg")),"�����ļ�"),
					new FgButton(new ImageIcon(getClass().getResource("copy.jpg")),"����"),
					new FgButton(new ImageIcon(getClass().getResource("paste.jpg")),"ճ��")
			};
			for(int i=0;i<btn.length;i++){
				mtb.add(btn[i]);
			}
			mtb.setFloatable(false);
	 }
	 public void addJPanel(){
		 JPanel p=new JPanel();
		 FgButton [] btn = {
					new FgButton(new ImageIcon(getClass().getResource("left.jpg"))),
					new FgButton("     "),
					new FgButton(new ImageIcon(getClass().getResource("right.jpg")))
			};
			for(int i=0;i<btn.length;i++){
				btn[i].setSize(20, 20);
				p.add(btn[i]);
			}
			btn[1].addActionListener(new JButtonHandler());
			JScrollPane sp=new JScrollPane(ta);
			JSplitPane sp_2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,p,sp);
			sp_2.setDividerSize(0);
			add(sp_2);
	 }
}
public class Window_1 {
	public static void main(String[] args) {
		JTMenu frm=new JTMenu("���������ģ���ӭʹ���ҿ��������");
		frm.setVisible(true);
		// TODO Auto-generated method stub

	}
}
