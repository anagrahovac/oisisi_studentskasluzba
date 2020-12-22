package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;


public class TableProfesori extends JTable{
	
	private static final long serialVersionUID = -4414307159355262250L;

	public TableProfesori() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		Color color = new Color(245, 245, 245);
		if (isRowSelected(row)) {
			c.setBackground(color);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}