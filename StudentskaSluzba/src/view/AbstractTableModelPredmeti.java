package view;

import model.*;
import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	private static final long serialVersionUID = -2177631931847342087L;

	public AbstractTableModelPredmeti() {}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return  BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaPredmeta.getInstance().getValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}

}