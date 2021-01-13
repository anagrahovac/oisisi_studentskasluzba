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
	
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Student student = this.studenti.get(row);
		String retVal = null;
		
		switch(column) {
		case 0:
			return student.getBrojIndexa();
			//break;
		case 1:
			return student.getImeStudenta();
			//break;
		case 2:
			return student.getPrezimeStudenta();
			//break;
		case 3:
			return student.getTrenutnaGodinaStudija();
			//break;
		case 4:
			{
			if (student.getStatus() == Status.B)
				return "Budžet";
			if (student.getStatus() == Status.S)
				return "Samofinansiranje";
			return "";
			}
		case 5:
			return student.getProsecnaocena();
			//String.format("%.2f", student.getProsecnaocena());
			//break;
		default:
			throw new IllegalArgumentException("Invalid column index");
		}
		
		//return retVal;
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
	
	public int pronadjiStudenta1(String indx) {
		for(int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrojIndexa().equals(indx)) {
				return i;
			}
		}
		return -1;
	}
	
	public String stariIndeks() {
		int row = MainFrame.getInstance().getStudentiTable().getSelectedRow();
		
		if(row != -1)
			return (String) MainFrame.getInstance().getStudentiTable().getValueAt(row, 0);
		else
			return "";
		
	}
	
	public Student studentDatogIndeksa(String indx) {
		for(int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrojIndexa().equals(indx)) {
				return studenti.get(i);
			}
		}
		return null;
	}
	
	public void izmeniStudenta(String stariBrojIndexa, String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status) {
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
			 }
		}
	}
	
	public void izbrisiStudenta(int i) {
		this.studenti.remove(i);
	}
	
	//za tabelu nepolozeni predmeti
	public int getNepolozeniColumnCount() {
		return BazaPredmeta.getInstance().getKolone().size();
	}
	
	public int getNepolozeniRowCount(String id) {
		int i = this.pronadjiStudenta1(id);
		return this.studenti.get(i).getSpisakNepolozenihIspita().size();
	}
	
	public String getNepolozeniColumnName(int index) {
		return BazaPredmeta.getInstance().getKolone().get(index);
	}
	
	public Predmet getNepolozeniRow(int rowIndex, String id) {
		int i = this.pronadjiStudenta1(id);
		return this.studenti.get(i).getSpisakNepolozenihIspita().get(rowIndex);
	}
	
	public String getNepolozeniValueAt(int row, int column, String id) {
		int i = this.pronadjiStudenta1(id);
		Predmet predmet = this.studenti.get(i).getSpisakNepolozenihIspita().get(row);
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
