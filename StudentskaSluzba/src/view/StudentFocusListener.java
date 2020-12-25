package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import controller.Validacija;

public class StudentFocusListener implements FocusListener{
	
	private NoviStudentDialog nsd;

	public StudentFocusListener(NoviStudentDialog n) {
		super();
		this.nsd = n;
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
		txt.setForeground(Color.BLACK);
		txt.setBorder(new MatteBorder(1, 1, 1, 1, Color.gray));
		//if( nsd.getController().getValidacija().validirajStudenta() == true)
			//nsd.enablePotvrdi();
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		String val = txt.getText().trim();
		boolean validno = false;		
		
		switch(txt.getName()) {
		case "txtIme": 
			validno = nsd.getController().getValidacija().validirajIme(val);
			break;
		case "txtPrezime":
			validno = nsd.getController().getValidacija().validirajPrezime(val);
			break;
		case "txtDatumRodjenja": 
			validno = nsd.getController().getValidacija().validirajDatum(val);
			break;
		case "txtAdresaStanovanja":
			validno = nsd.getController().getValidacija().validirajAdresuStanovanja(val);
			break;
		case "txtBrojTelefona": 
			validno = nsd.getController().getValidacija().validirajTelefon(val);
			break;
		case "txtEMailAdresa":
			validno = nsd.getController().getValidacija().validirajEmail(val);
			break;
		case "txtBrojIndexa": 
			validno = nsd.getController().getValidacija().validirajBrojIndeksa(val);
			break;
		case "txtGodinaUpisa":
			validno = nsd.getController().getValidacija().validirajGodinuUpisa(val);
			break;
		}
		
		if (!validno) {
			txt.setBorder(null);
			txt.setBorder(BorderFactory.createLineBorder(new Color(221,119,119)));
			txt.setForeground(new Color(221,119,119));
			nsd.disablePotvrdi();
		}
		
		if(nsd.getController().getValidacija().validirajStudenta()) {
			nsd.enablePotvrdi();
		}
		else {
			nsd.disablePotvrdi();
		}		

	}

}
