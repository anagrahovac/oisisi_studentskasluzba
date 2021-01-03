package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.BazaProfesora;
import model.BazaStudenata;

public class DeleteActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int tab = MainFrame.getInstance().getActiveTab();
		if (tab == 0) {
			int i = MainFrame.getInstance().getStudentiTable().getSelectedRow();
			if(i == -1) {
				JOptionPane.showMessageDialog(null, "Niste selektovali studenta koga želite da obrišete.");
				return;
			} else {
				Object[] daNe = {"Da", "Ne"};
				int code = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da obrišete studenta?",
						"Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, daNe, daNe[0]);
				if (code != JOptionPane.YES_OPTION) {
					
				} else {
					BazaStudenata.getInstance().izbrisiStudenta(i);
					MainFrame.getInstance().updateStudentiTable();
					JOptionPane.showMessageDialog(null, "Student obrisan iz baze.");
				}
			}
		}
		if (tab == 1) {	
			int i = MainFrame.getInstance().getProfesoriTable().getSelectedRow();
			if(i == -1) {
				JOptionPane.showMessageDialog(null, "Niste selektovali profesora koga želite da obrišete.");
				return;
			} else {
				Object[] daNe = {"Da", "Ne"};
				int code = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da obrišete profesora?",
						"Brisanje profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, daNe, daNe[0]);
				if (code != JOptionPane.YES_OPTION) {
					
				} else {
					BazaProfesora.getInstance().izbrisiProfesora(i);
					MainFrame.getInstance().updateProfesoriTable();
					JOptionPane.showMessageDialog(null, "Profesor obrisan iz baze.");
				}
			}
		}
		
		if(tab == 2) {
			
		}
	}

}
