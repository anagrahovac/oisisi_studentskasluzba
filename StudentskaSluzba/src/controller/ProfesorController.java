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
	private NoviProfesorDialog novi;
	private IzmenaProfesoraDialog izmena;
	private Validacija validacija;
	
	public ProfesorController(NoviProfesorDialog v){
		this.novi = v;
		this.validacija = new Validacija();
	}
	
	public ProfesorController(IzmenaProfesoraDialog v){
		this.izmena = v;
		this.validacija = new Validacija();
	}

	public Validacija getValidacija() {
		return validacija;
	}
	
	public boolean dodajProfesora() {
		String ime = novi.getpIme().getTextField().getText();
		String prezime = novi.getpPrezime().getTextField().getText();
		String d = novi.getpDatum().getTextField().getText();
		LocalDate datum = null;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			datum = LocalDate.parse(d, dtf);
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Datum je nepostojeći!");
			return false;
		}
		String as = novi.getpAdresaStan().getTextField().getText();
		String telefon = novi.getpTelefon().getTextField().getText();
		String email = novi.getpEmail().getTextField().getText();
		String ak = novi.getpAdresaKancelarija().getTextField().getText();
		String id = novi.getpID().getTextField().getText();
		Titula titula = Titula.DOKTOR;
		switch(novi.getpTitula().getComboBox().getSelectedIndex()) {
		case 0:
			titula = Titula.DOKTOR; break;
		}
		Zvanje zvanje = Zvanje.DOCENT;
		switch(novi.getpZvanje().getComboBox().getSelectedIndex()) {
		case 0:
			zvanje = Zvanje.DOCENT; break;
		case 1:
			zvanje = Zvanje.VANREDNI_PROFESOR; break;
		case 2:
			zvanje = Zvanje.REDOVNI_PROFESOR; break;
		}
		if(BazaProfesora.getInstance().pronadjiProfesora(id) != null) {
			return false;
		}
		BazaProfesora.getInstance().dodajProfesoraUBazu(prezime, ime, datum, as, telefon, email, ak, id, titula, zvanje);
		MainFrame.getInstance().updateProfesoriTable();
		return true;
	}
	
	
}