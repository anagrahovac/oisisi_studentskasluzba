package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class AbstractTableModelPolozeniIspiti extends AbstractTableModel{
	
	private String indx;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return BazaStudenata.getInstance().getColumnCountPolozeni();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().studentDatogIndeksa(indx).getSpisakPolozenihIspita().size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().studentDatogIndeksa(indx).getValueAtPolozeni(arg0, arg1);
	}
	
	@Override
	public String getColumnName(int arg0) {
		return BazaStudenata.getInstance().getColumnNamesPolozeni(arg0);
	}

}
