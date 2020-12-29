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
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import controller.StudentController;
import model.BazaStudenata;
import model.Student;

public class IzmenaStudentaDialog extends JDialog{

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
	
	public IzmenaStudentaDialog() {
		super(MainFrame.getInstance(), "Izmena studenta", true);
		
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); 
		setResizable(false);
		
		Color c = new Color(245,245,245);
		setBackground(c);
		
		StudentIzmenaKeyListener keyListener = new StudentIzmenaKeyListener(this);
		controller = new StudentController(this);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		Font f = new Font("Dialog", Font.PLAIN, 14);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(f);
		
		JPanel informacije = new JPanel();
		JPanel polozeni = new JPanel();
		JPanel nepolozeni = new JPanel();
		
		tabbedPane.addTab("Informacije", null, informacije, "Panel s informacijama");
		tabbedPane.addTab("Položeni", null, polozeni, "Panel s položenim predmetima");
		tabbedPane.addTab("Nepoloženi", null, nepolozeni, "Panel s nepoloženim predmetima");
		this.add(tabbedPane, BorderLayout.CENTER);
		
		informacije.setBackground(c);
		informacije.setLayout(new BoxLayout(informacije, BoxLayout.Y_AXIS));
		
		int i = MainFrame.getInstance().getStudentiTable().getSelectedRow();
		Student s = new Student();
		if(i == -1) {
			JOptionPane.showMessageDialog(this, "Niste selektovali studenta za izmenu!");
			return;
		}else {
			String indeks = (String) MainFrame.getInstance().getStudentiTable().getValueAt(i, 0);
			s = BazaStudenata.getInstance().studentDatogIndeksa(indeks);
		}	
		
		pIme = new RowPanel("Ime*");
			pIme.getTextField().setText(s.getImeStudenta());
			pIme.getTextField().setName("txtIme");
			pIme.getTextField().addKeyListener(keyListener);
		pPrezime = new RowPanel("Prezime*");
			pPrezime.getTextField().setText(s.getPrezimeStudenta());
			pPrezime.getTextField().setName("txtPrezime");
			pPrezime.getTextField().addKeyListener(keyListener);
		pDatumRodjenja = new RowPanel("Datum rodjenja*");
			pDatumRodjenja.getTextField().setText(s.getDatumRodjenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
			pDatumRodjenja.getTextField().setName("txtDatumRodjenja");
			pDatumRodjenja.getTextField().addKeyListener(keyListener);
		pAdresaStanovanja = new RowPanel("Adresa stanovanja*");
			pAdresaStanovanja.getTextField().setText(s.getAdresaStanovanja());
			pAdresaStanovanja.getTextField().setName("txtAdresaStanovanja");
			pAdresaStanovanja.getTextField().addKeyListener(keyListener);
		pBrojTelefona = new RowPanel("Kontakt telefon*");
			pBrojTelefona.getTextField().setText(s.getKontaktTelefon());
			pBrojTelefona.getTextField().setName("txtBrojTelefona");
			pBrojTelefona.getTextField().addKeyListener(keyListener);
		pEMailAdresa = new RowPanel("E-mail adresa*");
			pEMailAdresa.getTextField().setText(s.getEmailAdresa());
			pEMailAdresa.getTextField().setName("txtEMailAdresa");
			pEMailAdresa.getTextField().addKeyListener(keyListener);
		pBrojIndexa = new RowPanel("Broj indeksa*");
			pBrojIndexa.getTextField().setText(s.getBrojIndexa());
			pBrojIndexa.getTextField().setName("txtBrojIndexa");
			pBrojIndexa.getTextField().addKeyListener(keyListener);
		pGodinaUpisa = new RowPanel("Godina upisa*");
			pGodinaUpisa.getTextField().setText(Integer.toString(s.getGodinaUpisa()));
			pGodinaUpisa.getTextField().setName("txtGodinaUpisa");
			pGodinaUpisa.getTextField().addKeyListener(keyListener);
		String[] godinaStudija = {"1 (prva)", "2 (druga)", "3 (treca)", "4 (četvrta)"};
		pTrenutnaGodinaStudija = new RowPanel("Godina studija*", godinaStudija);
			pTrenutnaGodinaStudija.getComboBox().setSelectedIndex(s.getTrenutnaGodinaStudija()-1);
		String[] nacinFinansiranja = {"Budžet", "Samofinansiranje"};
		pNacinFinansiranja = new RowPanel("Način finansiranja*", nacinFinansiranja);
			pNacinFinansiranja.getComboBox().setSelectedIndex(s.getStatus().ordinal());
		
		informacije.add(Box.createVerticalStrut(30));  
		informacije.add(pIme);
		informacije.add(pPrezime); 
		informacije.add(pDatumRodjenja);
		informacije.add(pAdresaStanovanja);
		informacije.add(pBrojTelefona);
		informacije.add(pEMailAdresa); 
		informacije.add(pBrojIndexa);
		informacije.add(pGodinaUpisa);
		informacije.add(pTrenutnaGodinaStudija); 
		informacije.add(pNacinFinansiranja);
		informacije.add(Box.createVerticalStrut(50));
		
		JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(70,70));
        buttons.setBackground(c);
        buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttons.setPreferredSize(new Dimension(50, 50));
		
        formatButton(btnPotvrdi, 1);
        formatButton(btnOdbaci, 0);
		btnPotvrdi.setToolTipText("Izmeni studenta");
		btnOdbaci.setToolTipText("Odustani od izmene studenta");
		
				
		btnPotvrdi.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if(btnPotvrdi.isEnabled()) {
						controller.izmeniStudenta();	
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
		 
		 btnOdbaci.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Object[] daNe = {"Da", "Ne"};
					int code = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da odbacite izmene?", "Message", JOptionPane.YES_NO_OPTION, 
															JOptionPane.QUESTION_MESSAGE, null, daNe, daNe[0]);
					if (code == JOptionPane.YES_OPTION) 
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
		
        buttons.add(btnPotvrdi);
        buttons.add(btnOdbaci);
        buttons.add(Box.createHorizontalStrut(10));
        
        informacije.add(buttons, BorderLayout.SOUTH);      
	    	    
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
