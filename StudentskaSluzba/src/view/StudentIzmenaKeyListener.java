package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class StudentIzmenaKeyListener implements KeyListener{
	
	private IzmenaStudentaDialog isd;
	
	public StudentIzmenaKeyListener (IzmenaStudentaDialog n) {
		super();
		this.isd = n;
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
			validno = isd.getController().getValidacija().validirajIme(val);
			break;
		case "txtPrezime":
			validno = isd.getController().getValidacija().validirajPrezime(val);
			break;
		case "txtDatumRodjenja": 
			validno = isd.getController().getValidacija().validirajDatum(val);
			break;
		case "txtAdresaStanovanja":
			validno = isd.getController().getValidacija().validirajAdresuStanovanja(val);
			break;
		case "txtBrojTelefona": 
			validno = isd.getController().getValidacija().validirajTelefon(val);
			break;
		case "txtEMailAdresa":
			validno = isd.getController().getValidacija().validirajEmail(val);
			break;
		case "txtBrojIndexa": 
			validno = isd.getController().getValidacija().validirajBrojIndeksa(val);
			break;
		case "txtGodinaUpisa":
			validno = isd.getController().getValidacija().validirajGodinuUpisa(val);
			break;
		}
		
		if (!validno) {
			isd.disablePotvrdi();
			txt.setBorder(null);
			txt.setBorder(BorderFactory.createLineBorder(new Color(221,119,119)));
			txt.setForeground(new Color(221,119,119));
		} else {
			isd.enablePotvrdi();			
			txt.setForeground(Color.black);
			txt.setBorder(BorderFactory.createLineBorder(Color.gray));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
