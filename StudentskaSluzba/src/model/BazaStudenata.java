package model;

import java.util.ArrayList;

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
		columnNames.add("Trenutna godina studija");
		columnNames.add("Status");
		columnNames.add("Prosek");
		
		//obrisati
		this.dodajStudenta();
	}
	
	//obrisati
	public void dodajStudenta() {
		Student s = new Student();
		s.setBrojIndexa("RA230-2018");
		s.setImeStudenta("Mitar");
		s.setPrezimeStudenta("Miric");
		s.setDatumRodjenja("23.01.1999.");
		s.setAdresaStanovanja("Safarikova 23");
		s.setEmailAdresa("mitarmiric@uns.ac.rs");
		s.setGodinaUpisa("2018");
		s.setKontaktTelefon("0600000000");
		s.setStatus(Status.B);
		s.setTrenutnaGodinaStudija("3");
		s.setProsecnaocena("10.00");
		
		this.studenti.add(s);
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
			retVal = student.getTrenutnaGodinaStudija();
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
			retVal = student.getProsecnaocena();
			break;
		default:
			throw new IllegalArgumentException("Invalid column index");
		}
		
		return retVal;
	}
}
