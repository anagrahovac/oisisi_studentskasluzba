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

import model.Predmet;
import model.Student;

public class PolaganjeDialog extends JDialog {
	
	private static final long serialVersionUID = 4731850010254668706L;
	
	private Student student;
	private Predmet predmet;
	private IzmenaStudentaDialog parent;
	
	private RowPanel pSifra;
	private RowPanel pNaziv;
	private RowPanel pOcena;
	private RowPanel pDatum;

	private JButton btnPotvrdi = new JButton("Potvrdi");
	private JButton btnOdbaci = new JButton("Odustani");
	
	public PolaganjeDialog(IzmenaStudentaDialog parent, Student s, Predmet p) {
		super(parent, "Unos ocene", true);
		this.setSize(500, 400);
		//this.setTitle("Polaganje predmeta");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setResizable(false);
		student = s;
		predmet = p;
		this.parent = parent;

		Color gray = new Color(245,245,245);
		this.setBackground(gray);
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(gray);
		BoxLayout box = new BoxLayout(pCenter, BoxLayout.Y_AXIS);
		pCenter.setLayout(box);
		this.add(pCenter, BorderLayout.CENTER);
		
		OcenaKeyListener ol = new OcenaKeyListener(this);
		
		pSifra = new RowPanel("Sifra*");
		pSifra.getTextField().setText(predmet.getSifraPredmeta());
		pSifra.getTextField().setEditable(false);
		
		pNaziv = new RowPanel("Naziv*");
		pNaziv.getTextField().setText(predmet.getNazivPredmeta());
		pNaziv.getTextField().setEditable(false);
		
		String[] ocene = { "6", "7", "8", "9", "10", };
		pOcena = new RowPanel("Ocena*", ocene);
		
		pDatum = new RowPanel("Datum*");
		pDatum.getTextField().setName("txtDatum");
		pDatum.getTextField().addKeyListener(ol);
		pDatum.getTextField().setToolTipText("Format: dd.mm.yyyy.");
		
		pCenter.add(Box.createVerticalStrut(30));
		pCenter.add(pNaziv);
        pCenter.add(pSifra); 
        pCenter.add(pOcena);
        pCenter.add(pDatum);
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
					int ocena = pOcena.getComboBox().getSelectedIndex() + 6;
					String datum = pDatum.getTextField().getText();
					boolean ok = parent.getController().poloziPredmet(student, predmet, ocena, datum);
					parent.azurirajProsekESPB(parent.getProsek(), parent.getEspb(), student.getBrojIndexa());
					if (ok) {
						JOptionPane.showMessageDialog(null, "Predmet dodat u polozene.");
						dispose();
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
}
