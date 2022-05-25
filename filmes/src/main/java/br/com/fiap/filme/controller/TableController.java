package br.com.fiap.filme.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.filme.App;
import br.com.fiap.filme.dao.ProdutoDao;

public class TableController implements MouseListener {
	
	private ProdutoDao dao = new ProdutoDao();
	private App view;

	public TableController(App view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int resposta = JOptionPane.showConfirmDialog(null,
					"Apagar filme?");
			if (resposta == JOptionPane.YES_OPTION) {
				JTable table = (JTable) e.getSource();
				String id = (String) table.getValueAt(table.getSelectedRow(), 0);
				dao.apagar(Long.valueOf(id));
				view.carregarDados();
				JOptionPane.showMessageDialog(null, "Filme retirado do registro!");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	

}
