package view;

import model.*;
import javax.swing.table.AbstractTableModel;

public class AbstractTableModelProfesori extends AbstractTableModel {

	private static final long serialVersionUID = 5464646286485340149L;

	public AbstractTableModelProfesori() {}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return  BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaProfesora.getInstance().getValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}
	
}