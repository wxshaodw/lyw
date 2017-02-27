package SwingTest;
//把页面分成四部份，就是上，中，左下，右下
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
upPanel.setBorder(new TitledBorder("上"));
centerPanel = new JPanel();
centerPanel.setBorder(new TitledBorder("中"));
downPanel = new JPanel();
ldPanel = new JPanel();
ldPanel.setBorder(new TitledBorder("左下"));
rdPanel = new JPanel();
rdPanel.setBorder(new TitledBorder("右下"));
downPanel.setLayout(new GridLayout(1, 2));
downPanel.add(ldPanel);
downPanel.add(rdPanel);
}
public static void main(String[] args) {
new SplitPanelFour();
}
}