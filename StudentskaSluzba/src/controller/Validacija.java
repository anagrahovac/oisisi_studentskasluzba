package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Validacija {
	private boolean ime = false;
	private boolean prezime = false;
	private boolean datum = false;
	private boolean adresaStan = false;
	private boolean telefon = false;
	private boolean email = false;
	private boolean indeks = false;
	private boolean godinaUpisa = false;
	private boolean adresaKancelarija = false;
	private boolean brojLicne = false;
	
	public Validacija() {
		ime = false;
		prezime = false;
		datum = false;
		adresaStan = false;
		telefon = false;
		email = false;
		indeks = false;
		godinaUpisa = false;
		adresaKancelarija = false;
		brojLicne = false;
	}
	
	public boolean validirajStudenta() {
		if(ime == true && prezime == true && datum == true && adresaStan == true && telefon == true && email == true &&
				indeks == true && godinaUpisa == true) {
			return true;
		}
		return false;
	}
	
	public boolean validirajProfesora() {
		if(ime == true && prezime == true && datum == true && adresaStan == true && telefon == true && email == true &&
				adresaKancelarija == true && brojLicne == true) {
			return true;
		}
		return false;
	}
	
	public boolean validirajIme(String str) {
		if((str.equals("") || str == null))
			this.ime = false;
		else 
			this.ime = Pattern.matches("([A-ZŠĐŽČĆ]([a-zšđžčć]+)?| ?)+", str);
		
		return this.ime;
	}
	
	public boolean validirajPrezime(String str) {
		if((str.equals("") || str == null))
			this.prezime = false;
		else 
			this.prezime = Pattern.matches("([A-ZŠĐŽČĆ]([a-zšđžčć]+)?| ?)+", str);
		
		return this.prezime;
	}
	
	public boolean validirajDatum(String str) {
		if((str.equals("") || str == null)) {
			this.datum = false;
			return false;
		}
		this.datum = Pattern.matches("((0[1-9]|[12][0-9])|(3[01]))\\.((0[1-9])|(1[0-2]))\\.((19[0-9][0-9])|(20[01][0-9])|(2020))\\.", str);
		try {
			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			final LocalDate datum = LocalDate.parse(str, dtf);
		}
		catch(DateTimeParseException e) {
			this.datum = false;
			return false;
		}
		return this.datum;
	}

	public boolean validirajAdresuStanovanja(String str) {
		if((str.equals("") || str == null))
			this.adresaStan = false;
		else
			this.adresaStan = Pattern.matches("([0-9]+|[A-ZŠĐŽČĆa-zšđžčć][a-zšđžčć]+| ?|,?)+", str);
		return this.adresaStan;
	}

	public boolean validirajTelefon(String str) {
		if(str.equals("") || str == null)
			this.telefon = false;
		else
			this.telefon = Pattern.matches("\\+?[0-9]{5,12}", str);//?
		return this.telefon;
	}

	public boolean validirajEmail(String str) {
		if(str.equals("") || str == null)
			this.email = false;
		else
			this.email = Pattern.matches("([a-z0-9]|\\.|_|-)+@[a-z]+(\\.[a-z]+)?", str);
		return this.email;
	}
	
	public boolean validirajBrojIndeksa(String str) {
		if(str.equals("") || str == null)
			indeks = false;
		else 
			indeks = Pattern.matches("[a-z]{2}-[0-9]{1,3}-20[0-2][0-9]", str);
		return this.indeks;
		
	}
	public boolean validirajGodinuUpisa(String str) {
		if(str.equals("") || str == null)
			godinaUpisa = false;
		else
			godinaUpisa = Pattern.matches("20[0-2][0-9]", str);
		return this.godinaUpisa;
	}

	public boolean validirajAdresuKancelarije(String str) {
		if(str.equals("") || str == null)
			this.adresaKancelarija = false;
		else
			this.adresaKancelarija = Pattern.matches("([0-9]+|[A-ZŠĐŽČĆa-zšđžčć][a-zšđžčć]+| ?|,?)+", str);
		return this.adresaKancelarija;
	}

	public boolean validirajBrojLicneKarte(String str) {
		if(str.equals("") || str == null)
			this.brojLicne = false;
		else
			this.brojLicne = Pattern.matches("[0-9]{9}", str);
		return this.brojLicne;
	}

	public boolean isIme() {
		return ime;
	}

	public boolean isPrezime() {
		return prezime;
	}

	public boolean isDatum() {
		return datum;
	}

	public boolean isAdresaStan() {
		return adresaStan;
	}
	
	public boolean isTelefon() {
		return telefon;
	}

	public boolean isEmail() {
		return email;
	}
	
	public boolean isIndeks() {
		return indeks;
	}

	public boolean isGodinaUpisa() {
		return godinaUpisa;
	}
	
	public boolean isAdresaKancelarija() {
		return adresaKancelarija;
	}

	public boolean isBrojLicne() {
		return brojLicne;
	}
}