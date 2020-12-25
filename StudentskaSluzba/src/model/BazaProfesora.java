package model;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class BazaProfesora {

	private static BazaProfesora instance = null;
	private ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;
	
	private BazaProfesora() {
		this.profesori = new ArrayList<Profesor>();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		
		//obrisati posle
		this.dodajProfesore();
	}
	
	//obrisati posle
	private void dodajProfesore() {
		//String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
				//String emailAdresa, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje
		Profesor p1, p2, p3, p4, p5;
		p1 = new Profesor("Petrović", "Pera", LocalDate.of(1975, 8, 10), "Leptirova 52, Novi Sad", "0635248789", "pera.petrovic@gmail.com",
				"Maksima Gorkog 56, Novi Sad", "008456251", Titula.DOKTOR, Zvanje.DOCENT);
		p2 = new Profesor("Marković", "Filip", LocalDate.of(1954, 2, 17), "Cara Lazara 78, Novi Sad", "0635248789", "filip_markovic@uns.acs.rs",
				"Stražilovska 44, Novi Sad", "007543541", Titula.DOKTOR, Zvanje.REDOVNI_PROFESOR);
		p3 = new Profesor("Vasiljević", "Jovan", LocalDate.of(1969, 3, 25), "Kralja Petra I, Novi Sad", "0635248789", "jvasiljevic@uns.acs.rs",
				"Stražilovska 46, Novi Sad", "008053452", Titula.DOKTOR, Zvanje.VANREDNI_PROFESOR);
		p4 = new Profesor("Blagojević", "Dušan", LocalDate.of(1980, 8, 16), "Pariska ulica 78, Beograd", "0665874454", "blagojevicd@hotmail.com",
				"Somborski Bulevar 13, Novi Sad", "007543541", Titula.DOKTOR, Zvanje.VANREDNI_PROFESOR);
		p5 = new Profesor("Vukašinović", "Aleksa", LocalDate.of(1976, 3, 1), "Futoški put 96, Novi Sad", "0635589979", "vuksa@gmail.com",
				"Zlatne grede 3, Novi Sad", "008651856", Titula.DOKTOR, Zvanje.DOCENT);
		this.profesori.add(p1);
		this.profesori.add(p2);
		this.profesori.add(p3);
		this.profesori.add(p4);
		this.profesori.add(p5);
	}
	
	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return this.kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			{
				if (profesor.getTitula() == Titula.DOKTOR)
					return "Doktor";
				return "";
			}
		case 3:
			{
				if (profesor.getZvanje() == Zvanje.DOCENT)
					return "Docent";
				if (profesor.getZvanje() == Zvanje.REDOVNI_PROFESOR)
					return "Redovni profesor";
				if (profesor.getZvanje() == Zvanje.VANREDNI_PROFESOR)
					return "Vanredni profesor";
				return "";
			}
		default:
			return null;
		}
	}
	
	public void dodajProfesoraUBazu(String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		Profesor p = new Profesor(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, adresaKancelarije, brojLicneKarte, titula, zvanje);
		this.profesori.add(p);
	}
	
	public boolean pronadjiProfesora(String id) {
		for(int i = 0; i < profesori.size(); i++) {
			if (profesori.get(i).getBrojLicneKarte().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	//prosledjuju se 
	public void izmeniProfesora(int i, String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		this.profesori.get(i).setPrezime(prezime);
		this.profesori.get(i).setIme(ime);
		this.profesori.get(i).setDatumRodjenja(datumRodjenja);
		this.profesori.get(i).setAdresaStanovanja(adresaStanovanja);
		this.profesori.get(i).setKontaktTelefon(kontaktTelefon);
		this.profesori.get(i).setEmailAdresa(emailAdresa);
		this.profesori.get(i).setAdresaKancelarije(adresaKancelarije);
		this.profesori.get(i).setBrojLicneKarte(brojLicneKarte);
		this.profesori.get(i).setTitula(titula);
		this.profesori.get(i).setZvanje(zvanje);
	}
	
	public void izbrisiProfesora(int i) {
		this.profesori.remove(i);
	}
	
}
