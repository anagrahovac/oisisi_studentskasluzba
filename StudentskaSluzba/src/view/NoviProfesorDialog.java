package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NoviProfesorDialog extends JDialog {
public NoviProfesorDialog() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height * 11 / 20 ;
		int screenWidth = screenSize.width * 3 / 12;
		setSize(screenWidth, screenHeight);
		setTitle("Dodavanje profesora");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		Color c = new Color(245,245,245);
		setBackground(c);
		setVisible(true);
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(c);
		BoxLayout box = new BoxLayout(pCenter, BoxLayout.Y_AXIS);
		pCenter.setLayout(box);
		
		
		Dimension lblDim = new Dimension(150, 30);
		Dimension txtDim = new Dimension(250, 30);
		
		JPanel pIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIme = new JLabel("Ime*");
        lblIme.setPreferredSize(lblDim);
        JTextField txtIme=new JTextField();
        txtIme.setPreferredSize(txtDim);
		pIme.add(Box.createHorizontalStrut(10));
        pIme.add(lblIme);
        pIme.add(txtIme);
        pIme.setBackground(c);
        
        JPanel pPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblPrezime = new JLabel("Prezime*");
        lblPrezime.setPreferredSize(lblDim);
        JTextField txtPrezime = new JTextField();
        txtPrezime.setPreferredSize(txtDim);
        pPrezime.add(Box.createHorizontalStrut(10));
        pPrezime.add(lblPrezime);
        pPrezime.add(txtPrezime);
        pPrezime.setBackground(c);

        JPanel pDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblDatum = new JLabel("Datum rodjenja*");
        lblDatum.setPreferredSize(lblDim);
        JTextField txtDatum = new JTextField();
        txtDatum.setPreferredSize(txtDim);
        pDatum.add(Box.createHorizontalStrut(10));
        pDatum.add(lblDatum);
        pDatum.add(txtDatum);
        pDatum.setBackground(c);

        JPanel pAdresaStan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblAdresaStan = new JLabel("Adresa stanovanja*");
        lblAdresaStan.setPreferredSize(lblDim);
        JTextField txtAdresaStan = new JTextField();
        txtAdresaStan.setPreferredSize(txtDim);
        pAdresaStan.add(Box.createHorizontalStrut(10));
        pAdresaStan.add(lblAdresaStan);
        pAdresaStan.add(txtAdresaStan);
        pAdresaStan.setBackground(c);

        JPanel pTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTelefon = new JLabel("Kontakt telefon*");
        lblTelefon.setPreferredSize(lblDim);
        JTextField txtTelefon = new JTextField();
        txtTelefon.setPreferredSize(txtDim);
        pTelefon.add(Box.createHorizontalStrut(10));
        pTelefon.add(lblTelefon);
        pTelefon.add(txtTelefon);
        pTelefon.setBackground(c);

        JPanel pMail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMail = new JLabel("E-mail adresa*");
        lblMail.setPreferredSize(lblDim);
        JTextField txtMail = new JTextField();
        txtMail.setPreferredSize(txtDim);
        pMail.add(Box.createHorizontalStrut(10));
        pMail.add(lblMail);
        pMail.add(txtMail);
        pMail.setBackground(c);
        
        JPanel pAdresaKancelarija = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblAdresaKancelarija = new JLabel("Adresa kancelarije*");
        lblAdresaKancelarija.setPreferredSize(lblDim);
        JTextField txtAdresaKancelarija = new JTextField();
        txtAdresaKancelarija.setPreferredSize(txtDim);
        pAdresaKancelarija.add(Box.createHorizontalStrut(10));
        pAdresaKancelarija.add(lblAdresaKancelarija);
        pAdresaKancelarija.add(txtAdresaKancelarija);
        pAdresaKancelarija.setBackground(c);
        
        JPanel pID = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblID = new JLabel("Broj licne karte*");
        lblID.setPreferredSize(lblDim);
        JTextField txtID = new JTextField();
        txtID.setPreferredSize(txtDim);
        pID.add(Box.createHorizontalStrut(10));
        pID.add(lblID);
        pID.add(txtID);
        pID.setBackground(c);
        
        Color bgc = new Color(255, 255, 255);
        
        JPanel pTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTitula = new JLabel("Titula*");
        lblTitula.setPreferredSize(lblDim);
        String[] titule = { "Doktor", };
		final JComboBox<String> comboTitula = new JComboBox<String>(titule);
		comboTitula.setSelectedIndex(0);
		comboTitula.setPreferredSize(txtDim);
		comboTitula.setBackground(bgc);
        pTitula.add(Box.createHorizontalStrut(10));
        pTitula.add(lblTitula);
        pTitula.add(comboTitula);
        pTitula.setBackground(c);
        
        JPanel pZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblZvanje = new JLabel("Zvanje*");
        lblZvanje.setPreferredSize(lblDim);
        String[] zvanja = { "Docent", "Vanredni profesor", "Redovni profesor", };
		final JComboBox<String> comboZvanje = new JComboBox<String>(zvanja);
		comboZvanje.setSelectedIndex(0);
        comboZvanje.setPreferredSize(txtDim);
		comboZvanje.setBackground(bgc);
        pZvanje.add(Box.createHorizontalStrut(10));
        pZvanje.add(lblZvanje);
        pZvanje.add(comboZvanje);
        pZvanje.setBackground(c);
        
        
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
		//pCenter.add(Box.createGlue());

        add(pCenter, BorderLayout.CENTER);
        
        //panel pBotom za dugmad
        JPanel pBottom = new JPanel();
        pBottom.setBackground(c);
        pBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pBottom.setPreferredSize(new Dimension(50, 50));
        Dimension btnDim = new Dimension(100, 30);
        
        JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setToolTipText("Sacuvaj unete podatke");
		btnPotvrdi.setPreferredSize(btnDim);
		pBottom.add(btnPotvrdi);
		pBottom.add(Box.createHorizontalStrut(10));
		
		JButton btnOdbaci = new JButton("Odustani");
		btnOdbaci.setToolTipText("Odbaci unete podatke");
		btnOdbaci.setPreferredSize(btnDim);
		pBottom.add(btnOdbaci);
		pBottom.add(Box.createHorizontalStrut(30));
		
        add(pBottom, BorderLayout.SOUTH);
        
        
		validate();
	}
}
