package model;

import java.util.ArrayList;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	private ArrayList<Predmet> predmeti;
	private ArrayList<String> kolone;
	
	private BazaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("ESPB bodovi");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
		//obrisati posle
		this.dodajPredmete();
	}
	
	//obrisati posle
	private void dodajPredmete() {
		//String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija, Profesor predmetniProfesor, int brojBodova
		Predmet p1, p2, p3;
		p1 = new Predmet("P012", "Algebra", Semestar.ZIMSKI, 1, null, 9);
		p2 = new Predmet("A805", "Objektno programiranje", Semestar.ZIMSKI, 2, null, 8);
		p3 = new Predmet("K156", "Arhitektura racunara", Semestar.LETNJI, 1, null, 9);
		this.predmeti.add(p1);
		this.predmeti.add(p2);
		this.predmeti.add(p3);
		
	}
	
	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return this.kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
			case 0:
				return predmet.getSifraPredmeta();
			case 1:
				return predmet.getNazivPredmeta();
			case 2:
				return Integer.toString(predmet.getBrojBodova());
			case 3:
				{
					if (predmet.getSemestar() == Semestar.LETNJI)
						return "Letnji";
					if (predmet.getSemestar() == Semestar.ZIMSKI)
						return "Zimski";
					return "";
				}
			case 4:
				return Integer.toString(predmet.getGodinaStudija());
			default:
				return null;
		}
	}
	
	public void dodajPredmet(Predmet p) {
		this.predmeti.add(p);
	}
	
	public void izmeniPredmet(int i,String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
			Profesor predmetniProfesor, int brojBodova) {
		this.predmeti.get(i).setSifraPredmeta(sifraPredmeta);
		this.predmeti.get(i).setNazivPredmeta(nazivPredmeta);
		this.predmeti.get(i).setSemestar(semestar);
		this.predmeti.get(i).setGodinaStudija(godinaStudija);
		this.predmeti.get(i).setPredmetniProfesor(predmetniProfesor);
		this.predmeti.get(i).setBrojBodova(brojBodova);
	}
	
	public void izbrisiPredmet(int i) {
		this.predmeti.remove(i);
	}
}
