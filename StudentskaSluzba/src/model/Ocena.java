package model;

public class Ocena {
	private Student student;
	private Predmet predmet;
	private int ocena;
	private String datumPolaganjaispita;
	
	public Ocena() {
		super();
		this.student = null;
		this.predmet = null;
		this.ocena = 0;
		this.datumPolaganjaispita = null;
	}

	public Ocena(Student student, Predmet predmet, int ocena, String datumPolaganjaispita) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datumPolaganjaispita = datumPolaganjaispita;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getDatumPolaganjaispita() {
		return datumPolaganjaispita;
	}

	public void setDatumPolaganjaispita(String datumPolaganjaispita) {
		this.datumPolaganjaispita = datumPolaganjaispita;
	};
}
