package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet.Semestar;
import model.Profesor;
import model.Student.Status;
import view.IzmenaPredmetaDialog;
import view.MainFrame;
import view.NoviPredmetDialog;

public class PredmetController {

	private NoviPredmetDialog npd;
	private IzmenaPredmetaDialog izmena;
	private Validacija val;
	
	public PredmetController(NoviPredmetDialog n) {
		this.npd = n;
		this.val = new Validacija();
	}
	
	public PredmetController(IzmenaPredmetaDialog i) {
		this.izmena = i;
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
	
	public boolean izmeniPredmet(int i) {
		String sifra = izmena.getpSifra().getTextField().getText();
		String naziv = izmena.getpNaziv().getTextField().getText();
		Semestar semestar = Semestar.LETNJI;
		switch(izmena.getpSemestar().getComboBox().getSelectedIndex()) {
		case 0:
			semestar = Semestar.LETNJI; 
			break;
		case 1:
			semestar = Semestar.ZIMSKI;
			break;
		}
		int godinaStudija = Integer.valueOf(izmena.getpGodinaStudija().getTextField().getText());
		Profesor profesor = new Profesor();
		int brESPB = Integer.valueOf(izmena.getpBrojESPB().getTextField().getText());
		
		String staraSifra = BazaPredmeta.getInstance().staraSifra();
		if((BazaPredmeta.getInstance().pronadjiPredmet1(sifra) != -1) && (BazaPredmeta.getInstance().pronadjiPredmet1(sifra) != i)) { 
			return false;
		}
			BazaPredmeta.getInstance().izmeniPredmet(staraSifra,sifra, naziv, semestar, godinaStudija, profesor, brESPB);
			MainFrame.getInstance().updatePredmetiTable();

			return true;
	}
	
	
}
