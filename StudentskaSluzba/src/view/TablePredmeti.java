package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class TablePredmeti extends JTable{

	private static final long serialVersionUID = 6420742439440693518L;

	public TablePredmeti() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		
		Font f = new Font("Dialog", Font.PLAIN, 14);
		Color headerColor = new Color(143, 180, 255);   //blue
		this.setFont(f);
		this.setRowHeight(25);
		this.getTableHeader().setBackground(headerColor);
		this.getTableHeader().setPreferredSize(new Dimension(0, 25));
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