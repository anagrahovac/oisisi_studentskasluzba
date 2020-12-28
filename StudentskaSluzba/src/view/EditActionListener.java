package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int tab = MainFrame.getInstance().getActiveTab();
		if (tab == 0) {
			IzmenaStudentaDialog isd = new IzmenaStudentaDialog();
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
