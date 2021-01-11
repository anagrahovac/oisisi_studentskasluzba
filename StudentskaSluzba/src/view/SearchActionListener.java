package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class SearchActionListener implements ActionListener {

	private MyToolbar t;
	private String trazenoPrezime;
	private String trazenoIme;
	
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
			String [] parts = s.split(" ");
			if (parts.length > 2) {
				JOptionPane.showMessageDialog(null, "Dozvoljen je unos najviše dve reči pri pretrazi profesora!\n prva - prezime, druga - ime");
			} else {
				trazenoPrezime = parts[0];
				if (parts.length == 2)
					trazenoIme = parts[1];
				
				RowFilter<Object, Object> profesorFilter = new RowFilter<Object, Object>(){
					public boolean include(RowFilter.Entry<?, ?> entry) {
						String ime = ((String) entry.getValue(0)).toLowerCase();
						String prezime = ((String) entry.getValue(1)).toLowerCase();
						if(prezime.length() == 0 || (sadrziIme(parts.length, ime) && sadrziPrezime(prezime))) 
							return true;
						else
							return false;
					}
				};
				
				TableRowSorter<AbstractTableModelProfesori> profesorRowSorter = new TableRowSorter<AbstractTableModelProfesori>();
				profesorRowSorter.setModel((AbstractTableModelProfesori) MainFrame.getInstance().getProfesoriTable().getModel());
				profesorRowSorter.setRowFilter(profesorFilter);
				MainFrame.getInstance().getProfesoriTable().setRowSorter(profesorRowSorter);
			}
		}
		
		if(tab == 2) {
			String trazeniNaziv = s;
			
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
			
			//u zakomentarisanom kodu omogucena pretraga samo jedne reci - sta ako zelimo pretragu po nazivu koji se sastoji iz vise reci?
			
			/*String [] parts = s.split(" ");
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
			}*/
			
		}
		
		
	}
	
	private boolean sadrziIme(int d, String i) {
		if (d == 1)
			return true;
		else 
			return i.contains(trazenoIme);
	}
	
	private boolean sadrziPrezime(String p) {
		return p.contains(trazenoPrezime);
	}

}
