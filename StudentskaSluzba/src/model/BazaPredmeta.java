package model;

import java.util.ArrayList;
import model.Predmet.Semestar;
import view.MainFrame;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	private ArrayList<Predmet> predmeti;
	private ArrayList<String> kolone;
	private ArrayList<String> kolonePS;
	
	private BazaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("ESPB bodovi");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
		this.kolonePS = new ArrayList<String>();
		this.kolonePS.add("Šifra");
		this.kolonePS.add("Naziv");
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
	
	public ArrayList<String> getKolone() {
		return kolone;
	}

	public int getColumnCount() {
		return this.kolone.size();
	}
	
	public int getColumnCountListaPredmeta() {
		return this.kolonePS.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public String getColumnNameListaPredmeta(int index) {
		return this.kolonePS.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public Object getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
			case 0:
				return predmet.getSifraPredmeta();
			case 1:
				return predmet.getNazivPredmeta();
			case 2:
				return predmet.getBrojBodova();
			case 3:
				return predmet.getGodinaStudija();
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
	
	public void dodajPredmetUBazu(String sifra, String naziv, Semestar semestar, int godStudija, Profesor predProfesor, int brESPB) {
		Predmet p = new Predmet(sifra, naziv, semestar, godStudija, predProfesor, brESPB);
		this.predmeti.add(p);
	}
	
	public boolean pronadjiPredmet(String sifra) {
		for(int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getSifraPredmeta().equals(sifra)) {
				return true;
			}
		}
		return false;
	}
	
	public int pronadjiPredmet1(String sifra) {
		for(int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getSifraPredmeta().equals(sifra)) {
				return i;
			}
		}
		return -1;
	}
	
	public String staraSifra() {
		int row = MainFrame.getInstance().getPredmetiTable().getSelectedRow();
		
		if(row != -1)
			return (String) MainFrame.getInstance().getPredmetiTable().getValueAt(row, 0);
		else
			return "";
		
	}
	
	public Predmet predmetDateSifre(String sfr) {
		Predmet p = new Predmet();
		for(int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getSifraPredmeta().equals(sfr)) {
				return predmeti.get(i);
			}
		}
		return p;
	}
	
	public void izmeniPredmet(String staraSifra,String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija, int brojBodova) {
		for(int i = 0; i < predmeti.size(); i++) {
			if(predmeti.get(i).getSifraPredmeta().equals(staraSifra)) {
				this.predmeti.get(i).setSifraPredmeta(sifraPredmeta);
				this.predmeti.get(i).setNazivPredmeta(nazivPredmeta);
				this.predmeti.get(i).setSemestar(semestar);
				this.predmeti.get(i).setGodinaStudija(godinaStudija);
				this.predmeti.get(i).setBrojBodova(brojBodova);
			}
		}
	}
	
	public void izbrisiPredmet(int i) {
		this.predmeti.remove(i);
	}
}
