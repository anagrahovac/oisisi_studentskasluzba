package listeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import controller.Validacija;
import view.PolaganjeDialog;

public class OcenaKeyListener implements KeyListener {

	private PolaganjeDialog pd;
	
	public OcenaKeyListener(PolaganjeDialog n) {
		super();
		this.pd = n;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		String tekst = txt.getText().trim();
		boolean ispravno = false;
		Validacija v = new Validacija();
		ispravno = v.validirajDatum(tekst);
		
		if (ispravno == false) {
			txt.setBorder(BorderFactory.createLineBorder(new Color(221,119,119)));
			txt.setForeground(new Color(221,119,119));
			pd.disablePotvrdi();
		}
		else {
			txt.setForeground(Color.BLACK);
			txt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			pd.enablePotvrdi();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}