package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyStatusBar extends JPanel{
	
	private static final long serialVersionUID = 3261440627468087163L;
	
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
		
		Font f = new Font("Dialog", Font.PLAIN, 13);
		ss.setFont(f);
		
		/**REFERENCA: ... 
		https://coderanch.com/t/331575/java/Display-time-date-status-bar?fbclid=IwAR3lOQVeVHLdJc7c4YiW4jL7jkY_gAMxz_rBVgD-rCtK9abS1Yvg8hFDJ9U
		*/		
		JLabel dateAndTime = new JLabel();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss  |  dd. MMM yyyy.");
	    rightPanel.add(dateAndTime);
	    rightPanel.setOpaque(false);
	    
		Timer timer = new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dateAndTime.setText(sdf.format( new GregorianCalendar().getTime() ) );	
				dateAndTime.setFont(f);
			}
		});
		
		timer.setInitialDelay(0);
	    timer.start();	
	}
}
