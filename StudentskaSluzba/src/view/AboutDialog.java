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

public class AboutDialog extends JDialog{
	
	private static final long serialVersionUID = 8956415914908634115L;

	public AboutDialog(JFrame parent, String title) {

	super(parent,"About");
	setLayout(new BorderLayout());
	
	Font f = new Font("Dialog",Font.ITALIC,14);
	Font f1 = new Font("Dialog",Font.PLAIN,13);
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
	
	JLabel lblHeader = new JLabel("<html><body>Verzija aplikacije:    2020-09 (4.17.0)");
	lblHeader.setFont(f);
	
	JLabel koriscenje = new JLabel(); 
	koriscenje.setText("<html><body>"
			+ "Biografija studenta 1:"
			+ "<br>Aleksić Lenka Isidora<br>"
			+ "BLABLABLABLABLABLABLABLA<br>"
			+ "<br><br>"
			+ "Biografija studenta 2:<br>"
			+ "Grahovac Ana<br>"
			+ "BLABLABLALBABLABLABALBLA");
	koriscenje.setFont(f1);
	
	
	header.setBackground(c);
	koriscenje.setBackground(c);
	
	header.add(lblHeader);
	background.add(koriscenje);
	
	}
}
