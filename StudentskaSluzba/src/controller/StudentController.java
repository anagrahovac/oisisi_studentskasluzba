package controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import model.Student.Status;
import view.IzmenaStudentaDialog;
import view.MainFrame;
import view.NoviStudentDialog;


public class StudentController {
	
	private NoviStudentDialog view;
	private IzmenaStudentaDialog izmena;
	private Validacija validacija;
	
	public StudentController() {
		this.izmena = null;
		this.validacija = null;
		this.view = null;
	}
	
	public StudentController(NoviStudentDialog view) {
		this.view = view;
		this.validacija = new Validacija();		
	}
	
	public StudentController(IzmenaStudentaDialog i) {
		this.izmena = i;
		this.validacija = new Validacija();
	}

	public Validacija getValidacija() {
		return validacija;
	}

	public boolean dodajStudenta() {
		String ime = view.getpIme().getTextField().getText();
		String prezime = view.getpPrezime().getTextField().getText();
		String datum = view.getpDatumRodjenja().getTextField().getText();
			LocalDate datumRodj = null;
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				datumRodj = LocalDate.parse(datum, dtf);
			}
			catch(DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "Datum je nepostojeći!");
				return false;
			}
		String adresaStan = view.getpAdresaStanovanja().getTextField().getText();
		String brTelefona = view.getpBrojTelefona().getTextField().getText();
		String eMailAdresa = view.getpEMailAdresa().getTextField().getText();
		String brIndexa = view.getpBrojIndexa().getTextField().getText();
		int godU = Integer.valueOf(view.getpGodinaUpisa().getTextField().getText());
		Status status = Status.B;
		switch(view.getpNacinFinansiranja().getComboBox().getSelectedIndex()) {
		case 0:
			status = Status.B; 
			break;
		case 1:
			status = Status.S;
			break;
		}
		int trGodStu = 0;
		switch(view.getpTrenutnaGodinaStudija().getComboBox().getSelectedIndex()) {
		case 0:
			trGodStu = 1; 
			break;
		case 1:
			trGodStu = 2; 
			break;
		case 2:
			trGodStu = 3; 
			break;
		case 3:
			trGodStu = 4;
			break;
		}
		if(BazaStudenata.getInstance().pronadjiStudenta(brIndexa)) {
			JOptionPane.showMessageDialog(view, "Broj indeksa već postoji u bazi!");
			return false;
		}
			BazaStudenata.getInstance().dodajStudentaUBazu(prezime, ime, datumRodj, adresaStan, brTelefona, eMailAdresa, brIndexa, godU,trGodStu, status, 0.0);
			MainFrame.getInstance().updateStudentiTable();
			JOptionPane.showMessageDialog(null, "Student uspešno dodat u bazu.");
			return true;
	}
	
	public boolean izmeniStudenta(int i) {
		String ime = izmena.getpIme().getTextField().getText();
		String prezime = izmena.getpPrezime().getTextField().getText();
		String datum = izmena.getpDatumRodjenja().getTextField().getText();
			LocalDate datumRodj = null;
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				datumRodj = LocalDate.parse(datum, dtf);
			}
			catch(DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "Datum je nepostojeći!");
				return false;
			}
		String adresaStan = izmena.getpAdresaStanovanja().getTextField().getText();
		String brTelefona = izmena.getpBrojTelefona().getTextField().getText();
		String eMailAdresa = izmena.getpEMailAdresa().getTextField().getText();
		String brIndexa = izmena.getpBrojIndexa().getTextField().getText();
		int godU = Integer.valueOf(izmena.getpGodinaUpisa().getTextField().getText());
		Status status = Status.B;
		switch(izmena.getpNacinFinansiranja().getComboBox().getSelectedIndex()) {
		case 0:
			status = Status.B; 
			break;
		case 1:
			status = Status.S;
			break;
		}
		int trGodStu = 0;
		switch(izmena.getpTrenutnaGodinaStudija().getComboBox().getSelectedIndex()) {
		case 0:
			trGodStu = 1; 
			break;
		case 1:
			trGodStu = 2; 
			break;
		case 2:
			trGodStu = 3; 
			break;
		case 3:
			trGodStu = 4;
			break;
		}
		String stariIndeks = BazaStudenata.getInstance().stariIndeks();
		
		if((BazaStudenata.getInstance().pronadjiStudenta1(brIndexa) != -1) && (BazaStudenata.getInstance().pronadjiStudenta1(brIndexa) != i)) { 
			return false;
		}
			BazaStudenata.getInstance().izmeniStudenta(stariIndeks,prezime, ime, datumRodj, adresaStan, brTelefona, eMailAdresa, brIndexa, godU,trGodStu, status);
			MainFrame.getInstance().updateStudentiTable();

			return true;
	}
	
	public void obrisiStudenta(String index) {
		int indx = BazaStudenata.getInstance().pronadjiStudenta1(index);
		
		//for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
		//	ArrayList<Student> polozili = BazaPredmeta.getInstance().getPredmeti().get(i).getPoloziliPredmet();
		//	for(int j = 0; j < polozili.size(); j++) {
		//		if(polozili.get(j).getBrojIndexa().equals(index)) {
		//			BazaPredmeta.getInstance().getPredmeti().get(i).getPoloziliPredmet().remove(j);
		//		}
		//	}
		//}
		for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
			ArrayList<Student> nisuPolozili = BazaPredmeta.getInstance().getPredmeti().get(i).getNisuPoloziliPredmet();
			for(int j = 0; j < nisuPolozili.size(); j++) {
				if(nisuPolozili.get(j).getBrojIndexa().equals(index)) {
					BazaPredmeta.getInstance().getPredmeti().get(i).getNisuPoloziliPredmet().remove(j);
				}
			}
		}
		BazaStudenata.getInstance().izbrisiStudenta(indx);;
		MainFrame.getInstance().updateStudentiTable();
	}
	
	public boolean poloziPredmet(Student s, Predmet p, int ocena, String d) {
		LocalDate datum = null;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			datum = LocalDate.parse(d, dtf);
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Datum je nepostojeći!");
			return false;
		}
		Ocena o = new Ocena(s, p , ocena, datum);
		int i = BazaStudenata.getInstance().pronadjiStudenta1(s.getBrojIndexa());
		if(BazaStudenata.getInstance().getStudenti().get(i).izbaciIzSpiskaNepolozenih(p)) {
			izmena.updateNepolozeniTable();
			BazaStudenata.getInstance().getStudenti().get(i).dodajUSpisakPolozenih(o);
			izmena.updatePolozeniTable();
		}
		MainFrame.getInstance().updateStudentiTable();
		return true;
	}
	
public boolean dodajPredmetStudentu(Predmet p, Student s, String index, String sifra) {
		boolean dodato = false;
		for(int i = 0; i < s.getPredmetiZaDodavanje().size(); i++) {
			if(s.getPredmetiZaDodavanje().get(i).getSifraPredmeta().equals(sifra)) {
				s.getSpisakNepolozenihIspita().add(p);
				p.dodajNisuPoloziliPredmet(s);
				izmena.updateNepolozeniTable();
				dodato = true;
				break;
			}
			dodato = false;
		} 
		return dodato;	
	}
}
