package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ProfesorController;

public class NoviProfesorDialog extends JDialog{

	private static final long serialVersionUID = -4480924644161247106L;
	
	private ProfesorController controller;
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

public NoviProfesorDialog() {
		
		super(MainFrame.getInstance(), "Dodavanje profesora", true);
		this.setSize(500, 600);
		this.setTitle("Dodavanje profesora");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setResizable(false);

		Color gray = new Color(245,245,245);
		this.setBackground(gray);
		controller = new ProfesorController(this);
		
		
		//centralni panel za unos podataka
		JPanel pCenter = new JPanel();
		pCenter.setBackground(gray);
		BoxLayout box = new BoxLayout(pCenter, BoxLayout.Y_AXIS);
		pCenter.setLayout(box);
		this.add(pCenter, BorderLayout.CENTER);
		
		ProfesorKeyListener pl = new ProfesorKeyListener(this);
		
		pIme = new RowPanel("Ime*");
		pIme.getTextField().setName("txtIme");
		pIme.getTextField().addKeyListener(pl);
		
		pPrezime = new RowPanel("Prezime*");
		pPrezime.getTextField().setName("txtPrezime");
		pPrezime.getTextField().addKeyListener(pl);
		
		pDatum = new RowPanel("Datum rodjenja*");
		pDatum.getTextField().setName("txtDatum");
		pDatum.getTextField().addKeyListener(pl);
		
		pAdresaStan = new RowPanel("Adresa stanovanja*");
		pAdresaStan.getTextField().setName("txtAdresaStan");
		pAdresaStan.getTextField().addKeyListener(pl);
	
		pTelefon = new RowPanel("Kontakt telefon*");
		pTelefon.getTextField().setName("txtTelefon");
		pTelefon.getTextField().addKeyListener(pl);
		
		pEmail = new RowPanel("E-mail adresa*");
		pEmail.getTextField().setName("txtEmail");
		pEmail.getTextField().addKeyListener(pl);
		
		pAdresaKancelarija = new RowPanel("Adresa kancelarije*");
		pAdresaKancelarija.getTextField().setName("txtAdresaKancelarija");
		pAdresaKancelarija.getTextField().addKeyListener(pl);
		
		pID = new RowPanel("Broj lične karte*");
		pID.getTextField().setName("txtID");
		pID.getTextField().addKeyListener(pl);
		
		String[] titule = { "Doktor", };
		pTitula = new RowPanel("Titula*", titule);

        String[] zvanja = {"Docent", "Vanredni profesor", "Redovni profesor", };
		pZvanje = new RowPanel("Zvanje*", zvanja);
		
        pCenter.add(Box.createVerticalStrut(30));  
        pCenter.add(pIme);
        pCenter.add(pPrezime); 
        pCenter.add(pDatum);
        pCenter.add(pAdresaStan);
        pCenter.add(pTelefon);
        pCenter.add(pEmail); 
        pCenter.add(pAdresaKancelarija);
        pCenter.add(pID);
        pCenter.add(pTitula); 
        pCenter.add(pZvanje);
        pCenter.add(Box.createVerticalStrut(30));
        
        
        //panel pBotom za dugmad
        JPanel pBottom = new JPanel();
        pBottom.setPreferredSize(new Dimension(70, 70));
        pBottom.setBackground(gray);
        pBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pBottom.setPreferredSize(new Dimension(50, 50));
        this.add(pBottom, BorderLayout.SOUTH);
		
        this.formatButton(btnPotvrdi, 1);
        this.disablePotvrdi();
		pBottom.add(btnPotvrdi);
		pBottom.add(Box.createHorizontalStrut(10));
		this.dodajListenerPotvrdi();
		
		this.formatButton(btnOdbaci, 0);
		pBottom.add(btnOdbaci);
		pBottom.add(Box.createHorizontalStrut(50));
        this.dodajListenerOdbaci();
        
		validate();
	}

	private void dodajListenerPotvrdi() {
		btnPotvrdi.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnPotvrdi.isEnabled()) {
					boolean succ = controller.dodajProfesora();
					if(succ == true) {
						JOptionPane.showMessageDialog(null, "Profesor uspešno dodat u bazu.");
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