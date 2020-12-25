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
import javax.swing.JPanel;

import controller.StudentController;


public class NoviStudentDialog extends JDialog{
	
	private static final long serialVersionUID = -5771101905175258662L;
	
	private StudentController controller;
	private RowPanel pIme;
	private RowPanel pPrezime;
	private RowPanel pDatumRodjenja;
	private RowPanel pAdresaStanovanja;
	private RowPanel pBrojTelefona;
	private RowPanel pEMailAdresa;
	private RowPanel pBrojIndexa;
	private RowPanel pGodinaUpisa;
	private RowPanel pTrenutnaGodinaStudija;
	private RowPanel pNacinFinansiranja;
	private JButton btnPotvrdi = new JButton("Potvrdi");
	private JButton btnOdbaci = new JButton("Odustani");
	
	public NoviStudentDialog() {
		
		super(MainFrame.getInstance(), "Dodavanje studenta", true);
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); 
		setResizable(false);

		Color c = new Color(245,245,245);
		setBackground(c);
		
		JPanel background = new JPanel();
		background.setBackground(c);
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		
		StudentKeyListener keyListener = new StudentKeyListener(this);
		controller = new StudentController(this);
		

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	polja	
		
		pIme = new RowPanel("Ime*");
		pIme.getTextField().setName("txtIme");
		pIme.getTextField().addKeyListener(keyListener);
		
		pPrezime = new RowPanel("Prezime*");
		pPrezime.getTextField().setName("txtPrezime");
		pPrezime.getTextField().addKeyListener(keyListener);
		
		pDatumRodjenja = new RowPanel("Datum rodjenja*");
		pDatumRodjenja.getTextField().setToolTipText("Format: dd.mm.yyyy.");
		pDatumRodjenja.getTextField().setName("txtDatumRodjenja");
		pDatumRodjenja.getTextField().addKeyListener(keyListener);
		
		pAdresaStanovanja = new RowPanel("Adresa stanovanja*");
		pAdresaStanovanja.getTextField().setName("txtAdresaStanovanja");
		pAdresaStanovanja.getTextField().addKeyListener(keyListener);
		
		pBrojTelefona = new RowPanel("Kontakt telefon*");
		pBrojTelefona.getTextField().setName("txtBrojTelefona");
		pBrojTelefona.getTextField().addKeyListener(keyListener);
		
		pEMailAdresa = new RowPanel("E-mail adresa*");
		pEMailAdresa.getTextField().setName("txtEMailAdresa");
		pEMailAdresa.getTextField().addKeyListener(keyListener);
		
		pBrojIndexa = new RowPanel("Broj indeksa*");
		pBrojIndexa.getTextField().setToolTipText("Format: ss-BBB-GGGG");
		pBrojIndexa.getTextField().setName("txtBrojIndexa");
		pBrojIndexa.getTextField().addKeyListener(keyListener);
		
		pGodinaUpisa = new RowPanel("Godina upisa*");
		pGodinaUpisa.getTextField().setName("txtGodinaUpisa");
		pGodinaUpisa.getTextField().addKeyListener(keyListener);
		
		String[] godinaStudija = {"1 (prva)", "2 (druga)", "3 (treca)", "4 (četvrta)"};
		pTrenutnaGodinaStudija = new RowPanel("Godina studija*", godinaStudija);

		String[] nacinFinansiranja = {"Budžet", "Samofinansiranje"};
		pNacinFinansiranja = new RowPanel("Način finansiranja*", nacinFinansiranja);
	
        
	    background.add(Box.createVerticalStrut(30));  
	    background.add(pIme);
	    background.add(pPrezime); 
	    background.add(pDatumRodjenja);
	    background.add(pAdresaStanovanja);
	    background.add(pBrojTelefona);
	    background.add(pEMailAdresa); 
	    background.add(pBrojIndexa);
	    background.add(pGodinaUpisa);
	    background.add(pTrenutnaGodinaStudija); 
	    background.add(pNacinFinansiranja);
	    background.add(Box.createVerticalStrut(30));

        add(background, BorderLayout.CENTER);

        
        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(70,70));
        buttons.setBackground(c);
        buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttons.setPreferredSize(new Dimension(50, 50));
		
        formatButton(btnPotvrdi, 1);
        this.disablePotvrdi();
        buttons.add(btnPotvrdi);
        buttons.add(Box.createHorizontalStrut(10));
        btnPotvrdi.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(btnPotvrdi.isEnabled()) {
					boolean temp = controller.dodajStudenta();
					if(temp) 
						dispose();			
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(btnPotvrdi.isEnabled()) {
					btnPotvrdi.setBackground(new Color(228, 244, 255));
					btnPotvrdi.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 1));
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(btnPotvrdi.isEnabled()) {
					btnPotvrdi.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 2));
					btnPotvrdi.setBackground(new Color(230,230,230));
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
		
		JButton btnOdbaci = new JButton("Odustani");
		formatButton(btnOdbaci, 0);
		buttons.add(btnOdbaci);
		buttons.add(Box.createHorizontalStrut(50));
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
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	
        add(buttons, BorderLayout.SOUTH);      
        
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


		public StudentController getController() {
			return controller;
		}


		public void setController(StudentController controller) {
			this.controller = controller;
		}


		public RowPanel getpIme() {
			return pIme;
		}


		public void setpIme(RowPanel pIme) {
			this.pIme = pIme;
		}


		public RowPanel getpPrezime() {
			return pPrezime;
		}


		public void setpPrezime(RowPanel pPrezime) {
			this.pPrezime = pPrezime;
		}


		public RowPanel getpDatumRodjenja() {
			return pDatumRodjenja;
		}


		public void setpDatumRodjenja(RowPanel pDatumRodjenja) {
			this.pDatumRodjenja = pDatumRodjenja;
		}


		public RowPanel getpAdresaStanovanja() {
			return pAdresaStanovanja;
		}


		public void setpAdresaStanovanja(RowPanel pAdresaStanovanja) {
			this.pAdresaStanovanja = pAdresaStanovanja;
		}


		public RowPanel getpBrojTelefona() {
			return pBrojTelefona;
		}


		public void setpBrojTelefona(RowPanel pBrojTelefona) {
			this.pBrojTelefona = pBrojTelefona;
		}


		public RowPanel getpEMailAdresa() {
			return pEMailAdresa;
		}


		public void setpEMailAdresa(RowPanel pEMailAdresa) {
			this.pEMailAdresa = pEMailAdresa;
		}


		public RowPanel getpBrojIndexa() {
			return pBrojIndexa;
		}


		public void setpBrojIndexa(RowPanel pBrojIndexa) {
			this.pBrojIndexa = pBrojIndexa;
		}


		public RowPanel getpGodinaUpisa() {
			return pGodinaUpisa;
		}


		public void setpGodinaUpisa(RowPanel pGodinaUpisa) {
			this.pGodinaUpisa = pGodinaUpisa;
		}


		public RowPanel getpTrenutnaGodinaStudija() {
			return pTrenutnaGodinaStudija;
		}


		public void setpTrenutnaGodinaStudija(RowPanel pTrenutnaGodinaStudija) {
			this.pTrenutnaGodinaStudija = pTrenutnaGodinaStudija;
		}


		public RowPanel getpNacinFinansiranja() {
			return pNacinFinansiranja;
		}


		public void setpNacinFinansiranja(RowPanel pNacinFinansiranja) {
			this.pNacinFinansiranja = pNacinFinansiranja;
		}


		public JButton getBtnPotvrdi() {
			return btnPotvrdi;
		}


		public void setBtnPotvrdi(JButton btnPotvrdi) {
			this.btnPotvrdi = btnPotvrdi;
		}


		public JButton getBtnOdbaci() {
			return btnOdbaci;
		}


		public void setBtnOdbaci(JButton btnOdbaci) {
			this.btnOdbaci = btnOdbaci;
		}

}
