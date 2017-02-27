package pane;

import javax.swing.JTable;

public class data_table extends JTable{
	public data_table(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}
	public boolean isCellEditable(int row, int column)
	{
	return false;//父类的方法里面是 return true的，所以就可以编辑了~~~
	}
}
