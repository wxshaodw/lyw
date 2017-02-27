package SwingTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class JListDemo implements ListSelectionListener {
    JList list = null;
    JLabel label = null;
    String[] s = { "����", "�й�", "Ӣ��", "����", "�����", "����", "����" };
    public JListDemo() {
        JFrame f = new JFrame("JList");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new BorderLayout());
        label = new JLabel();
        list = new JList(s);
        list.setVisibleRowCount(5); // �趨�б���Ŀɼ�����
        list.setBorder(BorderFactory.createTitledBorder("����ϲ�����ĸ��������أ�"));
        list.addListSelectionListener(this);
        contentPane.add(label, BorderLayout.NORTH);
        // ���б�����ӹ�����
        contentPane.add(new JScrollPane(list), BorderLayout.CENTER);
        f.setSize(300, 200);
        //f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void valueChanged(ListSelectionEvent e) {
        int tmp = 0;
        String stmp = "��Ŀǰѡȡ��";
        //����JList�����ṩ��getSelectedIndices()�����ɵõ��û���ѡȡ��������Ŀ
        int[] index = list.getSelectedIndices();
        //indexֵ����Щindexֵ��һ��int array����.
        for (int i = 0; i < index.length; i++){
        	tmp = index[i];
            stmp = stmp + s[tmp] + "  ";
        }
        label.setText(stmp);
    }
    public static void main(String args[]) {
        new JListDemo();
    }
}
