package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
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
		JPanel panel = new JPanel();
		panel.setBackground(c);
		this.add(panel);
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
	}

}