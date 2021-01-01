package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.ProfesorController;
import model.BazaProfesora;
import model.Profesor;

public class IzmenaProfesoraDialog extends JDialog {
	
	private static final long serialVersionUID = 415279348790456678L;

	private Profesor profesor;
	private ProfesorController controller;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private RowPanel pIme;
	private RowPanel pPrezime;
	private RowPanel pDatum;
	private RowPanel pAdresaStan;
	private RowPanel pTelefon;
	private RowPanel pEmail;
	private RowPanel pAdresaKancelarija;
	private RowPanel pID;
	private RowPanel pTitula;
	private RowPanel pZvanje;
	private JButton btnPotvrdi = new JButton("Potvrdi");
	private JButton btnOdbaci = new JButton("Odustani");
	
	public IzmenaProfesoraDialog(String id) {
		 
		super(MainFrame.getInstance(), "Izmena profesora", true);
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setResizable(false);

		this.getContentPane().setBackground(Color.WHITE);
		controller = new ProfesorController(this);
		profesor = BazaProfesora.getInstance().pronadjiProfesora(id);
		
		Font f = new Font("Dialog", Font.PLAIN, 14);
		this.tabbedPane.setBackground(Color.WHITE);
		this.tabbedPane.setFont(f);
		
		JPanel infoTab = new JPanel();
		JPanel predmetiTab = new JPanel();
		
		
		Color gray = new Color(245,245,245);
		
		infoTab.setBackground(gray);
		BoxLayout box = new BoxLayout(infoTab, BoxLayout.Y_AXIS);
		infoTab.setLayout(box);
		this.add(infoTab, BorderLayout.CENTER);
		
		pIme = new RowPanel("Ime*");
		pIme.getTextField().setName("txtIme");
		pIme.getTextField().setText(profesor.getIme());
		
		pPrezime = new RowPanel("Prezime*");
		pPrezime.getTextField().setName("txtPrezime");
		pPrezime.getTextField().setText(profesor.getPrezime());
		
		pDatum = new RowPanel("Datum rodjenja*");
		pDatum.getTextField().setName("txtDatum");
		pDatum.getTextField().setText(profesor.getDatumRodjenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
		pDatum.getTextField().setToolTipText("Format: dd.mm.yyyy.");
		
		pAdresaStan = new RowPanel("Adresa stanovanja*");
		pAdresaStan.getTextField().setName("txtAdresaStan");
		pAdresaStan.getTextField().setText(profesor.getAdresaStanovanja());
	
		pTelefon = new RowPanel("Kontakt telefon*");
		pTelefon.getTextField().setName("txtTelefon");
		pTelefon.getTextField().setText(profesor.getKontaktTelefon());
		
		pEmail = new RowPanel("E-mail adresa*");
		pEmail.getTextField().setName("txtEmail");
		pEmail.getTextField().setText(profesor.getEmailAdresa());
		
		pAdresaKancelarija = new RowPanel("Adresa kancelarije*");
		pAdresaKancelarija.getTextField().setName("txtAdresaKancelarija");
		pAdresaKancelarija.getTextField().setText(profesor.getAdresaKancelarije());
		
		pID = new RowPanel("Broj lične karte*");
		pID.getTextField().setName("txtID");
		pID.getTextField().setText(profesor.getBrojLicneKarte());
		
		String[] titule = { "Doktor", };
		pTitula = new RowPanel("Titula*", titule);
		pTitula.getComboBox().setSelectedIndex(profesor.getTitula().ordinal());

        String[] zvanja = {"Docent", "Vanredni profesor", "Redovni profesor", };
		pZvanje = new RowPanel("Zvanje*", zvanja);
		pZvanje.getComboBox().setSelectedIndex(profesor.getZvanje().ordinal());
		
		infoTab.add(Box.createVerticalStrut(30));  
		infoTab.add(pIme);
		infoTab.add(pPrezime); 
		infoTab.add(pDatum);
		infoTab.add(pAdresaStan);
		infoTab.add(pTelefon);
		infoTab.add(pEmail); 
        infoTab.add(pAdresaKancelarija);
        infoTab.add(pID);
        infoTab.add(pTitula); 
        infoTab.add(pZvanje);
        infoTab.add(Box.createVerticalStrut(30));
		
        //panel pBotom za dugmad
        JPanel pBottom = new JPanel();
        pBottom.setPreferredSize(new Dimension(70, 70));
        pBottom.setBackground(gray);
        pBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pBottom.setPreferredSize(new Dimension(50, 50));
        infoTab.add(pBottom, BorderLayout.SOUTH);
		
        this.formatButton(btnPotvrdi, 1);
        this.disablePotvrdi();
		pBottom.add(btnPotvrdi);
		pBottom.add(Box.createHorizontalStrut(10));
		
		this.formatButton(btnOdbaci, 0);
		pBottom.add(btnOdbaci);
		pBottom.add(Box.createHorizontalStrut(100));
		
		
		tabbedPane.addTab("Info", null, infoTab, "Informacije o profesoru");
		tabbedPane.addTab("Predmeti", null, predmetiTab, "Predmeti na kojima je angažovan");

		this.add(tabbedPane);
		validate();
	 }
	

	private void formatButton(JButton btn, int i) {
        Dimension btnDim = new Dimension(100, 30);
		Font f = new Font("Dialog", Font.PLAIN, 14);
		Color g = new Color(230,230,230);
		Color b = new Color(103, 140, 235);

		btn.setPreferredSize(btnDim);
		btn.setBackground(g);
		btn.setFont(f);
		if (i == 1) {
			btn.setBorder(BorderFactory.createLineBorder(b, 2));
			btn.setToolTipText("Sačuvaj unete podatke");
		}
		if (i == 0) {
			btn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			btn.setToolTipText("Odbaci unete podatke");
		}
		
	}
	
	public void disablePotvrdi() {
		btnPotvrdi.setEnabled(false);
		btnPotvrdi.setForeground(new Color(150, 150, 150));
		btnPotvrdi.setBackground(new Color(220, 220, 220));
		btnPotvrdi.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
	}
	
	public void enablePotvrdi() {
		btnPotvrdi.setEnabled(true);
		btnPotvrdi.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 2));
		btnPotvrdi.setBackground(new Color(230,230,230));
		btnPotvrdi.setForeground(Color.BLACK);
	}
	
	public RowPanel getpIme() {
		return pIme;
	}

	public RowPanel getpPrezime() {
		return pPrezime;
	}
	
	public RowPanel getpDatum() {
		return pDatum;
	}

	public RowPanel getpAdresaStan() {
		return pAdresaStan;
	}

	public RowPanel getpTelefon() {
		return pTelefon;
	}

	public RowPanel getpEmail() {
		return pEmail;
	}
	
	public RowPanel getpAdresaKancelarija() {
		return pAdresaKancelarija;
	}

	public RowPanel getpID() {
		return pID;
	}

	public RowPanel getpTitula() {
		return pTitula;
	}

	public RowPanel getpZvanje() {
		return pZvanje;
	}
	
	public JButton getBtnPotvrdi() {
		return btnPotvrdi;
	}
	
	public JButton getBtnOdbaci() {
		return btnOdbaci;
	}

	public ProfesorController getController() {
		return controller;
	}
}
