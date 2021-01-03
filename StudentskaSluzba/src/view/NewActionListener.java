package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BazaPredmeta;

public class NewActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int tab = MainFrame.getInstance().getActiveTab();
		if (tab == 0) {
			NoviStudentDialog nsd = new NoviStudentDialog();
			nsd.setVisible(true);
		}
		if (tab == 1) {
			NoviProfesorDialog npd = new NoviProfesorDialog();
			npd.setVisible(true);
		}
		if (tab == 2) {
			String staraSifra = BazaPredmeta.getInstance().staraSifra();
			NoviPredmetDialog npd = new NoviPredmetDialog(MainFrame.getInstance(),staraSifra);
			npd.setVisible(true);
		}
	} 

}
