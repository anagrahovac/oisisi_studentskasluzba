package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpDialog extends JDialog{
	
	private static final long serialVersionUID = -5214879780379601917L;

	public HelpDialog(Frame parent,String title) {
		super(parent,"Help");
		setLayout(new BorderLayout());
		
		Font f = new Font("Dialog",Font.ITALIC+Font.BOLD,14);
		Font f1 = new Font("Dialog",Font.PLAIN,14);
		Color c = Color.white;	
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int sizeHeight = (screenSize.height * 3 / 4) * 3/4;
		int sizeWidth = (screenSize.width * 3 / 4) / 2;
		
		setSize(sizeWidth, sizeHeight);
		setLocationRelativeTo(parent);
		setBackground(c);
				
		
		JPanel header = new JPanel(new FlowLayout(FlowLayout.LEADING,5,10));
		header.setBackground(c);
		this.add(header,BorderLayout.NORTH);
		
		JPanel background = new JPanel(new FlowLayout(FlowLayout.LEADING,5,10));
		background.setBackground(c);
		this.add(background, BorderLayout.CENTER);
		
		JLabel lblHeader = new JLabel("Način korišćenja aplikacije i opis iste");
		lblHeader.setFont(f);
		
		JTextArea koriscenje = new JTextArea();
		koriscenje.setText("    U centralnom delu aplikacije nalaze se tabele sa datim "
									+ "entitetima. Prethodne entitete studentska služba ima pravo da dodaje, menja, "
									+ "briše... Referent dodaje entitet selektovanjem odgovarajuće tabele (npr. ako "
									+ "želi da doda predmet, prethodno mora biti selektovan tab predmeta). Entitet se može "
									+ "dodati iz stavke glavnog menija \"New\", pritiskom dugmeta toolbar-a "
									+ "ili upotrebom odgovarajućih mnemonika i akceleratora. Pri dodavanju entiteta "
									+ "svaki unos ima proveru da li je uneta vrednost moguća. Nakon provere entitet "
									+ "se dodaje u tabelu, ona se ažurira i on postaje vidljiv korisniku. Ukoliko "
									+ "referent odustane od dodavanja entiteta, to može učiniti pritiskom na dugme \"Odustani\".\n\n"

									+ "ALT+F - otvara File stavku menija\n"
									+ "ALT+E - otvara Edit stavku menija\n"
									+ "ALT+H - otvara Help stavku menija\n"
									+ "CTRL+N - prečica za dodavanje novog entiteta u sistem\n"
									+ "CTRL+C - prečica za zatvaranje aplikacije\n"
									+ "CTRL+T - prečica za izmenu entiteta iz sistema\n"
									+ "CTRL+D - prečica za brisanje postojećeg entiteta iz sistema\n"
									+ "CTRL+B - prečica za otvaranje submenija za pomoć o radu aplikacije\n"
									+ "CTRL+A - prečica za otvaranje submenija za opis autora\n");
		koriscenje.setLineWrap(true);
		koriscenje.setFont(f1);	
		koriscenje.setOpaque(true);
		koriscenje.setEditable(false);
		
		header.setBackground(c);
		koriscenje.setBackground(c);
		
		header.add(lblHeader);
		background.add(koriscenje);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane,BorderLayout.CENTER);
		scrollPane.setViewportView(koriscenje);
	}

}
