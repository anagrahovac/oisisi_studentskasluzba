package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import controller.Validacija;

public class ProfesorFocusListener implements FocusListener{
	private NoviProfesorDialog npd;
	
	public ProfesorFocusListener(NoviProfesorDialog n) {
		super();
		this.npd = n;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setForeground(Color.BLACK);
		txt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		if(npd.getController().getValidacija().validirajProfesora() == true) {
			npd.enablePotvrdi();
		}
	}


	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		String name = txt.getName();
		String tekst = txt.getText().trim();
		Validacija v = npd.getController().getValidacija();
		boolean ispravno = false;
		
		switch(name) {
		case "txtIme": 
			ispravno = v.validirajIme(tekst);break;
		case "txtPrezime":
			ispravno = v.validirajPrezime(tekst);break;
		case "txtDatum": 
			ispravno = v.validirajDatum(tekst);break;
		case "txtAdresaStan":
			ispravno = v.validirajAdresuStanovanja(tekst);break;
		case "txtTelefon": 
			ispravno = v.validirajTelefon(tekst);break;
		case "txtEmail":
			ispravno = v.validirajEmail(tekst);break;
		case "txtAdresaKancelarija": 
			ispravno = v.validirajAdresuKancelarije(tekst);break;
		case "txtID":
			ispravno = v.validirajBrojLicneKarte(tekst);break;
		}
		
		if (ispravno == false) {
			txt.setBorder(null);
			txt.setBorder(BorderFactory.createLineBorder(new Color(221,119,119)));
			txt.setForeground(new Color(221,119,119));
			npd.disablePotvrdi();
		}
		
		if(v.validirajProfesora() == true) {
			npd.enablePotvrdi();
		}
		else {
			npd.disablePotvrdi();
		}
	}
}
