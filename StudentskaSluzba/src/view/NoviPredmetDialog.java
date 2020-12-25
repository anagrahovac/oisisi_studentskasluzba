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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NoviPredmetDialog extends JDialog{
	
	public NoviPredmetDialog() {
		
		setSize(500, 600);
		setTitle("Dodavanje predmetaa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); 
		setResizable(false);
		setVisible(true);

		Color c = new Color(245,245,245);
		setBackground(c);
		
		JPanel background = new JPanel();
		background.setBackground(c);
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		
		PredmetFocusListener focusListener = new PredmetFocusListener();
		

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	polja	
		
		RowPanel pSifra = new RowPanel("Šifra predmeta*");
		pSifra.getTextField().setName("txtSifra");
		pSifra.getTextField().addFocusListener(focusListener);
		
		RowPanel pNaziv = new RowPanel("Naziv*");
		pNaziv.getTextField().setName("txtNaziv");
		pNaziv.getTextField().addFocusListener(focusListener);
		
		RowPanel pGodinaStudija = new RowPanel("Godina studija*");
		pGodinaStudija.getTextField().setName("txtGodinaStudija");
		pGodinaStudija.getTextField().addFocusListener(focusListener);
		
		RowPanel pImeProfesor = new RowPanel("Ime profesora*");
		pImeProfesor.getTextField().setName("txtImeProfesor");
		pImeProfesor.getTextField().addFocusListener(focusListener);
		
		RowPanel pPrezimeProfesor = new RowPanel("Prezime profesora*");
		pPrezimeProfesor.getTextField().setName("txtPrezimeProfesor");
		pPrezimeProfesor.getTextField().addFocusListener(focusListener);
		
		RowPanel pBrojESPB = new RowPanel("Broj ESPB bodova*");
		pBrojESPB.getTextField().setName("txtBrojESPB");
		pBrojESPB.getTextField().addFocusListener(focusListener);
		
		String[] semestar = { "letnji", "zimski"};
		RowPanel pSemestar = new RowPanel("Semestar*", semestar);

		
		        
	    background.add(Box.createVerticalStrut(30));  
	    background.add(pSifra);
	    background.add(pNaziv); 
	    background.add(pGodinaStudija);
	    background.add(pImeProfesor);
	    background.add(pPrezimeProfesor);
	    background.add(pBrojESPB);
	    background.add(pSemestar); 
	    background.add(Box.createVerticalStrut(150));

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
				if(pSifra.getTextField().getText().trim().equals("") 
						|| pNaziv.getTextField().getText().trim().equals("") 
						|| pGodinaStudija.getTextField().getText().trim().equals("")
						|| pImeProfesor.getTextField().getText().trim().equals("")
						|| pPrezimeProfesor.getTextField().getText().trim().equals("") 
						|| pBrojESPB.getTextField().getText().trim().equals("") )  {
					//JOptionPane.showMessageDialog(background, "Sva polja moraju biti popunjena kako biste dodali studenta!");
					btnPotvrdi.setForeground(new Color(150, 150, 150));
					btnPotvrdi.setBackground(new Color(220, 220, 220));
					btnPotvrdi.setForeground(new Color(150, 150, 150));
				} else {
				JOptionPane.showMessageDialog(null, "Predmet je dodat.");
				btnPotvrdi.setEnabled(true);
				dispose();
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
				dispose();
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
