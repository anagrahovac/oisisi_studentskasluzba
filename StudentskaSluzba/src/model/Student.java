package model;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Student.Status;

public class Student {
	public enum Status {B,S;}
	private String prezimeStudenta;
	private String imeStudenta;
	private LocalDate datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndexa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private Status status;
	private double prosecnaocena;
	private ArrayList<Ocena> spisakPolozenihIspita;
	private ArrayList<Ocena> spisakNepolozenihIspita;
	
	public Student() {
		super();
		this.prezimeStudenta = null;
		this.imeStudenta = null;
		this.datumRodjenja = null;
		this.adresaStanovanja = null;
		this.kontaktTelefon = null;
		this.emailAdresa = null;
		this.brojIndexa = null;
		this.godinaUpisa = 0;
		this.trenutnaGodinaStudija = 0;
		this.status = null;
		this.prosecnaocena = 0;
		this.spisakPolozenihIspita = new ArrayList<Ocena>();
		this.spisakNepolozenihIspita = new ArrayList<Ocena>();
	}

	public Student(String prezimeStudenta, String imeStudenta, LocalDate datumRodjenja, String adresaStanovanja,
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
		this.spisakPolozenihIspita = new ArrayList<Ocena>();
		this.spisakNepolozenihIspita = new ArrayList<Ocena>();
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

	public ArrayList<Ocena> getSpisakPolozenihIspita() {
		return spisakPolozenihIspita;
	}
	
	
	public String getValueAtPolozeni(int row, int column) {
		// TODO Auto-generated method stub
		Ocena o = this.getSpisakPolozenihIspita().get(row);
		String retVal = null;
		
		switch(column) {
		case 0:
			retVal = o.getPredmet().getSifraPredmeta();
			break;
		case 1:
			retVal = o.getPredmet().getNazivPredmeta();
			break;
		case 2:
			retVal = Integer.toString(o.getPredmet().getBrojBodova());
			break;
		case 3:
			retVal = Integer.toString(o.getOcena());
			break;
		case 4:
			retVal = o.getDatumPolaganjaispita();
		default:
			throw new IllegalArgumentException("Invalid column index");
		}
		
		return retVal;
	}
	
	public int prosecnaOcena() {
		int prosek = 0;
		if(spisakPolozenihIspita.size() != 0) {
		for(int i = 0; i < spisakPolozenihIspita.size(); i ++) {
			prosek += spisakPolozenihIspita.get(i).getOcena(); 
		}
		prosek = prosek / spisakPolozenihIspita.size();
		} else {
			return 0;
		}
		return prosek;
	}
	
	public int ukupnoESPB() {
		int espb = 0;
		if(spisakPolozenihIspita.size() != 0) {
		for(int i = 0; i < spisakPolozenihIspita.size(); i++) {
			espb += spisakPolozenihIspita.get(i).getPredmet().getBrojBodova();
		}} else {
			return 0;
		}
		
		return espb;
	}

	public void setSpisakPolozenihIspita(ArrayList<Ocena> spisakPolozenihIspita) {
		this.spisakPolozenihIspita = spisakPolozenihIspita;
	}

	public ArrayList<Ocena> getSpisakNepolozenihIspita() {
		return spisakNepolozenihIspita;
	}

	public void setSpisakNepolozenihIspita(ArrayList<Ocena> spisakNepolozenihIspita) {
		this.spisakNepolozenihIspita = spisakNepolozenihIspita;
	}
}
