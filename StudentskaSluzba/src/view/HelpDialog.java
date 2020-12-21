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

public class HelpDialog extends JDialog{
	
	
	public HelpDialog(Frame parent,String title) {
		super(parent,"Help");
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
		
		JLabel lblHeader = new JLabel("Uputstvo za korišćenje aplikacije:");
		lblHeader.setFont(f);
		
		JLabel koriscenje = new JLabel(); 
		koriscenje.setText("<html><body>Pred vama se nalazi aplikacija koja predstavlja studentsku službu"
				+ "<br>Fakulteta Tehničkih Nauka u Novom Sadu.<br>"
				+ "BLABLABLABLABLABLABLABLA<br>"
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
