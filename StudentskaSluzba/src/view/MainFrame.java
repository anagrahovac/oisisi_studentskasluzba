package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1956297561304331839L;
	
	private static MainFrame instance  = null;
	
	private MyMenuBar menuBar;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private MyToolbar toolbar = new MyToolbar();
	private MyStatusBar statusBar = new MyStatusBar();
	
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
		
		this.menuBar = new MyMenuBar(this);
		setJMenuBar(menuBar);
		this.add(toolbar, BorderLayout.NORTH);
		add(statusBar, BorderLayout.SOUTH);
		validate();
		
		
		//prikaz - tabovi i tabele
		Font f = new Font("Dialog", Font.PLAIN, 14);
		this.tabbedPane.setBackground(Color.WHITE);
		this.tabbedPane.setFont(f);
		
		TableStudenti studentiTable = new TableStudenti();
		JScrollPane studentiTab = new JScrollPane(studentiTable);
		studentiTab.getViewport().setBackground(Color.WHITE);
		
		TableProfesori profesoriTable = new TableProfesori();
		JScrollPane profesoriTab = new JScrollPane(profesoriTable);
		profesoriTab.getViewport().setBackground(Color.WHITE);
		
		TablePredmeti predmetiTable = new TablePredmeti();
		JScrollPane predmetiTab = new JScrollPane(predmetiTable);
		predmetiTab.getViewport().setBackground(Color.WHITE);
		
		tabbedPane.addTab("Studenti", null, studentiTab, "Tabela sa studentima");
		tabbedPane.addTab("Profesori", null, profesoriTab, "Tabela sa profesorima");
		tabbedPane.addTab("Predmeti", null, predmetiTab, "Tabela sa predmetima");
		this.add(tabbedPane, BorderLayout.CENTER);
		validate();
		
	}
	
	public int getActiveTab() {
		return this.tabbedPane.getSelectedIndex();
	}

	public static MainFrame getInstance(){
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
}