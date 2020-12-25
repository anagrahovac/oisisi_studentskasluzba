package model;

import java.util.ArrayList;
import model.Student.Status;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;
	private ArrayList<Student> studenti;
	private ArrayList<String> columnNames;

	public BazaStudenata() {
		this.studenti = new ArrayList<Student>();
		this.columnNames = new ArrayList<String>();
		columnNames.add("Indeks");
		columnNames.add("Ime");
		columnNames.add("Prezime");
		columnNames.add("Godina studija");
		columnNames.add("Status");
		columnNames.add("Prosek");
		
		//obrisati
		this.dodajStudenta();
	}
	
	//obrisati
	public void dodajStudenta() {
		
		Student s = new Student("Mirić", "Mitar", "23.01.1999.", "Safarikova 23", "0600000000", "mitarmiric@uns.ac.rs", "RA230-2018", 2018, 3, Status.B, 10.00);	
		Student s1 = new Student("Obradović", "Dušan", "15.06.1995.", "Bulevar Oslobodjenja 67", "0610000000", "obradovicdusan@uns.ac.rs","RA5-2014", 2014, 4, Status.S, 8.5);
		Student s2 = new Student("Mitrović","Anđela", "22.07.2000.", "Mostarska 50", "0620000000", "mitrovicandjela@uns.ac.rs", "RA35-2019", 2019, 2, Status.B , 8.95);
		Student s3 = new Student("Kostovski", "Miloš", "11.05.1998.", "Mladosti 39", "0630000000", "kostovskimilos@uns.ac.rs", "RA56-2017", 2017, 4, Status.S, 7.25);
		Student s4 = new Student("Antić", "Isidora", "14.12.2001.", "Radnicka 55", "0640000000", "anticisidora@uns.ac.rs", "RA23-2020", 2020, 1, Status.B, 9.45);
		
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

	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}
	
	public int getColumnCount() {
		return this.columnNames.size();
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
	
	public void dodajStudentaUBazu(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
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
}
