package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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

		Color c = new Color(255, 255, 255);
		this.getContentPane().setBackground(c);
		validate();
		
		MyMenuBar menuBar = new MyMenuBar();
		setJMenuBar(menuBar);
		validate();
		
		MyToolbar toolbar = new MyToolbar();
		this.add(toolbar, BorderLayout.NORTH);
		validate();
		
		MyStatusBar statusBar = new MyStatusBar();
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		validate();
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(c);
		Font f = new Font("Dialog", Font.PLAIN, 15);
		tabbedPane.setFont(f);
		JPanel studentiTab = new JPanel();
		studentiTab.setBackground(c);
		tabbedPane.addTab("Studenti", null, studentiTab, "Tabela sa studentima");
		JPanel profesoriTab = new JPanel();
		profesoriTab.setBackground(c);
		tabbedPane.addTab("Profesori", null, profesoriTab, "Tabela sa profesorima");
		JPanel predmetiTab = new JPanel();
		predmetiTab.setBackground(c);
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