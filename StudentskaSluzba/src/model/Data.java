package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
	
	private static final long serialVersionUID = -2952100824529833746L;
	
	private ArrayList<Student> studenti;
	private ArrayList<Profesor> profesori;
	private ArrayList<Predmet> predmeti;

	public Data() {
		studenti = BazaStudenata.getInstance().getStudenti();
		profesori = BazaProfesora.getInstance().getProfesori();
		predmeti = BazaPredmeta.getInstance().getPredmeti();
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
}