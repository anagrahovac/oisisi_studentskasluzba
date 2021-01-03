package model;

import java.util.ArrayList;

public class Predmet {
	public enum Semestar {LETNJI, ZIMSKI;}
	private String sifraPredmeta; 
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudija;
	private Profesor predmetniProfesor;
	private int brojBodova;
	private ArrayList<Student> poloziliPredmet;
	private ArrayList<Student> nisuPoloziliPredmet;
	
	public Predmet() {
		super();
		this.sifraPredmeta = null;
		this.nazivPredmeta = null;
		this.semestar = null;
		this.godinaStudija = 0;
		this.predmetniProfesor = null;
		this.brojBodova = 0;
		this.poloziliPredmet = new ArrayList<Student>();
		this.nisuPoloziliPredmet = new ArrayList<Student>();
	}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
			Profesor predmetniProfesor, int brojBodova) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.brojBodova = brojBodova;
		this.poloziliPredmet = new ArrayList<Student>();
		this.nisuPoloziliPredmet = new ArrayList<Student>();
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}
	
	public String getImePrezimeProfesora() {
		if(predmetniProfesor == null) 
			return "";
		return predmetniProfesor.getImePrezimeProfesora();
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public int getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(int brojBodova) {
		this.brojBodova = brojBodova;
	}
	

	public boolean dodajPoloziliPredmet(Student s) {
		for(int i = 0; i < poloziliPredmet.size(); i++) {
			if ((poloziliPredmet.get(i)).getBrojIndexa() == s.getBrojIndexa()) {
				return false;
			}
		}
		return poloziliPredmet.add(s);
	}
	////**************ODLUCI SE ZA JEDAN**************
	public boolean izbaciPoloziliPredmet(Student s) {
		for(int i = 0; i < poloziliPredmet.size(); i++) {
			if ((poloziliPredmet.get(i)).getBrojIndexa() == s.getBrojIndexa()) {
				return poloziliPredmet.remove(s);
			}
		}
		return false;
	}
	public Student izbaciIndeksPoloziliPredmet(String indeks) {
		for(int i = 0; i < poloziliPredmet.size(); i++) {
			if ((poloziliPredmet.get(i)).getBrojIndexa() == indeks) {
				poloziliPredmet.remove(poloziliPredmet.get(i));
				return poloziliPredmet.get(i);
			}
		}
		return null;
	}
	
	
	public boolean dodajNisuPoloziliPredmet(Student s) {
		for(int i = 0; i < nisuPoloziliPredmet.size(); i++) {
			if ((nisuPoloziliPredmet.get(i)).getBrojIndexa() == s.getBrojIndexa()) {
				return false;
			}
		}
		return nisuPoloziliPredmet.add(s);
	}
	//**************ODLUCI SE ZA JEDAN**************
	public boolean izbaciNisuPoloziliPredmet(Student s) {
		for(int i = 0; i < nisuPoloziliPredmet.size(); i++) {
			if ((nisuPoloziliPredmet.get(i)).getBrojIndexa() == s.getBrojIndexa()) {
				return nisuPoloziliPredmet.remove(s);
			}
		}
		return false;
	}
	public Student izbaciIndeksNisuPoloziliPredmet(String indeks) {
		for(int i = 0; i < nisuPoloziliPredmet.size(); i++) {
			if ((nisuPoloziliPredmet.get(i)).getBrojIndexa() == indeks) {
				nisuPoloziliPredmet.remove(nisuPoloziliPredmet.get(i));
				return nisuPoloziliPredmet.get(i);
			}
		}
		return null;
	}
	
	
	
}
