package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel{
	
	public AbstractTableModelStudenti() {}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().getValueAt(row, col);
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnNames(column);
	}
}
