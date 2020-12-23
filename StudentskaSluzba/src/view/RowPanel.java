package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RowPanel extends JPanel {

	private static final long serialVersionUID = 6436333664210885690L;
	
	private JLabel lbl;
	private JTextField txt;
	private JComboBox<String> cb;
	
	public RowPanel(String str) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.lbl = new JLabel(str);
		this.txt = new JTextField();
		this.cb = null;
		this.formatLabel();
		this.formatTextField();
		
		Color gray = new Color(245,245,245);
		this.add(Box.createHorizontalStrut(20));
		this.add(lbl);
		this.add(txt);
		this.setBackground(gray);
	}
	
	public RowPanel(String str, String[] opt) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.lbl = new JLabel(str);
		this.txt = null;
		this.cb = new JComboBox<String>(opt);
		this.formatLabel();
		this.formatComboBox();
		
		Color gray = new Color(245,245,245);
		this.add(Box.createHorizontalStrut(20));
		this.add(lbl);
		this.add(cb);
		this.setBackground(gray);
	}
	
	
	public JLabel getLabel() {
		return lbl;
	}

	public JTextField getTextField() {
		return txt;
	}

	public JComboBox<String> getComboBox() {
		return cb;
	}
	

	private void formatLabel() {
		Dimension lblDim = new Dimension(150, 30);
		Font dialog = new Font("Dialog", Font.ITALIC, 14);
		lbl.setPreferredSize(lblDim);
		lbl.setFont(dialog);
	}
	
	private void formatTextField() {
		Dimension txtDim = new Dimension(250, 30);
        Font dialog = new Font("Dialog", Font.PLAIN, 14);
        txt.setPreferredSize(txtDim);
		txt.setFont(dialog);
	}
	
	private void formatComboBox() {
		Dimension cbDim = new Dimension(250, 30);
        Font dialog = new Font("Dialog", Font.PLAIN, 14);
        cb.setPreferredSize(cbDim);
        cb.setFont(dialog);
		cb.setSelectedIndex(0);
		cb.setBackground(Color.WHITE);
	}
	
	
}
