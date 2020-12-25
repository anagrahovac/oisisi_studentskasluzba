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
		int sizeHeight = (screenSize.height * 3 / 4) * 7/8;
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
		
		JLabel koriscenje = new JLabel(); 
		koriscenje.setText("<html><body>Pred vama se nalazi aplikacija koja predstavlja studentsku službu Fakulteta<br>"
									+ "Tehničkih Nauka u Novom Sadu. Studentska služba rukuje bazom studenata,<br>"
									+ "profesora i predmeta. U centralnom delu aplikacije nalaze se tabele sa datim<br>"
									+ "entitetima. Prethodne entitete studentska služba ima pravo da dodaje, menja<br>"
									+ "briše... Referent dodaje entitet selektovanjem odgovarajuće tabele (npr. ako<br>"
									+ "želi da doda predmet, prethodno mora selektovana tabela predmeta). Nakon<br>"
									+ "dodatog entiteta, tabela se ažurira i on postaje vidljiv. Entitet se može<br>"
									+ "dodati iz stavke glavnog menija \"New\", pritiskom prvog dugmeta toolbar-a<br>"
									+ "ili upotrebom odgovarajućih mnemonika i akceleratora."
									+ " <br>"
									+ "<br>"
									+ "ALT+F - otvara File stavku menija<br>"
									+ "ALT+E - otvara Edit stavku menija<br>"
									+ "ALT+H - otvara Help stavku menija<br>"
									+ "CTRL+N - prečica za dodavanje novog entiteta u sistem<br>"
									+ "CTRL+C - prečica za zatvaranje aplikacije<br>"
									+ "CTRL+T - prečica za izmenu entiteta iz sistema<br>"
									+ "CTRL+D - prečica za brisanje postojećeg entiteta iz sistema<br>"
									+ "CTRL+B - prečica za otvaranje submenija za pomoć o radu aplikacije<br>"
									+ "CTRL+A - prečica za otvaranje submenija za opis autora<br>");
		koriscenje.setFont(f1);
		
		
		header.setBackground(c);
		koriscenje.setBackground(c);
		
		header.add(lblHeader);
		background.add(koriscenje);
	}

}
