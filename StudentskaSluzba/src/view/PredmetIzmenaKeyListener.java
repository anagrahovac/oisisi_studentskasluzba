package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class PredmetIzmenaKeyListener implements KeyListener{
	
	private IzmenaPredmetaDialog ipd;
	
	public PredmetIzmenaKeyListener(IzmenaPredmetaDialog i) {
		super();
		this.ipd = i;
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
		case "txtSifra": 
			validno = ipd.getController().getVal().validirajSifru(val);
			break;
		case "txtNaziv":
			validno = ipd.getController().getVal().validirajNaziv(val);
			break;
		case "txtGodinaStudija": 
			validno = ipd.getController().getVal().validirajGodinuStudija(val);
			break;
		case "txtBrojESPB":
			validno = ipd.getController().getVal().validirajBrojESPB(val);
			break;
		}
		
		if (!validno) {
			ipd.disablePotvrdi();		
			txt.setBorder(null);
			txt.setBorder(BorderFactory.createLineBorder(new Color(221,119,119)));
			txt.setForeground(new Color(221,119,119));
		} else {
			ipd.enablePotvrdi();			
			txt.setForeground(Color.black);
			txt.setBorder(BorderFactory.createLineBorder(Color.gray));
		}	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
