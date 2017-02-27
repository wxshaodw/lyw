package SwingTest;
//��ҳ��ֳ��Ĳ��ݣ������ϣ��У����£�����
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class SplitPanelFour extends JFrame{
private static int Width = 400;
private static int Height = 400;
private JPanel upPanel, centerPanel, downPanel, ldPanel, rdPanel;
SplitPanelFour() {
init();
Container c = getContentPane();
c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
c.add(upPanel);
c.add(centerPanel);
c.add(downPanel);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(200, 200, Width, Height);
setVisible(true);
}
void init() {
upPanel = new JPanel();
upPanel.setBorder(new TitledBorder("��"));
centerPanel = new JPanel();
centerPanel.setBorder(new TitledBorder("��"));
downPanel = new JPanel();
ldPanel = new JPanel();
ldPanel.setBorder(new TitledBorder("����"));
rdPanel = new JPanel();
rdPanel.setBorder(new TitledBorder("����"));
downPanel.setLayout(new GridLayout(1, 2));
downPanel.add(ldPanel);
downPanel.add(rdPanel);
}
public static void main(String[] args) {
new SplitPanelFour();
}
}