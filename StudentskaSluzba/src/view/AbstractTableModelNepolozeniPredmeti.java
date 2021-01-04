package view;

import javax.swing.table.AbstractTableModel;
import model.BazaStudenata;

public class AbstractTableModelNepolozeniPredmeti extends AbstractTableModel {

	private static final long serialVersionUID = -2177631931847342087L;
	private String id;
	
	public AbstractTableModelNepolozeniPredmeti(String id) {
		this.id = id;
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getNepolozeniColumnCount();
	}

	@Override
	public int getRowCount() {
		return  BazaStudenata.getInstance().getNepolozeniRowCount(id);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaStudenata.getInstance().getNepolozeniValueAt(row, column, id);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getNepolozeniColumnName(column);
	}
}