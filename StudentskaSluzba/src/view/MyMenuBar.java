package view;

import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import listeners.DeleteActionListener;
import listeners.EditActionListener;
import listeners.NewActionListener;

import java.awt.Color;

public class MyMenuBar extends JMenuBar{

	private static final long serialVersionUID = 290799305854846920L;

	public MyMenuBar(final JFrame parent) {
		setVisible(true);
		
		Color c = new Color(245, 245, 245); //svetlo siva
		setBackground(c);
		
		JMenu menuFile = new JMenu("File");
		JMenu menuEdit = new JMenu("Edit"); 
		JMenu menuHelp = new JMenu("Help"); 
		
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuEdit.setMnemonic(KeyEvent.VK_E);
		menuHelp.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem menuFileNew = new JMenuItem("New", new ImageIcon("menubar_images" + File.separator + "new.png"));
		menuFileNew.setMnemonic(KeyEvent.VK_N);
		menuFileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));		
		JMenuItem menuFileClose = new JMenuItem("Close", new ImageIcon("menubar_images" + File.separator + "close.png"));
		menuFileClose.setMnemonic(KeyEvent.VK_C);
		menuFileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		
		JMenuItem menuEditEdit = new JMenuItem("Edit",new ImageIcon("menubar_images" + File.separator + "edit.png"));
		menuEditEdit.setMnemonic(KeyEvent.VK_T);
		menuEditEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		JMenuItem menuEditDelete = new JMenuItem("Delete",new ImageIcon("menubar_images" + File.separator + "delete.png"));
		menuEditDelete.setMnemonic(KeyEvent.VK_D);
		menuEditDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		
		JMenuItem menuHelpHelp = new JMenuItem("Help",new ImageIcon("menubar_images" + File.separator + "help.png"));
		menuHelpHelp.setMnemonic(KeyEvent.VK_P);
		menuHelpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
		JMenuItem menuHelpAbout = new JMenuItem("About",new ImageIcon("menubar_images" + File.separator + "about.png"));
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
		
		menuHelpHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HelpDialog dialog = new HelpDialog(parent, "Help");
				dialog.setVisible(true);
			}
		});
		
		menuHelpAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDialog dialog = new AboutDialog(parent,"About");
				dialog.setVisible(true);
			}
		});
		
		menuFileNew.addActionListener(new NewActionListener());
		menuEditEdit.addActionListener(new EditActionListener());
		menuEditDelete.addActionListener(new DeleteActionListener());

	}
}

