package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaStudenata;
import view.IzmenaPredmetaDialog;
import view.IzmenaProfesoraDialog;
import view.IzmenaStudentaDialog;
import view.MainFrame;

public class EditActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int tab = MainFrame.getInstance().getActiveTab();
		if (tab == 0) {
			String stariIndeks = BazaStudenata.getInstance().stariIndeks();
			if(stariIndeks.equals("")) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali studenta za izmenu!");
				return;
			}
			IzmenaStudentaDialog isd = new IzmenaStudentaDialog(stariIndeks);
			isd.setVisible(true);
			
			
		}
		if (tab == 1) {
			String id = MainFrame.getInstance().getProfesorID();
			if(id.equals("")) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali profesora kojeg zelite da izmenite!");
				return;
			}
			IzmenaProfesoraDialog ipd = new IzmenaProfesoraDialog(id);
			ipd.setVisible(true);
		}
		if (tab == 2) {
			String staraSifra = BazaPredmeta.getInstance().staraSifra();
			if( staraSifra.equals("")) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali predmet za izmenu!");
				return;
			}
			IzmenaPredmetaDialog ipd = new IzmenaPredmetaDialog(staraSifra);
			ipd.setVisible(true);
		}
	}

}
