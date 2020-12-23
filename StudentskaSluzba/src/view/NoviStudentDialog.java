package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class NoviStudentDialog extends JDialog{
	
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
		

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	polja		
		
		JPanel pIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*");
		JTextField txtIme = new JTextField();
		txtIme.setName("txtIme");
		txtIme.addFocusListener(focusListener);
		formatLabel(lblIme);
        formatTextField(txtIme);
        formatRowPanel(pIme, lblIme, txtIme);
        
        JPanel pPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*");
		JTextField txtPrezime = new JTextField();
		txtPrezime.setName("txtPrezime");
		txtPrezime.addFocusListener(focusListener);
		formatLabel(lblPrezime);
        formatTextField(txtPrezime);
        formatRowPanel(pPrezime, lblPrezime, txtPrezime);
        
        JPanel pDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatumRodjenja = new JLabel("Datum rodjenja*");
		JTextField txtDatumRodjenja = new JTextField();
		txtDatumRodjenja.setName("txtDatumRodjenja");
		txtDatumRodjenja.addFocusListener(focusListener);
		formatLabel(lblDatumRodjenja);
        formatTextField(txtDatumRodjenja);
        formatRowPanel(pDatumRodjenja, lblDatumRodjenja, txtDatumRodjenja);
        
        JPanel pAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja*");
		JTextField txtAdresaStanovanja = new JTextField();
		txtAdresaStanovanja.setName("txtAdresaStanovanja");
		txtAdresaStanovanja.addFocusListener(focusListener);
		formatLabel(lblAdresaStanovanja);
        formatTextField(txtAdresaStanovanja);
        formatRowPanel(pAdresaStanovanja, lblAdresaStanovanja, txtAdresaStanovanja);
        
        JPanel pBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojTelefona = new JLabel("Broj telefona*");
		JTextField txtBrojTelefona = new JTextField();
		txtBrojTelefona.setName("txtBrojTelefona");
		txtBrojTelefona.addFocusListener(focusListener);
		formatLabel(lblBrojTelefona);
        formatTextField(txtBrojTelefona);
        formatRowPanel(pBrojTelefona, lblBrojTelefona, txtBrojTelefona);
        
        JPanel pEMailAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEMailAdresa = new JLabel("E-mail adresa*");
		JTextField txtEMailAdresa = new JTextField();
		txtEMailAdresa.setName("txtEMailAdresa");
		txtEMailAdresa.addFocusListener(focusListener);
		formatLabel(lblEMailAdresa);
        formatTextField(txtEMailAdresa);
        formatRowPanel(pEMailAdresa, lblEMailAdresa, txtEMailAdresa);
        
        JPanel pBrojIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojIndexa = new JLabel("Broj indeksa*");
		JTextField txtBrojIndexa = new JTextField();
		txtBrojIndexa.setName("txtBrojIndexa");
		txtBrojIndexa.addFocusListener(focusListener);
		formatLabel(lblBrojIndexa);
        formatTextField(txtBrojIndexa);
        formatRowPanel(pBrojIndexa, lblBrojIndexa, txtBrojIndexa);
        
        JPanel pGodinaUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodinaUpisa = new JLabel("Godina upisa*");
		JTextField txtGodinaUpisa = new JTextField();
		txtGodinaUpisa.setName("txtGodinaUpisa");
		txtGodinaUpisa.addFocusListener(focusListener);
		formatLabel(lblGodinaUpisa);
        formatTextField(txtGodinaUpisa);
        formatRowPanel(pGodinaUpisa, lblGodinaUpisa, txtGodinaUpisa);
        
        JPanel pTrenutnaGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTrenutnaGodinaStudija = new JLabel("Godina studija*");
		String[] godinaStudija = {"odaberite polje", "1 (prva)", "2 (druga)", "3 (treca)", "4 (četvrta)"};
		final JComboBox<String> comboGodStu = new JComboBox<String>(godinaStudija);
		formatLabel(lblTrenutnaGodinaStudija);
        formatComboBox(comboGodStu);
        formatRowPanel(pTrenutnaGodinaStudija, lblTrenutnaGodinaStudija, comboGodStu);
        
        JPanel pNacinFinansiranja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNacinFinansiranja = new JLabel("Način finansiranja*");
		String[] nacinFinansiranja = {"odaberite polje", "Budžet", "Samofinansiranje"};
		final JComboBox<String> comboNacFinan = new JComboBox<String>(nacinFinansiranja);
		formatLabel(lblNacinFinansiranja);
	    formatComboBox(comboNacFinan);
	    formatRowPanel(pNacinFinansiranja, lblNacinFinansiranja, comboNacFinan);
	   
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        
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
        
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	dugmad validacije
	
        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(70,70));
        buttons.setBackground(c);
        buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttons.setPreferredSize(new Dimension(50, 50));
		
        JButton btnPotvrdi = new JButton("Potvrdi");
        formatButton(btnPotvrdi, 1);
        buttons.add(btnPotvrdi);
        buttons.add(Box.createHorizontalStrut(10));
		
		JButton btnOdbaci = new JButton("Odustani");
		formatButton(btnOdbaci, 0);
		buttons.add(btnOdbaci);
		buttons.add(Box.createHorizontalStrut(50));
		
        add(buttons, BorderLayout.SOUTH);      
        
		validate();
	}
	
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	funkcije za formatiranje
        
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
