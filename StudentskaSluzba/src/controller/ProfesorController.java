package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import model.*;
import view.*;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class ProfesorController {
	private NoviProfesorDialog view;
	private Validacija validacija;
	
	public ProfesorController(NoviProfesorDialog v){
		this.view = v;
		this.validacija = new Validacija();
	}

	public Validacija getValidacija() {
		return validacija;
	}
	
	public boolean dodajProfesora() {
		String ime = view.getpIme().getTextField().getText();
		String prezime = view.getpPrezime().getTextField().getText();
		String d = view.getpDatum().getTextField().getText();
		LocalDate datum = null;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			datum = LocalDate.parse(d, dtf);
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Datum je nepostojeći!");
			return false;
		}
		String as = view.getpAdresaStan().getTextField().getText();
		String telefon = view.getpTelefon().getTextField().getText();
		String email = view.getpEmail().getTextField().getText();
		String ak = view.getpAdresaKancelarija().getTextField().getText();
		String id = view.getpID().getTextField().getText();
		Titula titula = Titula.DOKTOR;
		switch(view.getpTitula().getComboBox().getSelectedIndex()) {
		case 0:
			titula = Titula.DOKTOR; break;
		}
		Zvanje zvanje = Zvanje.DOCENT;
		switch(view.getpZvanje().getComboBox().getSelectedIndex()) {
		case 0:
			zvanje = Zvanje.DOCENT; break;
		case 1:
			zvanje = Zvanje.VANREDNI_PROFESOR; break;
		case 2:
			zvanje = Zvanje.REDOVNI_PROFESOR; break;
		}
		if(BazaProfesora.getInstance().pronadjiProfesora(id)) {
			return false;
		}
		BazaProfesora.getInstance().dodajProfesoraUBazu(prezime, ime, datum, as, telefon, email, ak, id, titula, zvanje);
		MainFrame.getInstance().updateProfesoriTable();
		return true;
	}
	
	
}