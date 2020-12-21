package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.TableStudenti;

public class MainFrame extends JFrame {
	
	private static MainFrame instance  = null;
	
	public MainFrame() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height * 3 / 4;
		int screenWidth = screenSize.width * 3 / 4;
		setSize(screenWidth, screenHeight);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		
		MyMenuBar menuBar = new MyMenuBar(this);
		setJMenuBar(menuBar);
		validate();
		
		MyToolbar toolbar = new MyToolbar();
		this.add(toolbar, BorderLayout.NORTH);
		validate();
		
		MyStatusBar statusBar = new MyStatusBar();
		add(statusBar, BorderLayout.SOUTH);
		validate();
		
		
		//prikaz - tabovi i tabele
		Font f = new Font("Dialog", Font.PLAIN, 14);
		Color headerColor = new Color(143, 180, 255);   //blue
		//Color headerColor = new Color(211,199,233);	//light pastel purple
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(f);
		
		TableStudenti studentiTable = new TableStudenti();
		studentiTable.setFont(f);
		studentiTable.setRowHeight(25);
		studentiTable.getTableHeader().setBackground(headerColor);
		studentiTable.getTableHeader().setPreferredSize(new Dimension(0, 25));
		JScrollPane studentiTab = new JScrollPane(studentiTable);
		studentiTab.getViewport().setBackground(Color.WHITE);
		
		TableProfesori profesoriTable = new TableProfesori();
		profesoriTable.setFont(f);
		profesoriTable.setRowHeight(25);
		profesoriTable.getTableHeader().setBackground(headerColor);
		profesoriTable.getTableHeader().setPreferredSize(new Dimension(0, 25));
		JScrollPane profesoriTab = new JScrollPane(profesoriTable);
		profesoriTab.getViewport().setBackground(Color.WHITE);
		
		TablePredmeti predmetiTable = new TablePredmeti();
		predmetiTable.setFont(f);
		predmetiTable.setRowHeight(25);
		predmetiTable.getTableHeader().setBackground(headerColor);
		predmetiTable.getTableHeader().setPreferredSize(new Dimension(0, 25));
		JScrollPane predmetiTab = new JScrollPane(predmetiTable);
		predmetiTab.getViewport().setBackground(Color.WHITE);
		
		tabbedPane.addTab("Studenti", null, studentiTab, "Tabela sa studentima");
		tabbedPane.addTab("Profesori", null, profesoriTab, "Tabela sa profesorima");
		tabbedPane.addTab("Predmeti", null, predmetiTab, "Tabela sa predmetima");
		this.add(tabbedPane, BorderLayout.CENTER);
		validate();
		
	}

	public static MainFrame getInstance(){
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
}