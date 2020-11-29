package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class MyStatusBar extends JPanel{
	
	protected JPanel leftPanel;
	protected JPanel rightPanel;
	
	public MyStatusBar() {
		
		super();
		setVisible(true);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(getWidth(), 23));
		this.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(152,115,172)));
		this.setBackground(new Color(245, 245, 245));
		
		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEADING,5,3));
		leftPanel.setOpaque(false);
		add(leftPanel,BorderLayout.WEST);
		JLabel ss = new JLabel("Studentska služba FTN");
		leftPanel.add(ss);
		
		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,5,3));
		add(rightPanel,BorderLayout.EAST);
	    	
	}
}
