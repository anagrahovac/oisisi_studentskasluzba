package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import view.*;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class ProfesorController {
	private NoviProfesorDialog novi;
	private IzmenaProfesoraDialog izmena;
	private Validacija validacija;
	
	public ProfesorController() {
		this.izmena = null;
		this.novi = null;
		this.validacija = null;
	}
	
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
		Titula titula = Titula.DR;
		switch(novi.getpTitula().getComboBox().getSelectedIndex()) {
		case 0:
			titula = Titula.DR; break;
		case 1:
			titula = Titula.PROF_DR; break;	
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
		if(BazaProfesora.getInstance().pronadjiProfesora(id) != -1) {
			return false;
		}
		BazaProfesora.getInstance().dodajProfesoraUBazu(prezime, ime, datum, as, telefon, email, ak, id, titula, zvanje);
		MainFrame.getInstance().updateProfesoriTable();
		return true;
	}
	
	public boolean izmeniProfesora(int i) {
		String ime = izmena.getpIme().getTextField().getText();
		String prezime = izmena.getpPrezime().getTextField().getText();
		String d = izmena.getpDatum().getTextField().getText();
		LocalDate datum = null;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			datum = LocalDate.parse(d, dtf);
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Datum je nepostojeći!");
			return false;
		}
		String as = izmena.getpAdresaStan().getTextField().getText();
		String telefon = izmena.getpTelefon().getTextField().getText();
		String email = izmena.getpEmail().getTextField().getText();
		String ak = izmena.getpAdresaKancelarija().getTextField().getText();
		String id = izmena.getpID().getTextField().getText();
		Titula titula = Titula.DR;
		switch(izmena.getpTitula().getComboBox().getSelectedIndex()) {
		case 0:
			titula = Titula.DR; break;
		case 1:
			titula = Titula.PROF_DR; break;
		}
		
		Zvanje zvanje = Zvanje.DOCENT;
		switch(izmena.getpZvanje().getComboBox().getSelectedIndex()) {
		case 0:
			zvanje = Zvanje.DOCENT; break;
		case 1:
			zvanje = Zvanje.VANREDNI_PROFESOR; break;
		case 2:
			zvanje = Zvanje.REDOVNI_PROFESOR; break;
		}
		if((BazaProfesora.getInstance().pronadjiProfesora(id) != -1) && (BazaProfesora.getInstance().pronadjiProfesora(id) != i)) { //vec postoji prof sa novim brojem licne karte
			return false;
		}
		BazaProfesora.getInstance().izmeniProfesora(i, prezime, ime, datum, as, telefon, email, ak, id, titula, zvanje);
		MainFrame.getInstance().updateProfesoriTable();
		return true;
	}
	
	public void obrisiProfesora(String id) {
		int idd = BazaProfesora.getInstance().pronadjiProfesora(id);
			
		//for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
		//	if(BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte().equals(id)) {
		//		ArrayList<Predmet> predaje = BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta();
		//		for(int j = 0; i < predaje.size(); j++) {
		//			predaje.get(j).setPredmetniProfesor(null);
		//		}
		//	}
		//}
		
		for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
			if(i == idd) {
				for(int j = 0; j < BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().size(); j++) {
					BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().get(j).setPredmetniProfesor(null);
				}
			}
		}
	
		BazaProfesora.getInstance().izbrisiProfesora(idd);
		MainFrame.getInstance().updateProfesoriTable();
		
	}
	
	public ArrayList<Predmet> nadjiPredmeteBezProfesora() {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
		for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
			if(BazaPredmeta.getInstance().getPredmeti().get(i).getPredmetniProfesor() == null) {
				predmeti.add(BazaPredmeta.getInstance().getPredmeti().get(i));
				//System.out.println(i);
			}
		}
		return predmeti;
	}	
	
	public void dodajPredmetProfesoru(String id, String sifra) {
		int ip = BazaProfesora.getInstance().pronadjiProfesora(id);
		int is = BazaPredmeta.getInstance().pronadjiPredmet1(sifra);
		BazaProfesora.getInstance().getProfesori().get(ip).getSpisakPredmeta().add(BazaPredmeta.getInstance().getPredmeti().get(is));
		izmena.updatePredmetiProfesoraTable();
		BazaPredmeta.getInstance().getPredmeti().get(is).setPredmetniProfesor(BazaProfesora.getInstance().getProfesori().get(ip));
		MainFrame.getInstance().updatePredmetiTable();
	}
	
	
}