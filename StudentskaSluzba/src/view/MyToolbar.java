package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import listeners.DeleteActionListener;
import listeners.EditActionListener;
import listeners.NewActionListener;
import listeners.SearchActionListener;

import javax.swing.JTextField;

public class MyToolbar extends JToolBar {

	private static final long serialVersionUID = -3666207502033139205L;
	
	private JTextField searchBox = new JTextField();

	public MyToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		Color c = new Color(245, 245, 245); //svetlo siva
				//(255, 255, 255); //bela
		setBackground(c);
		setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
		Dimension btnDim = new Dimension(30, 30);
		
		
		//panel sa alatima iz toolbara
		JPanel panTools = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panTools.setBackground(c);
		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("toolbar_images" + File.separator + "new.png"));
		btnNew.setPreferredSize(btnDim);
		btnNew.setBackground(c);
		btnNew.setBorderPainted(isDisplayable());
		panTools.add(btnNew);
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("toolbar_images" + File.separator + "edit.png"));
		btnEdit.setPreferredSize(btnDim);
		btnEdit.setBackground(c);
		btnEdit.setBorderPainted(isDisplayable());
		panTools.add(btnEdit);
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("toolbar_images" + File.separator + "delete.png"));
		btnDelete.setPreferredSize(btnDim);
		btnDelete.setBackground(c);
		btnDelete.setBorderPainted(isDisplayable());
		panTools.add(btnDelete);

		//akcije
		btnNew.addActionListener(new NewActionListener());
		btnDelete.addActionListener(new DeleteActionListener());
		btnEdit.addActionListener(new EditActionListener());
		
		add(panTools);

		
		//panel sa komponentama za pretrazivanje
		JPanel panSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panSearch.setBackground(c);
		
		//searchBox = new JTextField();
		searchBox.setPreferredSize(new Dimension(400, 30));
		panSearch.add(searchBox);
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("toolbar_images" + File.separator + "search.png"));
		btnSearch.setPreferredSize(btnDim);
		btnSearch.setBackground(c);
		btnSearch.setBorderPainted(isDisplayable());
		panSearch.add(btnSearch);
		
		SearchActionListener sal = new SearchActionListener(this);
		
		searchBox.addActionListener(sal);
		btnSearch.addActionListener(sal);
		
		add(panSearch);
		
		validate();
	}

	public String getEntry() {
		return searchBox.getText();
	}

	
}
