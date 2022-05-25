package br.com.fiap.filme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.fiap.filme.App;

public class ButtonController implements ActionListener {
	
	private App view;
	
	public ButtonController(App view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.carregarDados();
	}

}
