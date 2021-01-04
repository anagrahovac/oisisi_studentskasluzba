package view;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PretragaStudenta {
	
	private TableStudenti tabela;
	
	public PretragaStudenta() {
		this.tabela = new TableStudenti();
	}
	
	public void pretraga(String stringUnos) {
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>();
		tabela.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(stringUnos));
	}
	
	public void filter() {
		String tekst = MyToolbar.getSearchBox().getText();
		pretraga(tekst);
		
	}

}
