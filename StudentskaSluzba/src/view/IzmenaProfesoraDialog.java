package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	
	private TablePredmetiProfesora predmetiProfesora;
	
	public IzmenaProfesoraDialog(String id) {
		 
		super(MainFrame.getInstance(), "Izmena profesora", true);
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setResizable(false);

		this.getContentPane().setBackground(Color.WHITE);
		controller = new ProfesorController(this);
		controller.getValidacija().setAllTrue();
		int redniBr = BazaProfesora.getInstance().pronadjiProfesora(id);
		profesor = BazaProfesora.getInstance().getProfesori().get(redniBr);
		
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
		
		ProfesorIzmenaKeyListener pl = new ProfesorIzmenaKeyListener(this);
		
		pIme = new RowPanel("Ime*");
		pIme.getTextField().setName("txtIme");
		pIme.getTextField().setText(profesor.getIme());
		pIme.getTextField().addKeyListener(pl);
		
		pPrezime = new RowPanel("Prezime*");
		pPrezime.getTextField().setName("txtPrezime");
		pPrezime.getTextField().setText(profesor.getPrezime());
		pPrezime.getTextField().addKeyListener(pl);
		
		pDatum = new RowPanel("Datum rodjenja*");
		pDatum.getTextField().setName("txtDatum");
		pDatum.getTextField().setText(profesor.getDatumRodjenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
		pDatum.getTextField().addKeyListener(pl);
		pDatum.getTextField().setToolTipText("Format: dd.mm.yyyy.");
		
		pAdresaStan = new RowPanel("Adresa stanovanja*");
		pAdresaStan.getTextField().setName("txtAdresaStan");
		pAdresaStan.getTextField().setText(profesor.getAdresaStanovanja());
		pAdresaStan.getTextField().addKeyListener(pl);
	
		pTelefon = new RowPanel("Kontakt telefon*");
		pTelefon.getTextField().setName("txtTelefon");
		pTelefon.getTextField().setText(profesor.getKontaktTelefon());
		pTelefon.getTextField().addKeyListener(pl);
		
		pEmail = new RowPanel("E-mail adresa*");
		pEmail.getTextField().setName("txtEmail");
		pEmail.getTextField().setText(profesor.getEmailAdresa());
		pEmail.getTextField().addKeyListener(pl);
		
		pAdresaKancelarija = new RowPanel("Adresa kancelarije*");
		pAdresaKancelarija.getTextField().setName("txtAdresaKancelarija");
		pAdresaKancelarija.getTextField().setText(profesor.getAdresaKancelarije());
		pAdresaKancelarija.getTextField().addKeyListener(pl);
		
		pID = new RowPanel("Broj lične karte*");
		pID.getTextField().setName("txtID");
		pID.getTextField().setText(profesor.getBrojLicneKarte());
		pID.getTextField().addKeyListener(pl);
		
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
        pBottom.setLayout(new FlowLayout(FlowLayout.LEFT));
        pBottom.setPreferredSize(new Dimension(50, 50));
        infoTab.add(pBottom, BorderLayout.SOUTH);
		
        this.formatButton(btnPotvrdi, 1);
        this.enablePotvrdi();
        
        pBottom.add(Box.createHorizontalStrut(190));
		pBottom.add(btnPotvrdi);
		pBottom.add(Box.createHorizontalStrut(10));
		this.dodajListenerPotvrdi();
		
		this.formatButton(btnOdbaci, 0);
		pBottom.add(btnOdbaci);
        this.dodajListenerOdbaci();
        
        //tab predmeti 
      	predmetiTab.setBackground(Color.WHITE);
      	//predmetiTab.setBackground(gray);
      	JPanel pTop = new JPanel();
      	pTop.setLayout(new BorderLayout());
      	JButton btnDodajPredmet = new JButton("Dodaj");
      	JButton btnUkloniPredmet = new JButton("Ukloni");
      	formatButton(btnDodajPredmet, 3);
      	formatButton(btnUkloniPredmet, 2);

      	pTop.setLayout(new FlowLayout(FlowLayout.CENTER));
      	pTop.setPreferredSize(new Dimension(850, 50));
      	pTop.setBackground(Color.WHITE);
      	//pTop.setBackground(gray);
      	pTop.add(btnDodajPredmet);
      	pTop.add(Box.createHorizontalStrut(10));
      	pTop.add(btnUkloniPredmet);
      	pTop.add(Box.createHorizontalStrut(10));


      	predmetiProfesora = new TablePredmetiProfesora(id);
      	updatePredmetiProfesoraTable();
        predmetiTab.add(pTop, BorderLayout.NORTH);
        JScrollPane scroll = new JScrollPane(predmetiProfesora);
        scroll.setPreferredSize(new Dimension(850, 450));

      	scroll.getViewport().setBackground(Color.WHITE);

        predmetiTab.add(scroll, BorderLayout.CENTER);
		
		tabbedPane.addTab("Info", null, infoTab, "Informacije o profesoru");
		tabbedPane.addTab("Predmeti", null, predmetiTab, "Predmeti na kojima je angažovan");

		this.add(tabbedPane);
		validate();
	 }
	
	private void dodajListenerPotvrdi() {
		btnPotvrdi.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnPotvrdi.isEnabled()) {
					boolean succ = controller.izmeniProfesora(BazaProfesora.getInstance().pronadjiProfesora(profesor.getBrojLicneKarte()));
					if(succ == true) {
						JOptionPane.showMessageDialog(null, "Profesor uspešno izmenjen u bazi.");
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Broj lične karte već postoji u bazi!");
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(btnPotvrdi.isEnabled()) {
					btnPotvrdi.setBackground(new Color(228, 244, 255));
					btnPotvrdi.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 1));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(btnPotvrdi.isEnabled()) {
					btnPotvrdi.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 2));
					btnPotvrdi.setBackground(new Color(230,230,230));
				}
			}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
	}
	
	private void dodajListenerOdbaci() {
		btnOdbaci.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnOdbaci.setBackground(new Color(228, 244, 255));
				btnOdbaci.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 1));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnOdbaci.setBackground(new Color(230,230,230));
				btnOdbaci.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
	}


	public void updatePredmetiProfesoraTable() {
		AbstractTableModelPredmetiProfesora model = (AbstractTableModelPredmetiProfesora) predmetiProfesora.getModel();
		model.fireTableDataChanged();
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
		if (i == 3) {
			btn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			btn.setToolTipText("Dodaj predmet profesoru");
		}
		if (i == 2) {
			btn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			btn.setToolTipText("Ukloni predmet sa profesora");
		}
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
