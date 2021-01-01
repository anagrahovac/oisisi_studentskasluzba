package model;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Predmet.Semestar;
import model.Student.Status;
import view.MainFrame;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;
	private ArrayList<Student> studenti;
	private ArrayList<String> columnNames;
	private ArrayList<String> columnNamesPolozeni;

	public BazaStudenata() {
		this.studenti = new ArrayList<Student>();
		this.columnNames = new ArrayList<String>();
		columnNames.add("Indeks");
		columnNames.add("Ime");
		columnNames.add("Prezime");
		columnNames.add("Godina studija");
		columnNames.add("Status");
		columnNames.add("Prosek");
		
		this.columnNamesPolozeni = new ArrayList<String>();
		columnNamesPolozeni.add("Šifra predmeta");
		columnNamesPolozeni.add("Naziv predmeta");
		columnNamesPolozeni.add("ESPB");
		columnNamesPolozeni.add("Ocena");
		columnNamesPolozeni.add("Datum");
		
		//obrisati
		this.dodajStudenta();
	}
	
	private ArrayList<Ocena> initPredmeteMitar() {
		ArrayList<Ocena> ocene = new ArrayList<Ocena>();
 
		Ocena o1 = new Ocena();
		o1.setPredmet(new Predmet("E2212", "Matematička analiza 1", Semestar.ZIMSKI, 1, null, 9 ));
		o1.setOcena(9);
		o1.setDatumPolaganjaispita("14.10.1999.");
		ocene.add(o1);
		Ocena o2 = new Ocena();
		o2.setPredmet(new Predmet("E2214", "Objektno programiranje",Semestar.ZIMSKI, 2, null, 4));
		o2.setOcena(10);
		o2.setDatumPolaganjaispita("10.11.2020.");
		ocene.add(o2);
		Ocena o3 = new Ocena();
		o3.setPredmet(new Predmet("E2216", "Sistemi automatskog upravljanja",Semestar.LETNJI, 3, null, 7));
		o3.setOcena(10);
		o3.setDatumPolaganjaispita("13.4.2828.");
		ocene.add(o3);
 
		return ocene;
	}
 
	//----
	private ArrayList<Ocena> initPredmeteMarija() {
		ArrayList<Ocena> ocene = new ArrayList<Ocena>();
 
		Ocena o2 = new Ocena();
		//o2.setPredmet(new Predmet("E2214", "Objektno programiranje", 8, 2, Semestar.ZIMSKI));
		ocene.add(o2);
		Ocena o1 = new Ocena();
		//o1.setPredmet(new Predmet("E2218", "Operativni sistemi", 8, 2, Semestar.LETNJI));
		ocene.add(o1);
		Ocena o3 = new Ocena();
		//o3.setPredmet(new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI));
		ocene.add(o3);
 
		return ocene;
	}
 
	//------
	private ArrayList<Ocena> initPredmeteNikola() {
		ArrayList<Ocena> ocene = new ArrayList<Ocena>();
 
		Ocena o3 = new Ocena();
		//o3.setPredmet(new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI));
		ocene.add(o3);
 
		return ocene;
	}
	
	//obrisati
	public void dodajStudenta() {
		
		Student s = new Student("Mirić", "Mitar", LocalDate.of(2017, 1, 13), "Šafarikova 23", "0600000000", "mitarmiric@uns.ac.rs", "ra-230-2018", 2018, 3, Status.B, 10.00);	
		Student s1 = new Student("Obradović", "Dušan", LocalDate.of(1995, 6, 15), "Bulevar Oslobodjenja 67", "0610000000", "obradovicdusan@uns.ac.rs","sw-5-2014", 2014, 4, Status.S, 8.5);
		Student s2 = new Student("Mitrović","Anđela", LocalDate.of(2000, 7, 22), "Mostarska 50", "0620000000", "mitrovicandjela@uns.ac.rs", "ra-35-2019", 2019, 2, Status.B , 8.95);
		Student s3 = new Student("Kostovski", "Miloš", LocalDate.of(1998, 5, 11), "Mladosti 39", "0630000000", "kostovskimilos@uns.ac.rs", "in-56-2017", 2017, 4, Status.S, 7.25);
		Student s4 = new Student("Antić", "Isidora", LocalDate.of(2001, 12, 14), "Radnička 55", "0640000000", "anticisidora@uns.ac.rs", "mh-23-2020", 2020, 1, Status.B, 9.45);
		s.setSpisakPolozenihIspita(initPredmeteMitar());
		this.studenti.add(s);
		this.studenti.add(s1);
		this.studenti.add(s2);
		this.studenti.add(s3);
		this.studenti.add(s4);
		
	}

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	public static void setInstance(BazaStudenata instance) {
		BazaStudenata.instance = instance;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public String getColumnNames(int index) {
		return this.columnNames.get(index);
	}	
	
	public String getColumnNamesPolozeni(int index){		
		return this.columnNamesPolozeni.get(index);
	}

	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}
	
	public int getColumnCount() {
		return this.columnNames.size();
	}
	
	public int getColumnCountPolozeni() {
		return 5;
	}
	
	public int getRowCount() {
		return this.studenti.size();
	}
	
	public String getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Student student = this.studenti.get(row);
		String retVal = null;
		
		switch(column) {
		case 0:
			retVal = student.getBrojIndexa();
			break;
		case 1:
			retVal = student.getImeStudenta();
			break;
		case 2:
			retVal = student.getPrezimeStudenta();
			break;
		case 3:
			retVal = Integer.toString(student.getTrenutnaGodinaStudija());
			break;
		case 4:
			{
			if (student.getStatus() == Status.B)
				return "Budžet";
			if (student.getStatus() == Status.S)
				return "Samofinansiranje";
			return "";
			}
		case 5:
			retVal = String.format("%.2f", student.getProsecnaocena());
			break;
		default:
			throw new IllegalArgumentException("Invalid column index");
		}
		
		return retVal;
	}
	
	public void dodajStudentaUBazu(String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status, double prosecnaocena) {
		Student p = new Student(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa,
				brojIndexa, godinaUpisa, trenutnaGodinaStudija, status, prosecnaocena);
		this.studenti.add(p);
	}
	
	public boolean pronadjiStudenta(String indx) {
		for(int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrojIndexa().equals(indx)) {
				return true;
			}
		}
		return false;
	}
	
	public String stariIndeks() {
		int row = MainFrame.getInstance().getStudentiTable().getSelectedRow();
		
		if(row != -1)
			return (String) MainFrame.getInstance().getStudentiTable().getValueAt(row, 0);
		else
			return "";
		
	}
	
	public Student studentDatogIndeksa(String indx) {
		Student s = new Student();
		for(int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrojIndexa().equals(indx)) {
				String ime = studenti.get(i).getImeStudenta();
				String prezime = studenti.get(i).getPrezimeStudenta();
				LocalDate datum = studenti.get(i).getDatumRodjenja();
				String adresa = studenti.get(i).getAdresaStanovanja();
				String kontakt = studenti.get(i).getKontaktTelefon();
				String email = studenti.get(i).getEmailAdresa();
				String indeks = studenti.get(i).getBrojIndexa();
				int godina = studenti.get(i).getGodinaUpisa();
				int trenutno = studenti.get(i).getTrenutnaGodinaStudija();
				Status status = studenti.get(i).getStatus();
				double prosek = studenti.get(i).getProsecnaocena();
						
				s = new Student(prezime,ime, datum, adresa, kontakt, email, indeks, godina, trenutno, status,prosek);
				return s;
			}
		}
		return s;
	}
	
	public void izmeniStudenta(String stariBrojIndexa, String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status, double prosecnaocena) {
		for(int i = 0; i < studenti.size(); i++) {
			 if(studenti.get(i).getBrojIndexa().equals(stariBrojIndexa)) {
				 studenti.get(i).setPrezimeStudenta(prezime);
				 studenti.get(i).setImeStudenta(ime);
				 studenti.get(i).setDatumRodjenja(datumRodjenja);
				 studenti.get(i).setAdresaStanovanja(adresaStanovanja);
				 studenti.get(i).setKontaktTelefon(kontaktTelefon);
				 studenti.get(i).setEmailAdresa(emailAdresa);
				 studenti.get(i).setBrojIndexa(brojIndexa);
				 studenti.get(i).setGodinaUpisa(godinaUpisa);
				 studenti.get(i).setTrenutnaGodinaStudija(trenutnaGodinaStudija);
				 studenti.get(i).setStatus(status);
				 studenti.get(i).setProsecnaocena(prosecnaocena);
			 }
		}
	}
	
	public void izbrisiStudenta(int i) {
		this.studenti.remove(i);
	}
}
