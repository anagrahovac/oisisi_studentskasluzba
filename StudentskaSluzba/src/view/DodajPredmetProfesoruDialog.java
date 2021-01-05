package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaPredmeta;
import model.Predmet;

public class DodajPredmetProfesoruDialog extends JDialog {
	
	private static final long serialVersionUID = 4251870696910692468L;
	
	private JList list;
	private DefaultListModel model;
	ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	private JButton btnPotvrdi = new JButton("Potvrdi");
	private JButton btnOdbaci = new JButton("Odustani");
	
	public DodajPredmetProfesoruDialog() {
		super(MainFrame.getInstance(), "Dodaj predmet", true);
		setLayout(new BorderLayout());
		setSize(500,350);
		this.setLocationRelativeTo(MainFrame.getInstance());
		Color gray = new Color(245,245,245);
		
		JPanel pTop = new JPanel();
		JPanel pCenter = new JPanel();
		JPanel pBottom = new JPanel();
		
		//panel za naslov
        pTop.setBackground(gray);
        pTop.setPreferredSize(new Dimension(40,40));
        Dimension lblDim = new Dimension(150, 30);
		Font dialog = new Font("Dialog", Font.PLAIN, 14);
		JLabel lbl = new JLabel("Predmeti:");
		lbl.setPreferredSize(lblDim);
		lbl.setFont(dialog);
		pTop.setLayout(new FlowLayout(FlowLayout.LEFT));
		pTop.add(Box.createHorizontalStrut(20));
		pTop.add(lbl);
		this.add(pTop, BorderLayout.NORTH);
        
		//kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
		
		model = new DefaultListModel();
		list = new JList(model); 
		predmeti = BazaPredmeta.getInstance().getPredmeti();
		for(int i = 0; i < predmeti.size(); i++) {
			model.addElement(predmeti.get(i).getSifraPredmeta() + " - " + predmeti.get(i).getNazivPredmeta());
		}
		/*System.out.println(
				list.getSelectedIndex());*/
		//kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
		
        //panel za listu
        this.add(pCenter, BorderLayout.CENTER);
        pCenter.setBackground(gray);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(450, 200));
		scroll.getViewport().setBackground(Color.WHITE);
        pCenter.add(scroll, BorderLayout.CENTER);
		
		//panel za dugmice
        pBottom.setBackground(gray);
        pBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pBottom.setPreferredSize(new Dimension(50, 50));
        this.add(pBottom, BorderLayout.SOUTH);
		
        this.formatButton(btnPotvrdi, 1);
		pBottom.add(btnPotvrdi);
		pBottom.add(Box.createHorizontalStrut(10));
		this.dodajListenerPotvrdi();
		
		this.formatButton(btnOdbaci, 0);
		pBottom.add(btnOdbaci);
		pBottom.add(Box.createHorizontalStrut(20));
        this.dodajListenerOdbaci();
		
		
		
		validate();
	}
	
	private void dodajListenerPotvrdi() {
		btnPotvrdi.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				if(list.getSelectedIndex() != -1) {
					String sifra = predmeti.get(list.getSelectedIndex()).getSifraPredmeta();
					JOptionPane.showMessageDialog(null, "Predmet uspešno dodat profesoru.");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet.");
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnPotvrdi.setBackground(new Color(228, 244, 255));
				btnPotvrdi.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPotvrdi.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 2));
				btnPotvrdi.setBackground(new Color(230,230,230));
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	private void dodajListenerOdbaci() {
		btnOdbaci.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnOdbaci.setBackground(new Color(228, 244, 255));
				btnOdbaci.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 1));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnOdbaci.setBackground(new Color(230,230,230));
				btnOdbaci.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
	}
	
	private void formatButton(JButton btn, int i) {
        Dimension btnDim = new Dimension(100, 30);
		Font f = new Font("Dialog", Font.PLAIN, 14);
		Color g = new Color(230,230,230);
		Color b = new Color(103, 140, 235);

		btn.setPreferredSize(btnDim);
		btn.setBackground(g);
		btn.setFont(f);
		if (i == 1) {
			btn.setBorder(BorderFactory.createLineBorder(b, 2));
			btn.setToolTipText("Sačuvaj unete podatke");
		}
		if (i == 0) {
			btn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			btn.setToolTipText("Odbaci unete podatke");
		}
		
	}
}