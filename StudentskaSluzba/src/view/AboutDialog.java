package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog{
	
	private static final long serialVersionUID = 8956415914908634115L;

	public AboutDialog(JFrame parent, String title) {

	super(parent,"About");
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
	
	JLabel lblHeader = new JLabel("Verzija aplikacije:    2020-09 (4.17.0)");
	lblHeader.setFont(f);
	
	JTextArea koriscenje = new JTextArea(); 
	koriscenje.setText("    Pred vama se nalazi aplikacija koja predstavlja studentsku službu Fakulteta "
			+ "Tehničkih Nauka u Novom Sadu. Studentska služba rukuje bazom studenata, "
			+ "profesora i predmeta. \n\n"
			+ "Biografija studenta 1:\n"
			+ "Lenka Isidora Aleksić rođena je 14. oktobra 1999. godine u Zrenjaninu. Od malena je zainteresovana za muziku i pevanje i do svoje "
			+ "četrnaeste godine učestvovala je u raznim priredbama sa svojom osnovnom školom \"Vuk Karadžić\". Godine 2014. upisuje  Zrenjaninsku "
			+ "gimnaziju na prirodno-matematički smer i  \"baca\" se na prirodne nauke. Sa odličnim uspehom završava srednju školu i upisuje "
			+ "Fakultet tehničkih nauka u Novom Sadu, smer Računarstvo i automatika, gde dalji život staje."
			+ "\n\n"
			+ "Biografija studenta 2:\n"
			+ "Ana Grahovac je rođena 10. septembra 1999. godine u Novom Sadu. Osnovnu školu \"Mihajlo Pupin\" u Veterniku je završila 2014. "
			+ "i iste godine se upisuje na priridno-matematički smer u Gimnaziji \"Jovan Jovanović Zmaj\". Srednju školu završava 2018. i "
			+ "upisuje se na Fakultet tehničkih nauka Univerziteta Novi Sad, smer Računarstvo i automatika. Interesuje se za astronomiju i "
			+ "fotografiju, a slobodno vreme voli da provodi sa prijateljima, u prirodi ili čitajući knjige. Ima četiri mačke i dva psa, ali "
			+ "nije toliko strašno kao što možda zvuči jer ima dvorište."
			);
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
