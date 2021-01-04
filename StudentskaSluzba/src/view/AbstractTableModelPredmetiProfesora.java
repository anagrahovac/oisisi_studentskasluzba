package view;

import model.*;
import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmetiProfesora extends AbstractTableModel {

	private static final long serialVersionUID = -2177631931847342087L;
	private String id;
	
	public AbstractTableModelPredmetiProfesora(String id) {
		this.id = id;
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getPredmetiColumnCount();
	}

	@Override
	public int getRowCount() {
		return  BazaProfesora.getInstance().getPredmetiRowCount(id);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaProfesora.getInstance().getPredmetiValueAt(row, column, id);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getPredmetiColumnName(column);
	}
}
