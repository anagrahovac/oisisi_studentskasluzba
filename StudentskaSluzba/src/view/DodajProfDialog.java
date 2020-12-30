package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import model.BazaProfesora;
import model.BazaStudenata;

public class DodajProfDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private TableProfesori tabela;
	
	public DodajProfDialog() {
		super();
		this.tabela = new TableProfesori();
	}

	public DodajProfDialog(JFrame parent) {
		super(parent, "Dodaj profesora",true);
		setLayout(new BorderLayout());
		
		setSize(350,250);
		setLocationRelativeTo(null);
		
		JPanel background = new JPanel();
		JScrollPane scroll = new JScrollPane(tabela);
		
		tabela = new TableProfesori();
		tabela.setBackground(Color.white);
		background.add(tabela.getTableHeader(), BorderLayout.NORTH);
		background.add(tabela, BorderLayout.CENTER);
		background.setBackground(Color.white);
		
		Font f = new Font("Dialog", Font.PLAIN, 14);
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setFont(f);
		btnDodaj.setPreferredSize(new Dimension(100,30));
		btnDodaj.setBackground(new Color(230,230,230));
		btnDodaj.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub			
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btnDodaj.setBackground(new Color(228, 244, 255));
				btnDodaj.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235)));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btnDodaj.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 2));
				btnDodaj.setBackground(new Color(230,230,230));
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setFont(f);
		btnOdustani.setPreferredSize(new Dimension(100,30));
		btnOdustani.setBackground(new Color(230,230,230));
		btnOdustani.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnOdustani.setBackground(new Color(228, 244, 255));
				btnOdustani.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnOdustani.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 2));
				btnOdustani.setBackground(new Color(230,230,230));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		buttons.setBackground(Color.white);
		buttons.add(btnDodaj);
		buttons.add(btnOdustani);
		background.add(Box.createVerticalStrut(150));  
		background.add(buttons, BorderLayout.SOUTH);
		
		this.add(background);
	}

	public TableProfesori getTabela() {
		return tabela;
	}

	public void setTabela(TableProfesori tabela) {
		this.tabela = tabela;
	}
}
