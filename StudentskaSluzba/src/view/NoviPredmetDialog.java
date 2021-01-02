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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;

public class NoviPredmetDialog extends JDialog{
	
	private static final long serialVersionUID = -551273725662555210L;
	
	private PredmetController controller;
	private RowPanel pSifra;
	private RowPanel pNaziv;
	private RowPanel pGodinaStudija;
	private JTextField txtProfesor;
	private RowPanel pBrojESPB;
	private RowPanel pSemestar;
	private JButton btnPotvrdi = new JButton("Potvrdi");
	private JButton btnOdbaci = new JButton("Odustani");
	

	public NoviPredmetDialog(final JFrame parent) {
		
		super(MainFrame.getInstance(), "Dodavanje predmeta", true);
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(MainFrame.getInstance()); 
		setResizable(false);

		Color c = new Color(245,245,245);
		setBackground(c);
		
		JPanel background = new JPanel();
		background.setBackground(c);
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		
		PredmetKeyListener keyListener = new PredmetKeyListener(this);
		controller = new PredmetController(this);

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	polja	
		
		pSifra = new RowPanel("Šifra predmeta*");
		pSifra.getTextField().setToolTipText("Format: SBBB, npr: T123");
		pSifra.getTextField().setName("txtSifra");
		pSifra.getTextField().addKeyListener(keyListener);
		
		pNaziv = new RowPanel("Naziv*");
		pNaziv.getTextField().setName("txtNaziv");
		pNaziv.getTextField().addKeyListener(keyListener);
		
		pGodinaStudija = new RowPanel("Godina studija*");
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
		//txtProfesor.setText("ZDRAVOOO!!");
		txtProfesor.setEditable(false);
		txtProfesor.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		txtProfesor.setBackground(Color.white);
			Dimension txtDim = new Dimension(180, 30);
	        Font dialog1 = new Font("Dialog", Font.PLAIN, 14);
	        txtProfesor.setPreferredSize(txtDim);
	        txtProfesor.setFont(dialog1);
	    JButton btnPlus = new JButton("+");
	    	Dimension btnDim = new Dimension(30,30);
	    	Font dialog2 = new Font("Dialog", Font.BOLD, 14);
	    	btnPlus.setPreferredSize(btnDim);
	    	btnPlus.setFont(dialog2);
	    	btnPlus.setBackground(Color.white);
	    	btnPlus.setToolTipText("Dodaj profesora");
	    	btnPlus.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
	    
	    btnPlus.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
					DodajProfDialog dialog = new DodajProfDialog(parent);
					dialog.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
	    
	    JButton btnMinus = new JButton("-");
	    	btnMinus.setPreferredSize(btnDim);
	    	btnMinus.setFont(dialog2);
	    	btnMinus.setBackground(Color.white);
	    	btnMinus.setToolTipText("Obriši profesora");
	    	btnMinus.setBorder(BorderFactory.createLineBorder(Color.gray,1));
	    	
	    btnMinus.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(txtProfesor.getText() != "") {
					txtProfesor.setText("");
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
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
		pBrojESPB.getTextField().setName("txtBrojESPB");
		pBrojESPB.getTextField().addKeyListener(keyListener);
		
		String[] semestar = { "letnji", "zimski"};
		pSemestar = new RowPanel("Semestar*", semestar);

		
		        
	    background.add(Box.createVerticalStrut(30));  
	    background.add(pSifra);
	    background.add(pNaziv); 
	    background.add(pGodinaStudija);
	    background.add(pProfesor);
	    background.add(pBrojESPB);
	    background.add(pSemestar); 
	    background.add(Box.createVerticalStrut(150));

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
					boolean temp = controller.dodajPredmet();
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


		//public RowPanel getpProfesor() {
		//	return pProfesor;
		//}


		//public void setpProfesor(RowPanel pProfesor) {
		//	this.pProfesor = pProfesor;
		//}


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


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		public JTextField getTxtProfesor() {
			return txtProfesor;
		}


		public void setTxtProfesor(JTextField txtProfesor) {
			this.txtProfesor = txtProfesor;
		}
		
		
}
