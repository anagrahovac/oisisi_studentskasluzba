package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.BazaStudenata;

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
			
		}
		if (tab == 2) {
			//IzmenaPredmetaDialog ipd = new IzmenaPredmetaDialog();
			//ipd.setVisible(true);
		}
	}

}
