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

import model.BazaStudenata;
import model.Student;

public class IzmenaStudentaDialog extends JDialog{

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
		
		
		int i = MainFrame.getInstance().getStudentiTable().getSelectedRow();
		Student s = new Student();
		if(i == -1) {
			JOptionPane.showMessageDialog(null, "Niste selektovali studenta za izmenu!");
			return;
		}else {
			String indeks = (String) MainFrame.getInstance().getStudentiTable().getValueAt(i, 0);
			s = BazaStudenata.getInstance().studentDatogIndeksa(indeks);
		}	
		
		informacije.setBackground(c);
		informacije.setLayout(new BoxLayout(informacije, BoxLayout.Y_AXIS));
		
		pIme = new RowPanel("Ime*");
			pIme.getTextField().setText(s.getImeStudenta());
		pPrezime = new RowPanel("Prezime*");
			pPrezime.getTextField().setText(s.getPrezimeStudenta());
		pDatumRodjenja = new RowPanel("Datum rodjenja*");
			pDatumRodjenja.getTextField().setText(s.getDatumRodjenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
		pAdresaStanovanja = new RowPanel("Adresa stanovanja*");
			pAdresaStanovanja.getTextField().setText(s.getAdresaStanovanja());
		pBrojTelefona = new RowPanel("Kontakt telefon*");
			pBrojTelefona.getTextField().setText(s.getKontaktTelefon());
		pEMailAdresa = new RowPanel("E-mail adresa*");
			pEMailAdresa.getTextField().setText(s.getEmailAdresa());
		pBrojIndexa = new RowPanel("Broj indeksa*");
			pBrojIndexa.getTextField().setText(s.getBrojIndexa());
		pGodinaUpisa = new RowPanel("Godina upisa*");
			pGodinaUpisa.getTextField().setText(Integer.toString(s.getGodinaUpisa()));
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
		
        Dimension btnDim = new Dimension(100, 30);
		Font f1 = new Font("Dialog", Font.PLAIN, 14);
		Color g = new Color(230,230,230);

		btnPotvrdi.setPreferredSize(btnDim);
		btnPotvrdi.setFont(f1);
		btnOdbaci.setPreferredSize(btnDim);
		btnOdbaci.setFont(f1);
		btnPotvrdi.setBackground(g);
		btnPotvrdi.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		btnOdbaci.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		btnOdbaci.setBackground(g);
		btnPotvrdi.setToolTipText("Izmeni studenta");
		btnOdbaci.setToolTipText("Odustani od izmene studenta");
		
		btnOdbaci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] daNe = {"Da", "Ne"};
				int code = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da odbacite izmene?", "Message", JOptionPane.YES_NO_OPTION, 
														JOptionPane.QUESTION_MESSAGE, null, daNe, daNe[0]);
				if (code == JOptionPane.YES_OPTION) 
					dispose();
			}
		});
		
        buttons.add(btnPotvrdi);
        buttons.add(btnOdbaci);
        buttons.add(Box.createHorizontalStrut(10));
        
        informacije.add(buttons, BorderLayout.SOUTH);      
	    	    
	    validate();
	}
}
