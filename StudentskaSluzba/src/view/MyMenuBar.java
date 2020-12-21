package view;

import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
//import javax.swing.ImageIcon;

import java.awt.Color;

public class MyMenuBar extends JMenuBar{

	public MyMenuBar() {
		setVisible(true);
		
		Color c = new Color(245, 245, 245); //svetlo siva
		//(255, 255, 255); //bela
		setBackground(c);
		
		JMenu menuFile = new JMenu("File");
		JMenu menuEdit = new JMenu("Edit"); 
		JMenu menuHelp = new JMenu("Help"); 
		
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuEdit.setMnemonic(KeyEvent.VK_E);
		menuHelp.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem menuFileNew = new JMenuItem("New", new ImageIcon("menubar_images/new.png"));
		menuFileNew.setMnemonic(KeyEvent.VK_N);
		menuFileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));		
		JMenuItem menuFileClose = new JMenuItem("Close", new ImageIcon("menubar_images/close.png"));
		menuFileClose.setMnemonic(KeyEvent.VK_C);
		menuFileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		
		JMenuItem menuEditEdit = new JMenuItem("Edit",new ImageIcon("menubar_images/edit.png"));
		menuEditEdit.setMnemonic(KeyEvent.VK_T);
		menuEditEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		JMenuItem menuEditDelete = new JMenuItem("Delete",new ImageIcon("menubar_images/delete.png"));
		menuEditDelete.setMnemonic(KeyEvent.VK_D);
		menuEditDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		
		JMenuItem menuHelpHelp = new JMenuItem("Help",new ImageIcon("menubar_images/help.png"));
		menuHelpHelp.setMnemonic(KeyEvent.VK_P);
		menuHelpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
		JMenuItem menuHelpAbout = new JMenuItem("About",new ImageIcon("menubar_images/about.png"));
		menuHelpAbout.setMnemonic(KeyEvent.VK_A);
		menuHelpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		
		menuFile.add(menuFileNew);
		menuFile.add(menuFileClose);
		
		menuEdit.add(menuEditEdit);
		menuEdit.add(menuEditDelete);
		
		menuHelp.add(menuHelpHelp);
		menuHelp.add(menuHelpAbout);
		
		add(menuFile);
		add(menuEdit);
		add(menuHelp);
		
		setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
		 
		Font f = new Font("Dialog", Font.PLAIN, 15);
 
		menuFile.setFont(f);
		menuEdit.setFont(f);
		menuHelp.setFont(f);
 
		menuFileNew.setFont(f);
		menuEditEdit.setFont(f);
		menuHelpHelp.setFont(f);
		menuFileClose.setFont(f);
		menuEditDelete.setFont(f);
		menuHelpAbout.setFont(f);

	}
}

