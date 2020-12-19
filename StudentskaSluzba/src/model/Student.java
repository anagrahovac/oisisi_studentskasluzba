package model;

import java.util.ArrayList;

enum Status{B,S};	

public class Student {
	protected String prezimeStudenta;
	protected String imeStudenta;
	protected String datumRodjenja;
	protected String adresaStanovanja;
	protected String kontaktTelefon;
	protected String emailAdresa;
	protected String brojIndexa;
	protected int godinaUpisa;
	protected int trenutnaGodinaStudija;
	protected Status status;
	protected double prosecnaocena;
	//protected ArrayList<Ocena> spisakPolozenihIspita;
	//protected ArrayList<Ocena> spisakNepolozenihIspita;
	
	public Student() {}

	public Student(String prezimeStudenta, String imeStudenta, String datumRodjenja, String adresaStanovanja,
			String kontaktTelefon, String emailAdresa, String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija,
			Status status, double prosecnaocena) {
		super();
		this.prezimeStudenta = prezimeStudenta;
		this.imeStudenta = imeStudenta;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndexa = brojIndexa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosecnaocena = prosecnaocena;
	}

	@Override
	public String toString() {
		return "Student [prezimeStudenta=" + prezimeStudenta + ", imeStudenta=" + imeStudenta + ", datumRodjenja="
				+ datumRodjenja + ", adresaStanovanja=" + adresaStanovanja + ", kontaktTelefon=" + kontaktTelefon
				+ ", emailAdresa=" + emailAdresa + ", brojIndexa=" + brojIndexa + ", godinaUpisa=" + godinaUpisa
				+ ", trenutnaGodinaStudija=" + trenutnaGodinaStudija + ", status=" + status + ", prosecnaocena="
				+ prosecnaocena + "]";
	}

	public String getPrezimeStudenta() {
		return prezimeStudenta;
	}

	public void setPrezimeStudenta(String prezimeStudenta) {
		this.prezimeStudenta = prezimeStudenta;
	}

	public String getImeStudenta() {
		return imeStudenta;
	}

	public void setImeStudenta(String imeStudenta) {
		this.imeStudenta = imeStudenta;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
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

	public String getBrojIndexa() {
		return brojIndexa;
	}

	public void setBrojIndexa(String brojIndexa) {
		this.brojIndexa = brojIndexa;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsecnaocena() {
		return prosecnaocena;
	}

	public void setProsecnaocena(double prosecnaocena) {
		this.prosecnaocena = prosecnaocena;
	}
}
