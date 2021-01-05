package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaStudenata;

public class AbstractTableModelListaPredmeta extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private String indx;
	
	public AbstractTableModelListaPredmeta(String i) {
		// TODO Auto-generated constructor stub
		this.indx = i;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getColumnCountListaPredmeta();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(!(BazaStudenata.getInstance().studentDatogIndeksa(indx).getPredmetiZaDodavanje() == null)) 
			return BazaStudenata.getInstance().studentDatogIndeksa(indx).getPredmetiZaDodavanje().size();
		else 
			return -1;		
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().studentDatogIndeksa(indx).getValueAtListaPredmeta(arg0, arg1);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnNameListaPredmeta(column);
	}

}
