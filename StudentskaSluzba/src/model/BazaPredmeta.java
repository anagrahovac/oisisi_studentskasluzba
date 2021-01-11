package model;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Predmet.Semestar;
import model.Profesor.Titula;
import model.Profesor.Zvanje;
import model.Student.Status;
import view.MainFrame;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	private ArrayList<Predmet> predmeti;
	private ArrayList<String> kolone;
	private ArrayList<String> kolonePS;
	
	private BazaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("ESPB bodovi");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
		this.kolonePS = new ArrayList<String>();
		this.kolonePS.add("Šifra");
		this.kolonePS.add("Naziv");
		
		//obrisati posle
		this.dodajPredmete();
	}
	
	//obrisati posle
	private void dodajPredmete() {
		//String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija, Profesor predmetniProfesor, int brojBodova
		Predmet p1, p2, p3, p4, p5;
		Profesor pp1, pp2, pp3, pp4, pp5;
		pp1 = new Profesor("Petrović", "Pera", LocalDate.of(1975, 8, 10), "Leptirova 52, Novi Sad", "0635248789", "pera.petrovic@gmail.com",
				"Maksima Gorkog 56, Novi Sad", "008456251", Titula.DOKTOR, Zvanje.DOCENT);
		pp2 = new Profesor("Marković", "Filip", LocalDate.of(1954, 2, 17), "Cara Lazara 78, Novi Sad", "0635248789", "filip_markovic@uns.acs.rs",
				"Stražilovska 44, Novi Sad", "007543541", Titula.DOKTOR, Zvanje.REDOVNI_PROFESOR);
		pp3 = new Profesor("Vasiljević", "Jovan", LocalDate.of(1969, 3, 25), "Kralja Petra I, Novi Sad", "0635248789", "jvasiljevic@uns.acs.rs",
				"Stražilovska 46, Novi Sad", "008053452", Titula.DOKTOR, Zvanje.VANREDNI_PROFESOR);
		pp4 = new Profesor("Blagojević", "Dušan", LocalDate.of(1980, 8, 16), "Pariska ulica 78, Beograd", "0665874454", "blagojevicd@hotmail.com",
				"Somborski Bulevar 13, Novi Sad", "007712971", Titula.DOKTOR, Zvanje.VANREDNI_PROFESOR);
		pp5 = new Profesor("Vukašinović", "Aleksa", LocalDate.of(1976, 3, 1), "Futoški put 96, Novi Sad", "0635589979", "vuksa@gmail.com",
				"Zlatne grede 3, Novi Sad", "008651856", Titula.DOKTOR, Zvanje.DOCENT);
		p1 = new Predmet("P012", "Algebra", Semestar.ZIMSKI, 1, null, 9);
		p2 = new Predmet("A805", "Objektno programiranje", Semestar.ZIMSKI, 2, pp1, 8);
		p3 = new Predmet("K156", "Arhitektura računara", Semestar.LETNJI, 1, null, 9);
		p4 = new Predmet("T488", "Osnovi elekrotehnike", Semestar.LETNJI, 1, pp5, 8);
		p5 = new Predmet("F137", "Baze podataka 1", Semestar.ZIMSKI, 3, pp3, 7);
		this.predmeti.add(p1);
		this.predmeti.add(p2);
		this.predmeti.add(p3);
		this.predmeti.add(p4);
		this.predmeti.add(p5);
		
	}
	
	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public ArrayList<String> getKolone() {
		return kolone;
	}

	public int getColumnCount() {
		return this.kolone.size();
	}
	
	public int getColumnCountListaPredmeta() {
		return this.kolonePS.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public String getColumnNameListaPredmeta(int index) {
		return this.kolonePS.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public Object getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
			case 0:
				return predmet.getSifraPredmeta();
			case 1:
				return predmet.getNazivPredmeta();
			case 2:
				return predmet.getBrojBodova();
			case 3:
				return predmet.getGodinaStudija();
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
	
	public void dodajPredmetUBazu(String sifra, String naziv, Semestar semestar, int godStudija, Profesor predProfesor, int brESPB) {
		Predmet p = new Predmet(sifra, naziv, semestar, godStudija, predProfesor, brESPB);
		this.predmeti.add(p);
	}
	
	public boolean pronadjiPredmet(String sifra) {
		for(int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getSifraPredmeta().equals(sifra)) {
				return true;
			}
		}
		return false;
	}
	
	public int pronadjiPredmet1(String sifra) {
		for(int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getSifraPredmeta().equals(sifra)) {
				return i;
			}
		}
		return -1;
	}
	
	public String staraSifra() {
		int row = MainFrame.getInstance().getPredmetiTable().getSelectedRow();
		
		if(row != -1)
			return (String) MainFrame.getInstance().getPredmetiTable().getValueAt(row, 0);
		else
			return "";
		
	}
	
	public Predmet predmetDateSifre(String sfr) {
		Predmet p = new Predmet();
		for(int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getSifraPredmeta().equals(sfr)) {
				return predmeti.get(i);
			}
		}
		return p;
	}
	
	public void izmeniPredmet(String staraSifra,String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija, int brojBodova) {
		for(int i = 0; i < predmeti.size(); i++) {
			if(predmeti.get(i).getSifraPredmeta().equals(staraSifra)) {
				this.predmeti.get(i).setSifraPredmeta(sifraPredmeta);
				this.predmeti.get(i).setNazivPredmeta(nazivPredmeta);
				this.predmeti.get(i).setSemestar(semestar);
				this.predmeti.get(i).setGodinaStudija(godinaStudija);
				this.predmeti.get(i).setBrojBodova(brojBodova);
			}
		}
	}
	
	public void izbrisiPredmet(int i) {
		this.predmeti.remove(i);
	}
}
