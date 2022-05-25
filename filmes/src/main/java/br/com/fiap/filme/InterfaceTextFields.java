package br.com.fiap.filme;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

public class InterfaceTextFields extends JTextField {
	
	private static final long serialVersionUID = 1L;
	
	public InterfaceTextFields() {
		init();
	}

	public void init() {
		this.setPreferredSize(new Dimension(20,30));
		this.setBackground(Color.WHITE);
		this.setForeground(new Color(50,50,50));
		this.setBorder(BorderFactory.criar());
	}
	
}
