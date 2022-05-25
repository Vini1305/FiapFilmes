package br.com.fiap.filme;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class InterfaceLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private int fontSize = 14;
	
	public InterfaceLabel(String texto) {
		super(texto);
		init();
	}
	
	public InterfaceLabel(String texto, int fontSize) {
		super(texto);
		this.fontSize = fontSize;
		init();
	}

	public void init() {
		this.setHorizontalAlignment(JLabel.LEFT);
		this.setForeground(new Color(0, 0, 0));
		this.setFont(new Font(null, Font.BOLD, this.fontSize));
	}
	
}
