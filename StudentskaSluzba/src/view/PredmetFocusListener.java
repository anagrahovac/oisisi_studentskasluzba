package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class PredmetFocusListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();

		// polje prezime je obavezno za unos:
		if (txt.getName().equals("txtSifra") || txt.getName().equals("txtNaziv") || txt.getName().equals("txtGodinaStudija")
				||  txt.getName().equals("txtImeProfesor") ||  txt.getName().equals("txtPrezimeProfesor") ||  txt.getName().equals("txtBrojESPB")) {

			if (txt.getText().trim().equals("")) {
				//txt.setText("obavezno polje...");
				//txt.setForeground(new Color(221,119,119));
				txt.setBorder(new MatteBorder(1, 1, 1, 1, new Color(221,119,119)));
			} else {
				txt.setForeground(Color.BLACK);
				txt.setBorder(new MatteBorder(1, 1, 1, 1, Color.gray));
			}
		}
	}

}
