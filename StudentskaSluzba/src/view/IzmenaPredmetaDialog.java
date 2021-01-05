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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.StudentController;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;

public class IzmenaPredmetaDialog extends JDialog{

	private PredmetController controller;
	private RowPanel pSifra;
	private RowPanel pNaziv;
	private RowPanel pGodinaStudija;
	private RowPanel pBrojESPB;
	private RowPanel pSemestar;
	private JTextField txtProfesor;
	private Predmet p;
	private JButton btnPotvrdi = new JButton("Potvrdi");
	private JButton btnOdbaci = new JButton("Odustani");
	private JButton btnPlus;
	private JButton btnMinus;
	
	@SuppressWarnings("deprecation")
	public IzmenaPredmetaDialog(String staraSifra) {
		
		super(MainFrame.getInstance(), "Izmena predmeta", true);
		
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(MainFrame.getInstance()); 
		setResizable(false);
		
		Color c = new Color(245,245,245);
		setBackground(c);
		
		PredmetIzmenaKeyListener keyListener = new PredmetIzmenaKeyListener(this);
		controller = new PredmetController(this);
		controller.getVal().setAllTrue();

		JPanel informacije = new JPanel();
		
		informacije.setBackground(c);
		informacije.setLayout(new BoxLayout(informacije, BoxLayout.Y_AXIS));
		
		p = BazaPredmeta.getInstance().predmetDateSifre(staraSifra);
		
		pSifra = new RowPanel("Šifra predmeta*");
			pSifra.getTextField().setToolTipText("Format: SBBB, npr: T123");
			pSifra.getTextField().setText(p.getSifraPredmeta());
			pSifra.getTextField().setName("txtSifra");
			pSifra.getTextField().addKeyListener(keyListener);
		
		pNaziv = new RowPanel("Naziv*");
			pNaziv.getTextField().setText(p.getNazivPredmeta());
			pNaziv.getTextField().setName("txtNaziv");
			pNaziv.getTextField().addKeyListener(keyListener);
		
		pGodinaStudija = new RowPanel("Godina studija*");
			pGodinaStudija.getTextField().setText(Integer.toString(p.getGodinaStudija()));
			pGodinaStudija.getTextField().setName("txtGodinaStudija");
			pGodinaStudija.getTextField().addKeyListener(keyListener);
		
		Color gray = new Color(245,245,245);
		JPanel pProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblProfesor = new JLabel("Profesor*");
			Dimension lblDim = new Dimension(150, 30);
			Font dialog = new Font("Dialog", Font.ITALIC, 14);
			lblProfesor.setPreferredSize(lblDim);
			lblProfesor.setFont(dialog);
		txtProfesor = new JTextField();
		txtProfesor.setName("txtProfesor");
		txtProfesor.setText(p.getImePrezimeProfesora());
		txtProfesor.setEditable(false);
		txtProfesor.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		txtProfesor.setBackground(Color.white);
			Dimension txtDim = new Dimension(180, 30);
	        Font dialog1 = new Font("Dialog", Font.PLAIN, 14);
	        txtProfesor.setPreferredSize(txtDim);
	        txtProfesor.setFont(dialog1);
	        
	    btnPlus = new JButton("+");
	    	Dimension btnDim = new Dimension(30,30);
	    	Font dialog2 = new Font("Dialog", Font.BOLD, 14);
	    	btnPlus.setPreferredSize(btnDim);
	    	btnPlus.setFont(dialog2);
	    	btnPlus.setBackground(Color.white);
	    	btnPlus.setToolTipText("Dodaj profesora");
	    	btnPlus.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
	    	
	    	if(txtProfesor.getText().isEmpty() || txtProfesor.getText() == null || txtProfesor.getText().equals("")) {
	 			btnPlus.setEnabled(true);
	 		} else {
	 			btnPlus.setEnabled(false);
	 		}

	   dodajListener(this, staraSifra);
	    	
	    btnMinus = new JButton("-");
	    	btnMinus.setPreferredSize(btnDim);
	    	btnMinus.setFont(dialog2);
	    	btnMinus.setBackground(Color.white);
	    	btnMinus.setToolTipText("Obriši profesora");
	    	btnMinus.setBorder(BorderFactory.createLineBorder(Color.gray,1));	    
			
			if(txtProfesor.getText().isEmpty() || txtProfesor.getText() == null || txtProfesor.getText().equals("")) {
				btnMinus.setEnabled(false);
			} else {
				btnMinus.setEnabled(true);
			}
	    	
	    btnMinus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	    	
	    pProfesor.add(Box.createHorizontalStrut(20));
	    pProfesor.add(lblProfesor);
	    pProfesor.add(txtProfesor);
	    pProfesor.add(btnPlus);
	    pProfesor.add(btnMinus);
		pProfesor.setBackground(gray);
		
		pBrojESPB = new RowPanel("Broj ESPB bodova*");
			pBrojESPB.getTextField().setText(Integer.toString(p.getBrojBodova()));
			pBrojESPB.getTextField().setName("txtBrojESPB");
			pBrojESPB.getTextField().addKeyListener(keyListener);
		
		String[] semestar = { "letnji", "zimski"};
		pSemestar = new RowPanel("Semestar*", semestar);
		pSemestar.getComboBox().setSelectedIndex(p.getSemestar().ordinal());
		
		
		
		informacije.add(Box.createVerticalStrut(30));  
		informacije.add(pSifra);
		informacije.add(pNaziv); 
		informacije.add(pGodinaStudija);
		informacije.add(pBrojESPB);
		informacije.add(pSemestar);
		informacije.add(pProfesor);
		informacije.add(Box.createVerticalStrut(150));
		
	    
		
	    JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(70,70));
        buttons.setBackground(c);
        buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttons.setPreferredSize(new Dimension(50, 50));
		
        formatButton(btnPotvrdi, 1);
        formatButton(btnOdbaci, 0);
		btnPotvrdi.setToolTipText("Izmeni predmet");
		btnOdbaci.setToolTipText("Odustani od izmene predmeta");
		enablePotvrdi();
				
		btnPotvrdi.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(btnPotvrdi.isEnabled()) {
						boolean succ = controller.izmeniPredmet(BazaPredmeta.getInstance().pronadjiPredmet1(staraSifra));
						if(succ == true) {
							JOptionPane.showMessageDialog(null, "Predmet uspešno izmenjen.");
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Šifra predmeta već postoji u bazi!");
						}
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
        
        this.add(informacije,BorderLayout.CENTER);
	    	    
	    validate();
	}
	
	public void dodajListener(IzmenaPredmetaDialog i, String staraSifra) {
	 btnPlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DodajProfesoraDialog dialog = new DodajProfesoraDialog(MainFrame.getInstance(), staraSifra, i);
				dialog.setVisible(true);
			}
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
	
	public void azurirajPredmet(JTextField txt, Predmet p,IzmenaPredmetaDialog i) {
		txt.setText(p.getImePrezimeProfesora());
		
		if(txt.getText().isEmpty() || txt.getText() == null || txt.getText().equals("")) {
			i.getBtnPlus().setEnabled(true);
		} else {
			i.getBtnPlus().setEnabled(false);
		}
		
		if(txt.getText().isEmpty() || txt.getText() == null || txt.getText().equals("")) {
			i.getBtnMinus().setEnabled(false);
		} else {
			i.getBtnMinus().setEnabled(true);
		}
	}
	
	
	
	public Predmet getP() {
		return p;
	}

	public void setP(Predmet p) {
		this.p = p;
	}

	public JTextField getTxtProfesor() {
		return txtProfesor;
	}

	public void setTxtProfesor(JTextField txtProfesor) {
		this.txtProfesor = txtProfesor;
	}

	public PredmetController getController() {
		return controller;
	}
	public void setController(PredmetController controller) {
		this.controller = controller;
	}
	public RowPanel getpSifra() {
		return pSifra;
	}
	public void setpSifra(RowPanel pSifra) {
		this.pSifra = pSifra;
	}
	public RowPanel getpNaziv() {
		return pNaziv;
	}
	public void setpNaziv(RowPanel pNaziv) {
		this.pNaziv = pNaziv;
	}
	public RowPanel getpGodinaStudija() {
		return pGodinaStudija;
	}
	public void setpGodinaStudija(RowPanel pGodinaStudija) {
		this.pGodinaStudija = pGodinaStudija;
	}
	public RowPanel getpBrojESPB() {
		return pBrojESPB;
	}
	public void setpBrojESPB(RowPanel pBrojESPB) {
		this.pBrojESPB = pBrojESPB;
	}
	public RowPanel getpSemestar() {
		return pSemestar;
	}
	public void setpSemestar(RowPanel pSemestar) {
		this.pSemestar = pSemestar;
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

	public JButton getBtnPlus() {
		return btnPlus;
	}

	public void setBtnPlus(JButton btnPlus) {
		this.btnPlus = btnPlus;
	}

	public JButton getBtnMinus() {
		return btnMinus;
	}

	public void setBtnMinus(JButton btnMinus) {
		this.btnMinus = btnMinus;
	}
	
	
}
