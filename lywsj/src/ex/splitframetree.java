package SwingTest;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

@SuppressWarnings("serial")
public class SplitFrameTree extends JFrame{

	private JSplitPane jSplitPane=new JSplitPane();//窗体分割线
	private JScrollPane jRightScrollPane=new JScrollPane();//右边切换panel
	private JScrollPane jLeftScrollPane=new JScrollPane();//左边放主Tree
	private JLabel jlRightDef= new JLabel();//右边默认界面
	public SplitFrameTree()
	{
		jSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		jSplitPane.setDividerLocation(170);//左边大小
		jSplitPane.setLeftComponent(jLeftScrollPane);
		jSplitPane.setRightComponent(jRightScrollPane);
		initMainJTree();
		this.add(jSplitPane);
		this.setSize(400,500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//初始化功能树
	private void initMainJTree()
	{
		JTree jTree=new JTree();
		jLeftScrollPane.setViewportView(new JPanel().add(jTree));
		jTree.setEditable(false);
		jTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				TreePath treePath=e.getNewLeadSelectionPath();//获得根节点到选着节点的路径
				DefaultMutableTreeNode node =  (DefaultMutableTreeNode) treePath.getLastPathComponent();
				jlRightDef.setText(node.toString());
				jRightScrollPane.setViewportView(jlRightDef);
			}
		});
	}	
	public static void main(String[]args)
	{
		try {//windows风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new SplitFrameTree();
	}
}