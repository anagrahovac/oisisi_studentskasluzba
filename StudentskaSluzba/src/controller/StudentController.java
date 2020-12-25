package controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import model.BazaStudenata;
import model.Student.Status;
import view.MainFrame;
import view.NoviStudentDialog;

public class StudentController {
	
	private NoviStudentDialog view;
	private Validacija validacija;
	
	public StudentController(NoviStudentDialog view) {
		this.view = view;
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
}
