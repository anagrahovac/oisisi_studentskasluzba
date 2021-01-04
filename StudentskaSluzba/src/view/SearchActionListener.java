package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int tab = MainFrame.getInstance().getActiveTab();
		if(tab == 0) {
			PretragaStudenta ps = new PretragaStudenta();
			ps.filter();
		}
		
		if(tab == 1) {
			
		}
		
		if(tab == 2) {
			
		}
	}

}
