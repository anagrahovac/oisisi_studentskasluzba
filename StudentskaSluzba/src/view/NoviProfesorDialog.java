package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NoviProfesorDialog extends JDialog{

	private static final long serialVersionUID = -4480924644161247106L;

public NoviProfesorDialog() {
		
		//super(MainFrame.getInstance(), "Dodavanje profesora", true);
		this.setSize(500, 600);
		this.setTitle("Dodavanje profesora");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setVisible(true);
		this.setResizable(false);

		Color gray = new Color(245,245,245);
		this.setBackground(gray);
		
		
		//centralni panel za unos podataka
		JPanel pCenter = new JPanel();
		pCenter.setBackground(gray);
		BoxLayout box = new BoxLayout(pCenter, BoxLayout.Y_AXIS);
		pCenter.setLayout(box);
		this.add(pCenter, BorderLayout.CENTER);
		
        
		RowPanel pIme = new RowPanel("Ime*");
		RowPanel pPrezime = new RowPanel("Prezime*");
		RowPanel pDatum = new RowPanel("Datum rodjenja*");
		RowPanel pAdresaStan = new RowPanel("Adresa stanovanja*");
		RowPanel pTelefon = new RowPanel("Kontakt telefon*");
		RowPanel pMail = new RowPanel("E-mail adresa*");
		RowPanel pAdresaKancelarija = new RowPanel("Adresa kancelarije*");
		RowPanel pID = new RowPanel("Broj licne karte*");
		
		String[] titule = { "Doktor", };
		RowPanel pTitula = new RowPanel("Titula*", titule);

        String[] zvanja = {"Docent", "Vanredni profesor", "Redovni profesor", };
		RowPanel pZvanje = new RowPanel("Zvanje*", zvanja);
		
        pCenter.add(Box.createVerticalStrut(30));  
        pCenter.add(pIme);
        pCenter.add(pPrezime); 
        pCenter.add(pDatum);
        pCenter.add(pAdresaStan);
        pCenter.add(pTelefon);
        pCenter.add(pMail); 
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
		
        JButton btnPotvrdi = new JButton("Potvrdi");
        this.formatButton(btnPotvrdi, 1);
		pBottom.add(btnPotvrdi);
		pBottom.add(Box.createHorizontalStrut(10));
		
		JButton btnOdbaci = new JButton("Odustani");
		this.formatButton(btnOdbaci, 0);
		pBottom.add(btnOdbaci);
		pBottom.add(Box.createHorizontalStrut(50));
        
        
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
}