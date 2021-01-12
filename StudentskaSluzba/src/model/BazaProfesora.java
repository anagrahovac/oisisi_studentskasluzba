package model;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Predmet.Semestar;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class BazaProfesora {

	private static BazaProfesora instance = null;
	private ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;
	private ArrayList<String> koloneP;
	
	private BazaProfesora() {
		this.profesori = new ArrayList<Profesor>();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Broj lične karte");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		
		this.koloneP = new ArrayList<String>();
		this.koloneP.add("Profesor");
		this.koloneP.add("Broj lične karte");
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

	public int getColumnCountListaProfesora() {
		return 2;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public String getColumnNameListaProfesora(int index) {
		return this.koloneP.get(index);
	}

	public String getKoloneP(int index) {
		return this.koloneP.get(index);
	}

	public void setKoloneP(ArrayList<String> koloneP) {
		this.koloneP = koloneP;
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
			return profesor.getBrojLicneKarte();
		case 3:
			{
				if (profesor.getTitula() == Titula.DR)
					return "Doktor";
				if (profesor.getTitula() == Titula.PROF_DR)
					return "Profesor doktor";
				return "";
			}
		case 4:
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
	
	public String getValueAtListaProfesora(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getImePrezimeProfesora();
		case 1:
			return profesor.getBrojLicneKarte();
		default:
			return null;
		}
	}
	
	public void dodajProfesoraUBazu(String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		Profesor p = new Profesor(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, adresaKancelarije, brojLicneKarte, titula, zvanje);
		this.profesori.add(p);
	}
	
	public Profesor pronadjiProfesora1(String id) {
		for(int i = 0; i < profesori.size(); i++) {
			if (profesori.get(i).getBrojLicneKarte().equals(id)) {
				return profesori.get(i);
			}
		}
		return null;
	}
	
	public int pronadjiProfesora(String id) {
		for(int i = 0; i < profesori.size(); i++) {
			if (profesori.get(i).getBrojLicneKarte().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public Profesor profesorDateLicneKarte(String id) {
		for(int i = 0; i < profesori.size(); i++) {
			if (profesori.get(i).getBrojLicneKarte().equals(id)) {
				return profesori.get(i);
			}
		}
		return null;
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
	
	//za tabelu predmeta
	public int getPredmetiColumnCount() {
		return BazaPredmeta.getInstance().getKolone().size();
	}
	public int getPredmetiRowCount(String id) {
		int i = this.pronadjiProfesora(id);
		return this.profesori.get(i).getSpisakPredmeta().size();
	}
	public String getPredmetiColumnName(int index) {
		return BazaPredmeta.getInstance().getKolone().get(index);
	}
	public Predmet getPredmetiRow(int rowIndex, String id) {
		int i = this.pronadjiProfesora(id);
		return this.profesori.get(i).getSpisakPredmeta().get(rowIndex);
	}
	public String getPredmetiValueAt(int row, int column, String id) {
		int i = this.pronadjiProfesora(id);
		Predmet predmet = this.profesori.get(i).getSpisakPredmeta().get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getBrojBodova());
		case 3:
			return Integer.toString(predmet.getGodinaStudija());
		case 4:
			{
				if (predmet.getSemestar() == Semestar.LETNJI)
					return "Letnji";
				if (predmet.getSemestar() == Semestar.ZIMSKI)
					return "Zimski";
				return "";
			}
		default:
			return null;
		}
	}
	
}
