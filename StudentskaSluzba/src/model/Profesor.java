package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor {
	public enum Titula {DOKTOR;}
	public enum Zvanje {DOCENT, VANREDNI_PROFESOR, REDOVNI_PROFESOR;}
	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private Titula titula;
	private Zvanje zvanje;
	private ArrayList<Predmet> spisakPredmeta;
	
	public Profesor() {
		super();
		this.prezime = null;
		this.ime = null;
		this.datumRodjenja = null;
		this.adresaStanovanja = null;
		this.kontaktTelefon = null;
		this.emailAdresa = null;
		this.adresaKancelarije = null;
		this.brojLicneKarte = null;
		this.titula = null;
		this.zvanje = null;
		this.spisakPredmeta = new ArrayList<Predmet>();
	}
	
	public Profesor(String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.spisakPredmeta = new ArrayList<Predmet>();
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public Titula getTitula() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	
	
	public boolean dodajPoloziliPredmet(Predmet p) {
		for(int i = 0; i < spisakPredmeta.size(); i++) {
			if ((spisakPredmeta.get(i)).getSifraPredmeta() == p.getSifraPredmeta()) {
				return false;
			}
		}
		return spisakPredmeta.add(p);
	}
	//**************ODLUCI SE ZA JEDAN**************
	public boolean izbaciPoloziliPredmet(Predmet p) {
		for(int i = 0; i < spisakPredmeta.size(); i++) {
			if ((spisakPredmeta.get(i).getSifraPredmeta()) == p.getSifraPredmeta()) {
				return spisakPredmeta.remove(p);
			}
		}
		return false;
	}
	public Predmet izbaciIndeksPoloziliPredmet(String sifra) {
		for(int i = 0; i < spisakPredmeta.size(); i++) {
			if ((spisakPredmeta.get(i)).getSifraPredmeta() == sifra) {
				spisakPredmeta.remove(spisakPredmeta.get(i));
				return spisakPredmeta.get(i);
			}
		}
		return null;
	}
	
	
}
