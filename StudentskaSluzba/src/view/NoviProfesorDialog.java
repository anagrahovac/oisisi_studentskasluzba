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

	public NoviProfesorDialog() {
		
		this.setSize(500, 600);
		this.setTitle("Dodavanje profesora");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(MainFrame.getInstance()); //?????????
		this.setVisible(true);
		this.setResizable(false);

		Color gray = new Color(245,245,245);
		this.setBackground(gray);
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(gray);
		BoxLayout box = new BoxLayout(pCenter, BoxLayout.Y_AXIS);
		pCenter.setLayout(box);

		JPanel pIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIme = new JLabel("Ime*");
        JTextField txtIme = new JTextField();
        this.formatLabel(lblIme);
        this.formatTextField(txtIme);
        this.formatRowPanel(pIme, lblIme, txtIme);
		
        JPanel pPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblPrezime = new JLabel("Prezime*");
        JTextField txtPrezime = new JTextField();
        this.formatLabel(lblPrezime);
        this.formatTextField(txtPrezime);
        this.formatRowPanel(pPrezime, lblPrezime, txtPrezime);

        JPanel pDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblDatum = new JLabel("Datum rođenja*");
        JTextField txtDatum = new JTextField();
        this.formatLabel(lblDatum);
        this.formatTextField(txtDatum);
        this.formatRowPanel(pDatum, lblDatum, txtDatum);

        JPanel pAdresaStan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblAdresaStan = new JLabel("Adresa stanovanja*");
        JTextField txtAdresaStan = new JTextField();
        this.formatLabel(lblAdresaStan);
        this.formatTextField(txtAdresaStan);
        this.formatRowPanel(pAdresaStan, lblAdresaStan, txtAdresaStan);

        JPanel pTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTelefon = new JLabel("Kontakt telefon*");
        JTextField txtTelefon = new JTextField();
        this.formatLabel(lblTelefon);
        this.formatTextField(txtTelefon);
        this.formatRowPanel(pTelefon, lblTelefon, txtTelefon);

        JPanel pMail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMail = new JLabel("E-mail adresa*");
        JTextField txtMail = new JTextField();
        this.formatLabel(lblMail);
        this.formatTextField(txtMail);
        this.formatRowPanel(pMail, lblMail, txtMail);
        
        JPanel pAdresaKancelarija = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblAdresaKancelarija = new JLabel("Adresa kancelarije*");
        JTextField txtAdresaKancelarija = new JTextField();
        this.formatLabel(lblAdresaKancelarija);
        this.formatTextField(txtAdresaKancelarija);
        this.formatRowPanel(pAdresaKancelarija, lblAdresaKancelarija, txtAdresaKancelarija);
        
        JPanel pID = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblID = new JLabel("Broj lične karte*");
        JTextField txtID = new JTextField();
        this.formatLabel(lblID);
        this.formatTextField(txtID);
        this.formatRowPanel(pID, lblID, txtID);
        
        JPanel pTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTitula = new JLabel("Titula*");
        String[] titule = { "Doktor", };
		final JComboBox<String> comboTitula = new JComboBox<String>(titule);
        this.formatLabel(lblTitula);
        this.formatComboBox(comboTitula);
        this.formatRowPanel(pTitula, lblTitula, comboTitula);
        
        JPanel pZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblZvanje = new JLabel("Zvanje*");
        String[] zvanja = {"Docent", "Vanredni profesor", "Redovni profesor", };
		final JComboBox<String> comboZvanje = new JComboBox<String>(zvanja);
        this.formatLabel(lblZvanje);
        this.formatComboBox(comboZvanje);
        this.formatRowPanel(pZvanje, lblZvanje, comboZvanje);
        
        
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

        this.add(pCenter, BorderLayout.CENTER);
        
        //panel pBotom za dugmad
        JPanel pBottom = new JPanel();
        pBottom.setPreferredSize(new Dimension(70, 70));
        pBottom.setBackground(gray);
        pBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pBottom.setPreferredSize(new Dimension(50, 50));
		
        JButton btnPotvrdi = new JButton("Potvrdi");
        this.formatButton(btnPotvrdi, 1);
		pBottom.add(btnPotvrdi);
		pBottom.add(Box.createHorizontalStrut(10));
		
		JButton btnOdbaci = new JButton("Odustani");
		this.formatButton(btnOdbaci, 0);
		pBottom.add(btnOdbaci);
		pBottom.add(Box.createHorizontalStrut(50));
		
        add(pBottom, BorderLayout.SOUTH);
        
        
		validate();
	}
	
	private void formatLabel(JLabel lbl) {
		Dimension lblDim = new Dimension(150, 30);
		Font dialog = new Font("Dialog", Font.ITALIC, 14);
		lbl.setPreferredSize(lblDim);
		lbl.setFont(dialog);
	}
	
	private void formatTextField(JTextField txt) {
		Dimension txtDim = new Dimension(250, 30);
        Font dialog = new Font("Dialog", Font.PLAIN, 14);
        txt.setPreferredSize(txtDim);
		txt.setFont(dialog);
	}
	
	private void formatComboBox(JComboBox cb) {
		Dimension cbDim = new Dimension(250, 30);
        Font dialog = new Font("Dialog", Font.PLAIN, 14);
        cb.setPreferredSize(cbDim);
        cb.setFont(dialog);
		cb.setSelectedIndex(0);
		cb.setBackground(Color.WHITE);
	}
	
	private void formatRowPanel(JPanel pan, JLabel lbl, JTextField txt) {
		Color gray = new Color(245,245,245);
		pan.add(Box.createHorizontalStrut(20));
        pan.add(lbl);
        pan.add(txt);
        pan.setBackground(gray);
	}
	
	private void formatRowPanel(JPanel pan, JLabel lbl, JComboBox cb) {
		Color gray = new Color(245,245,245);
		pan.add(Box.createHorizontalStrut(20));
        pan.add(lbl);
        pan.add(cb);
        pan.setBackground(gray);
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