package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			//otvori dijalog za dodavanje predmeta
		}
	} 

}
