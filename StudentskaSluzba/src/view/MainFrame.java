package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import listeners.AppWindowListener;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1956297561304331839L;
	
	private static MainFrame instance  = null;
	
	private MyMenuBar menuBar;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private MyToolbar toolbar = new MyToolbar();
	private MyStatusBar statusBar = new MyStatusBar();
	private TableStudenti studentiTable = new TableStudenti();
	private TableProfesori profesoriTable;
	private TablePredmeti predmetiTable;
	

	public static MainFrame getInstance(){
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
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
		
		addWindowListener(new AppWindowListener());
		
		this.menuBar = new MyMenuBar(this);
		setJMenuBar(menuBar);
		this.add(toolbar, BorderLayout.NORTH);
		add(statusBar, BorderLayout.SOUTH);
		validate();
		
		
		//prikaz - tabovi i tabele
		Font f = new Font("Dialog", Font.PLAIN, 14);
		this.tabbedPane.setBackground(Color.WHITE);
		this.tabbedPane.setFont(f);
		
		JScrollPane studentiTab = new JScrollPane(studentiTable);
		studentiTab.getViewport().setBackground(Color.WHITE);
		this.updateStudentiTable();
		
		AbstractTableModelProfesori atmp = new AbstractTableModelProfesori();
		profesoriTable = new TableProfesori(atmp);
		JScrollPane profesoriTab = new JScrollPane(profesoriTable);
		profesoriTab.getViewport().setBackground(Color.WHITE);
		this.updateProfesoriTable();
		
		AbstractTableModelPredmeti atm = new AbstractTableModelPredmeti();
		predmetiTable = new TablePredmeti(atm);
		JScrollPane predmetiTab = new JScrollPane(predmetiTable);
		predmetiTab.getViewport().setBackground(Color.WHITE);
		this.updatePredmetiTable();
		
		tabbedPane.addTab("Studenti", null, studentiTab, "Tabela sa studentima");
		tabbedPane.addTab("Profesori", null, profesoriTab, "Tabela sa profesorima");
		tabbedPane.addTab("Predmeti", null, predmetiTab, "Tabela sa predmetima");
		this.add(tabbedPane, BorderLayout.CENTER);
		
		studentiTable.setAutoCreateRowSorter(true);
		profesoriTable.setAutoCreateRowSorter(true);
		predmetiTable.setAutoCreateRowSorter(true);
		
		validate();
		
	}
	
	public void updateProfesoriTable() {
			AbstractTableModelProfesori model = (AbstractTableModelProfesori) profesoriTable.getModel();
			model.fireTableDataChanged();
			validate();
	}
	
	public void updateStudentiTable() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) studentiTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void updatePredmetiTable() {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) predmetiTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public int getActiveTab() {
		return this.tabbedPane.getSelectedIndex();
	}
	
	public String getStudentIndeks() {
		int row = studentiTable.getSelectedRow();
		if(row != -1)
			return (String) studentiTable.getValueAt(row, 0);
		else
			return "";
	}
	
	public String getProfesorID() {
		int row = profesoriTable.getSelectedRow();
		if(row != -1)
			return (String) profesoriTable.getValueAt(row, 2);
		else
			return "";
	}
	
	public String getPredmetSifra() {
		int row = predmetiTable.getSelectedRow();
		if(row != -1)
			return (String) predmetiTable.getValueAt(row, 0);
		else
			return "";
	}

	public TableStudenti getStudentiTable() {
		return studentiTable;
	}

	public TableProfesori getProfesoriTable() {
		return profesoriTable;
	}

	public TablePredmeti getPredmetiTable() {
		return predmetiTable;
	}	
}