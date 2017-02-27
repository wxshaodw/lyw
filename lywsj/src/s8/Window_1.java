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
		JOptionPane.showMessageDialog(null,"你点击了按钮\""+e.getActionCommand()+"\"",
	              "提示", JOptionPane.INFORMATION_MESSAGE);
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
	static FgMenu mFile =new FgMenu("文件（F）",KeyEvent.VK_F);
	static FgMenu mEdit =new FgMenu("编辑（E）",KeyEvent.VK_E);
	static JMenuItem miNew =new JMenuItem("新建（N）",KeyEvent.VK_N);
	static JMenuItem miOpen =new JMenuItem("打开（O）",KeyEvent.VK_O);
	static JMenuItem miSave =new JMenuItem("保存（S）",KeyEvent.VK_S);
	static JMenuItem miQuit =new JMenuItem("退出（Q）",KeyEvent.VK_Q);
	static JMenuItem miCopy =new JMenuItem("复制（C）");
	static JMenuItem miPaste =new JMenuItem("粘贴（V）");
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
		 FgButton [] btn = {new FgButton(new ImageIcon(getClass().getResource("new.jpg")),"新建文件"),
					new FgButton(new ImageIcon(getClass().getResource("open.jpg")),"打开文件"),
					new FgButton(new ImageIcon(getClass().getResource("save.jpg")),"保存文件"),
					new FgButton(new ImageIcon(getClass().getResource("copy.jpg")),"复制"),
					new FgButton(new ImageIcon(getClass().getResource("paste.jpg")),"粘贴")
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
		JTMenu frm=new JTMenu("我是梁烨文，欢迎使用我开发的软件");
		frm.setVisible(true);
		// TODO Auto-generated method stub

	}
}
