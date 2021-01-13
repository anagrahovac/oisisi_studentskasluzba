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
		koriscenje.setText("   Aplikacija simulira rad studentske službe. U centralnom delu se nalaze tabovi sa tabelama studenata, profesora i predmeta.\r\n"
				+ "   Tabele se mogu sortirati pritiskom na zaglavlje kolone, ili pak pretražiti unosom teksta u searchbox. Odredjene akcije mogu se pokrenuti izborom stavke iz menija, ili klikom na dugme iz toolbara, kao i sledećim prečicama:\r\n"
				+ "\r\n"
									+ "ALT+F - otvara File stavku menija\n"
									+ "ALT+E - otvara Edit stavku menija\n"
									+ "ALT+H - otvara Help stavku menija\n"
									+ "CTRL+N - prečica za dodavanje novog entiteta u sistem\n"
									+ "CTRL+C - prečica za zatvaranje aplikacije\n"
									+ "CTRL+T - prečica za izmenu entiteta iz sistema\n"
									+ "CTRL+D - prečica za brisanje postojećeg entiteta iz sistema\n"
									+ "CTRL+B - prečica za otvaranje submenija za pomoć o radu aplikacije\n"
									+ "CTRL+A - prečica za otvaranje submenija za opis autora\n\n"

									+ "Dodavanje entiteta:\n"
									+ "Odabirom željenog taba i odabirom opcije New, otvara sa dijalog za dodavanje entiteta. Nakon što su svi podaci ispravno uneti, entitet se može dodati u bazu pritiskom na dugme potvrdi, ili odbaciti unete podatke pritiskom na dugme odbaci.\n\n"
									+ "Izmena entiteta:\n"
									+ "Nakon što je selektovan entitet za izmenu, odabirom opcije Edit, otvara se dijalog za izmenu informacija o entitetu. Nakon što su izmene ispravno unete, promene se mogu sačuvati ili odbaciti.\n\n"
									+ "Brisanje entiteta:\n"
									+ "Pored dodavanja i izmene, entitet se može i u potpunosti obrisati iz baze. Klikom na odgovarajuće dugme, on se briše, osim u bazi, i kod profesora i studenata koji su taj predmet predavali ili slušali.\n\n"
									+ "Rad sa entitetima:\n"
									+ "-Referent za selektovanog studenta, u dijalogu izmene, može pristupiti i njegovim položenim i nepoloženim predmetima. Svakom položenom predmetu ocena se moze poništiti ukoliko student to želi, nakon čega se taj predmet ubacuje u listu nepoloženih predmeta i pritom se njegov prosek i broj ESPB bodova redukuje. Ukoliko je pak neki student položio predmet koji sluša, referent može izvršiti polaganje tog predmeta datom studentu.\n"
									+ "-Ukoliko profesor prestane da predaje neki predmet ili pak počne, tu promenu referent moze uneti u bazu i selektovanom profesoru ukloniti/dodati dati predmet.\n"
									+ "-U tabu izmene predmeta, svakom predmetu može se dodeliti ili ukloniti profesor iz baze.\n");
		koriscenje.setLineWrap(true);
		koriscenje.setWrapStyleWord(true);
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
