package listeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import view.NoviStudentDialog;

public class StudentKeyListener implements KeyListener{

	private NoviStudentDialog nsd;
	
	public StudentKeyListener (NoviStudentDialog n) {
		super();
		this.nsd = n;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) e.getComponent();
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
		} else {
			txt.setForeground(Color.black);
			txt.setBorder(BorderFactory.createLineBorder(Color.gray));
		}
		
		if(nsd.getController().getValidacija().validirajStudenta()) {
			nsd.enablePotvrdi();
		}
		else {
			nsd.disablePotvrdi();
		}		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
