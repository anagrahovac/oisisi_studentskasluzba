package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controller.StudentController;


public class NoviStudentDialog extends JDialog{
	
	private static final long serialVersionUID = 0;
	
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
		
		setSize(500, 600);
		setTitle("Dodavanje studenta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); 
		setResizable(false);
		setVisible(true);

		Color c = new Color(245,245,245);
		setBackground(c);
		
		JPanel background = new JPanel();
		background.setBackground(c);
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		
		StudentFocusListener focusListener = new StudentFocusListener();
		controller = new StudentController(this);
		

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	polja	
		
		pIme = new RowPanel("Ime*");
		pIme.getTextField().setName("txtIme");
		pIme.getTextField().addFocusListener(focusListener);
		
		pPrezime = new RowPanel("Prezime*");
		pPrezime.getTextField().setName("txtPrezime");
		pPrezime.getTextField().addFocusListener(focusListener);
		
		pDatumRodjenja = new RowPanel("Datum rodjenja*");
		pDatumRodjenja.getTextField().setToolTipText("Format: dd.mm.yyyy.");
		pDatumRodjenja.getTextField().setName("txtDatumRodjenja");
		pDatumRodjenja.getTextField().addFocusListener(focusListener);
		
		pAdresaStanovanja = new RowPanel("Adresa stanovanja*");
		pAdresaStanovanja.getTextField().setName("txtAdresaStanovanja");
		pAdresaStanovanja.getTextField().addFocusListener(focusListener);
		
		pBrojTelefona = new RowPanel("Kontakt telefon*");
		pBrojTelefona.getTextField().setName("txtBrojTelefona");
		pBrojTelefona.getTextField().addFocusListener(focusListener);
		
		pEMailAdresa = new RowPanel("E-mail adresa*");
		pEMailAdresa.getTextField().setName("txtEMailAdresa");
		pEMailAdresa.getTextField().addFocusListener(focusListener);
		
		pBrojIndexa = new RowPanel("Broj indeksa");
		pBrojIndexa.getTextField().setName("txtBrojIndexa");
		pBrojIndexa.getTextField().addFocusListener(focusListener);
		
		pGodinaUpisa = new RowPanel("Godina upisa*");
		pGodinaUpisa.getTextField().setName("txtGodinaUpisa");
		pGodinaUpisa.getTextField().addFocusListener(focusListener);
		
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
		
        JButton btnPotvrdi = new JButton("Potvrdi");
        btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(pIme.getTextField().getText().trim().equals("") 
						|| pPrezime.getTextField().getText().trim().equals("") 
						|| pDatumRodjenja.getTextField().getText().trim().equals("")
						|| pAdresaStanovanja.getTextField().getText().trim().equals("") 
						|| pBrojTelefona.getTextField().getText().trim().equals("") 
						|| pEMailAdresa.getTextField().getText().trim().equals("")
						|| pBrojIndexa.getTextField().getText().trim().equals("") 
						|| pGodinaUpisa.getTextField().getText().trim().equals(""))  {
					//JOptionPane.showMessageDialog(background, "Sva polja moraju biti popunjena kako biste dodali studenta!");
					btnPotvrdi.setEnabled(false);
					btnPotvrdi.setForeground(new Color(150, 150, 150));
					btnPotvrdi.setBackground(new Color(220, 220, 220));
					btnPotvrdi.setForeground(new Color(150, 150, 150));
				} else {
				JOptionPane.showMessageDialog(null, "Student je dodat.");
				btnPotvrdi.setEnabled(true);
				dispose();
				}
			}
        	
        });	
        btnPotvrdi.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnPotvrdi.isEnabled()) {
					boolean succ = controller.dodajStudenta();
					if(succ == true) {
						//JOptionPane.showMessageDialog(null, "Student uspešno dodat u bazu.");
						dispose();
					}
					else {
						//JOptionPane.showMessageDialog(null, "Broj indeksa već postoji u bazi!");
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
        formatButton(btnPotvrdi, 1);
        buttons.add(btnPotvrdi);
        buttons.add(Box.createHorizontalStrut(10));
		
		JButton btnOdbaci = new JButton("Odustani");
		btnOdbaci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
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
		formatButton(btnOdbaci, 0);
		buttons.add(btnOdbaci);
		buttons.add(Box.createHorizontalStrut(50));
		
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
