package pane;

import javax.swing.JTable;

public class data_table extends JTable{
	public data_table(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}
	public boolean isCellEditable(int row, int column)
	{
	return false;//����ķ��������� return true�ģ����ԾͿ��Ա༭��~~~
	}
}
