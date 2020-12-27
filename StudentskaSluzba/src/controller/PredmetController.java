package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.Predmet.Semestar;
import view.MainFrame;
import view.NoviPredmetDialog;

public class PredmetController {

	private NoviPredmetDialog npd;
	private Validacija val;
	
	public PredmetController(NoviPredmetDialog n) {
		this.npd = n;
		this.val = new Validacija();
	}

	public Validacija getVal() {
		return val;
	}

	public boolean dodajPredmet() {
		String sifra = npd.getpSifra().getTextField().getText();
		String naziv = npd.getpNaziv().getTextField().getText();
		Semestar semestar = Semestar.LETNJI;
		switch(npd.getpSemestar().getComboBox().getSelectedIndex()) {
		case 0:
			semestar = Semestar.LETNJI; 
			break;
		case 1:
			semestar = Semestar.ZIMSKI;
			break;
		}
		int godStudija = Integer.valueOf(npd.getpGodinaStudija().getTextField().getText());
		int brESPB = Integer.valueOf(npd.getpBrojESPB().getTextField().getText());

		if(BazaPredmeta.getInstance().pronadjiPredmet(sifra)) {
			JOptionPane.showMessageDialog(npd, "Šifra predmeta već postoji u bazi!");
			return false;
		}
			BazaPredmeta.getInstance().dodajPredmetUBazu(sifra, naziv, semestar, godStudija, null, brESPB);
			MainFrame.getInstance().updatePredmetiTable();
			JOptionPane.showMessageDialog(null, "Predmet uspešno dodat u bazu.");
			return true;
	}
	
	
}
