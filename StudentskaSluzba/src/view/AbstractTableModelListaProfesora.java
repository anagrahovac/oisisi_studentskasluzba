package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelListaProfesora extends AbstractTableModel{

	private static final long serialVersionUID = 5113911347261753838L;

	public AbstractTableModelListaProfesora() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getColumnCountListaProfesora();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getProfesori().size();

	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getValueAtListaProfesora(arg0, arg1);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnNameListaProfesora(column);
	}

}
