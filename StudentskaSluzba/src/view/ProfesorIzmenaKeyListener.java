package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import controller.Validacija;

public class ProfesorIzmenaKeyListener implements KeyListener {
	
	private IzmenaProfesoraDialog ipd;
	
	public ProfesorIzmenaKeyListener(IzmenaProfesoraDialog n) {
		super();
		this.ipd = n;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		String name = txt.getName();
		String tekst = txt.getText().trim();
		Validacija v = ipd.getController().getValidacija();
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
			txt.setBorder(BorderFactory.createLineBorder(new Color(221,119,119)));
			txt.setForeground(new Color(221,119,119));
			ipd.disablePotvrdi();
		}
		else {
			txt.setForeground(Color.BLACK);
			txt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
		
		if(v.validirajProfesora() == true) {
			ipd.enablePotvrdi();
		}
		else {
			ipd.disablePotvrdi();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}