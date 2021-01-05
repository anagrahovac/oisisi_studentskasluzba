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

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class DodajProfesoraDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private TableProfesori tabela;
	private IzmenaPredmetaDialog izmena;
	
	public DodajProfesoraDialog() {
		super();
	}

	public DodajProfesoraDialog(JFrame parent, String sifra, IzmenaPredmetaDialog i) {
		super(parent, "Odaberi profesora",true);
		setLayout(new BorderLayout());
		
		izmena = i;
		
		setSize(370,250);
		setLocationRelativeTo(parent);
		
		JPanel background = new JPanel();
		
		AbstractTableModelListaProfesora atm = new AbstractTableModelListaProfesora();
		tabela = new TableProfesori(atm);
		tabela.setBackground(Color.white);
		JScrollPane scroll = new JScrollPane(tabela);
		background.add(tabela.getTableHeader(), BorderLayout.NORTH);
		tabela.setTableHeader(null);
		tabela.setPreferredScrollableViewportSize(new Dimension(300, 150));
		
		background.add(scroll, BorderLayout.CENTER);
		background.setBackground(Color.white);
		
		Font f = new Font("Dialog", Font.PLAIN, 14);
		
		JButton btnDodaj = new JButton("Potvrdi");
		btnDodaj.setFont(f);
		btnDodaj.setPreferredSize(new Dimension(100,30));
		btnDodaj.setBackground(new Color(230,230,230));
		btnDodaj.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub		
				if(getBrojLicneKarteListaProfesora().equals("")) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali profesora!");
					return;
				}
				
				dodajProfesoraPredmetu(sifra, getBrojLicneKarteListaProfesora());
				izmena.azurirajPredmet(izmena.getTxtProfesor(), izmena.getP(), izmena);
				MainFrame.getInstance().updatePredmetiTable();

				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btnDodaj.setBackground(new Color(228, 244, 255));
				btnDodaj.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 1));
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
				btnOdustani.setBorder(BorderFactory.createLineBorder(new Color(103, 140, 235), 1));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnOdustani.setBackground(new Color(230,230,230));
				btnOdustani.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
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
	
	public String getBrojLicneKarteListaProfesora() {
		int i = tabela.getSelectedRow();
		if(i != -1) {
			return (String) tabela.getValueAt(i, 1);
		} else {
			return "";
		}
	} 
	
	
	public void dodajProfesoraPredmetu(String sifra, String brojLicne) {
		for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
			if(BazaPredmeta.getInstance().getPredmeti().get(i).getSifraPredmeta().equals(sifra)) {
				BazaPredmeta.getInstance().getPredmeti().get(i).setPredmetniProfesor(BazaProfesora.getInstance().pronadjiProfesora1(brojLicne));
				BazaProfesora.getInstance().pronadjiProfesora1(brojLicne).getSpisakPredmeta().add(BazaPredmeta.getInstance().getPredmeti().get(i));
			}
		}
		
		updateListaProfesoraTable();
	}
	
	public void updateListaProfesoraTable() {
		AbstractTableModelListaProfesora model = (AbstractTableModelListaProfesora) tabela.getModel();
		model.fireTableDataChanged();
		tabela.validate();
	}

	public TableProfesori getTabela() {
		return tabela;
	}

	public void setTabela(TableProfesori tabela) {
		this.tabela = tabela;
	}
}
