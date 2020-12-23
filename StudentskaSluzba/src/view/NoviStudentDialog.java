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
import javax.swing.JOptionPane;
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
		
		RowPanel pIme = new RowPanel("Ime*");
		pIme.getTextField().setName("txtIme");
		pIme.getTextField().addFocusListener(focusListener);
		
		RowPanel pPrezime = new RowPanel("Prezime*");
		pPrezime.getTextField().setName("txtPrezime");
		pPrezime.getTextField().addFocusListener(focusListener);
		
		RowPanel pDatumRodjenja = new RowPanel("Datum rodjenja*");
		pDatumRodjenja.getTextField().setName("txtDatumRodjenja");
		pDatumRodjenja.getTextField().addFocusListener(focusListener);
		
		RowPanel pAdresaStanovanja = new RowPanel("Adresa stanovanja*");
		pAdresaStanovanja.getTextField().setName("txtAdresaStanovanja");
		pAdresaStanovanja.getTextField().addFocusListener(focusListener);
		
		RowPanel pBrojTelefona = new RowPanel("Kontakt telefon*");
		pBrojTelefona.getTextField().setName("txtBrojTelefona");
		pBrojTelefona.getTextField().addFocusListener(focusListener);
		
		RowPanel pEMailAdresa = new RowPanel("E-mail adresa*");
		pEMailAdresa.getTextField().setName("txtEMailAdresa");
		pEMailAdresa.getTextField().addFocusListener(focusListener);
		
		RowPanel pBrojIndexa = new RowPanel("Broj indeksa");
		pBrojIndexa.getTextField().setName("txtBrojIndexa");
		pBrojIndexa.getTextField().addFocusListener(focusListener);
		
		RowPanel pGodinaUpisa = new RowPanel("Godina upisa*");
		pGodinaUpisa.getTextField().setName("txtGodinaUpisa");
		pGodinaUpisa.getTextField().addFocusListener(focusListener);
		
		String[] godinaStudija = {"1 (prva)", "2 (druga)", "3 (treca)", "4 (četvrta)"};
		RowPanel pTrenutnaGodinaStudija = new RowPanel("Godina studija*", godinaStudija);

		String[] nacinFinansiranja = {"Budžet", "Samofinansiranje"};
		RowPanel pNacinFinansiranja = new RowPanel("Način finansiranja*", nacinFinansiranja);
		
		
        
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
				setVisible(false);
				}
			}
        	
        });
        formatButton(btnPotvrdi, 1);
        buttons.add(btnPotvrdi);
        buttons.add(Box.createHorizontalStrut(10));
		
		JButton btnOdbaci = new JButton("Odustani");
		btnOdbaci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
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
}
