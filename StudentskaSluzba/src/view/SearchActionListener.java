package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class SearchActionListener implements ActionListener {

	private MyToolbar t;
	public SearchActionListener(MyToolbar t) {
		super();
		this.t = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String s = t.getEntry().toLowerCase();
		s = s.trim();
		
		int tab = MainFrame.getInstance().getActiveTab();
		
		if(tab == 0) {
			
		}
		
		if(tab == 1) {
			
		}
		
		if(tab == 2) {
			String [] parts = s.split(" ");
			if (parts.length > 1) {
				JOptionPane.showMessageDialog(null, "Dozvoljen je unos najviše jedne reči pri pretrazi predmeta!");
			} else {
				String trazeniNaziv = parts[0];
				
				RowFilter<Object, Object> predmetFilter = new RowFilter<Object, Object>(){
					public boolean include(RowFilter.Entry<?, ?> entry) {
						String naziv = ((String) entry.getValue(1)).toLowerCase();
						if(trazeniNaziv.length() == 0 || naziv.contains(trazeniNaziv)) 
							return true;
						else
							return false;
					}
				};
				
				TableRowSorter<AbstractTableModelPredmeti> predmetRowSorter = new TableRowSorter<AbstractTableModelPredmeti>();
				predmetRowSorter.setModel((AbstractTableModelPredmeti) MainFrame.getInstance().getPredmetiTable().getModel());
				predmetRowSorter.setRowFilter(predmetFilter);
				MainFrame.getInstance().getPredmetiTable().setRowSorter(predmetRowSorter);
			}
		}
		
		
		
	}

}
