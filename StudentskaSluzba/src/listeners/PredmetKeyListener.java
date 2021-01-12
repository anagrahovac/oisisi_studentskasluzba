package listeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import view.NoviPredmetDialog;

public class PredmetKeyListener implements KeyListener{
	
	private NoviPredmetDialog npd;
	
	public PredmetKeyListener(NoviPredmetDialog n) {
		// TODO Auto-generated constructor stub
		super();
		this.npd = n;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		String val = txt.getText().trim();
		boolean validno = false;		
		
		switch(txt.getName()) {
		case "txtSifra": 
			validno = npd.getController().getVal().validirajSifru(val);
			break;
		case "txtNaziv":
			validno = npd.getController().getVal().validirajNaziv(val);
			break;
		case "txtGodinaStudija": 
			validno = npd.getController().getVal().validirajGodinuStudija(val);
			break;
		case "txtBrojESPB":
			validno = npd.getController().getVal().validirajBrojESPB(val);
			break;
		}
		
		if (!validno) {
			txt.setBorder(null);
			txt.setBorder(BorderFactory.createLineBorder(new Color(221,119,119)));
			txt.setForeground(new Color(221,119,119));
			npd.disablePotvrdi();
		} else {
			txt.setForeground(Color.black);
			txt.setBorder(BorderFactory.createLineBorder(Color.gray));
		}
		
		if(npd.getController().getVal().validirajPredmet()) {
			npd.enablePotvrdi();
		}
		else {
			npd.disablePotvrdi();
		}		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
