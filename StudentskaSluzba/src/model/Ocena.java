package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Ocena implements Serializable {
	
	private static final long serialVersionUID = -1312378641925984005L;
	
	private Student student;
	private Predmet predmet;
	private int ocena;
	private LocalDate datumPolaganjaispita;
	
	public Ocena() {
		super();
		this.student = null;
		this.predmet = null;
		this.ocena = 0;
		this.datumPolaganjaispita = null;
	}

	public Ocena(Student student, Predmet predmet, int ocena, LocalDate datumPolaganjaispita) {
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

	public LocalDate getDatumPolaganjaispita() {
		return datumPolaganjaispita;
	}

	public void setDatumPolaganjaispita(LocalDate datumPolaganjaispita) {
		this.datumPolaganjaispita = datumPolaganjaispita;
	};
}
