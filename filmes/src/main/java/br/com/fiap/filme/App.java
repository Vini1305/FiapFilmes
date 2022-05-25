package br.com.fiap.filme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;


import br.com.fiap.filme.controller.ButtonController;
import br.com.fiap.filme.controller.TableController;
import br.com.fiap.filme.dao.ProdutoDao;
import br.com.fiap.filme.model.Filme;

public class App extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	
	public static void main(String[] args) {
		new App().init();
	}
	
	public void init() {
		JFrame janela = new JFrame("Fiap Movies");
				
		ImageIcon imagemTituloJanela = new ImageIcon("src/main/java/Images/movieIcon.jpg"); 
				
		JTabbedPane abas = new JTabbedPane();
				
		janela.add(abas);
				
		JPanel frame1 = new JPanel();
		JPanel frame2 = new JPanel();
		
		Vector<String> colunas = new Vector<String>();
		colunas.add("Número");
		colunas.add("Título");
		colunas.add("Sinopse");
		colunas.add("Gênero");
		colunas.add("Onde Assistir");
		colunas.add("Já assistido?");
		colunas.add("Avaliação 1 a 5");

		tableModel = new DefaultTableModel(colunas , 0);
		JTable table = new JTable(tableModel);
				
		TableController tableController = new TableController(this);
		table.addMouseListener(tableController);
		table.setDefaultEditor(Object.class, null);
						
		frame2.setLayout(new BorderLayout());
		frame2.add(new JScrollPane(table), BorderLayout.CENTER);
				
		JButton atualizar = new JButton("Atualizar");
		frame2.add(atualizar, BorderLayout.PAGE_END);
		ButtonController listener = new ButtonController(this);
		atualizar.addActionListener(listener);
		
				
		abas.add("Cadastro", frame1);
		abas.add("Lista", frame2);
		
		JPanel painel1 = new JPanel();
		JPanel painel2 = new JPanel();
		JPanel painel3 = new JPanel();
		JPanel subpainel1 = new JPanel();
				
		frame1.setLayout(new BorderLayout(70,50));
		frame1.add(painel1, BorderLayout.CENTER);
		frame1.add(painel2, BorderLayout.LINE_START);
		frame1.add(painel3, BorderLayout.LINE_END);
					
		InterfaceLabel label1 = new InterfaceLabel("Titulo");
		InterfaceLabel label2 = new InterfaceLabel("Sinopse");
		InterfaceLabel label3 = new InterfaceLabel("Gênero");
		InterfaceLabel label4 = new InterfaceLabel("Onde Assistir");
		InterfaceLabel label5 = new InterfaceLabel("Avaliação");
						
		InterfaceTextFields tfield1 = new InterfaceTextFields();
		InterfaceTextFields tfield2 = new InterfaceTextFields();
		
		String[] gênero = {"Comédia", "Ação",
							"Romance", "Aventura",
							"Sci-Fi", "Fantasia",
							"Horror", "Drama",
							"Documentário", "Histórico"};
				
		JButton button1 = new JButton("Salvar");
		JButton button2 = new JButton("Cancelar");
		JComboBox<String> selecao = new JComboBox<String>(gênero);
				
		painel1.setLayout(new GridLayout(7, 1, 0, 10));
		painel1.setPreferredSize(new Dimension(150, 390));
		painel1.add(label1);
		painel1.add(tfield1);
		painel1.add(label2);
		painel1.add(tfield2);
		painel1.add(label3);
		painel1.add(selecao);
		painel1.add(subpainel1);
		subpainel1.setLayout(new GridLayout(1, 2, 10, 0));
		subpainel1.add(button1);
		subpainel1.add(button2);
				
		painel2.setLayout(new GridLayout(1, 1));
		painel2.setPreferredSize(new Dimension(180, 390));
		painel2.add(new JLabel(new ImageIcon("src/main/java/Images/Banner DocStr.jpeg")));
				
		InterfaceCheckBox check1 = new InterfaceCheckBox("Assistido");
				
		ButtonGroup buttonGroup1 = new ButtonGroup();
				
		JRadioButton netflix = new JRadioButton("Netflix");
		netflix.setActionCommand("Netflix");		
		JRadioButton primeVideo = new JRadioButton("Prime Video");
		primeVideo.setActionCommand("Prime Video");
		JRadioButton pirateBay = new JRadioButton("Pirate Bay");
		pirateBay.setActionCommand("Pirate Bay");
				
		buttonGroup1.add(netflix);
		buttonGroup1.add(primeVideo);
		buttonGroup1.add(pirateBay);
		
		StarRater starRater = new StarRater(5);
				
		painel3.setLayout(new GridLayout(7, 1, 0, 0));
		painel3.setPreferredSize(new Dimension(150, 390));
		painel3.add(label4);
		painel3.add(netflix);
		painel3.add(primeVideo);
		painel3.add(pirateBay);
		painel3.add(check1);
		painel3.add(label5);
		painel3.add(starRater);
				
		ActionListener listenerSalvar = new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				//pegando gênero
				int ListIndex = selecao.getSelectedIndex();
				String ListText = gênero[ListIndex];
				//pegando onde assistir
				ButtonModel selection = buttonGroup1.getSelection();
				String textoSelecionado = selection.getActionCommand();
				//pegando se foi assistido
				String assistido = "";
				if (check1.isSelected() == true)
					assistido = "Sim";
				else
					assistido = "Não";
				//pegando estrelas 1 to 5
				int estrelas = starRater.getSelection();
				String estrelasStr = Integer.toString(estrelas);
	
				Filme filme = new Filme();
				
				filme.setTitulo(tfield1.getText());
				filme.setSinopse(tfield2.getText());
				filme.setGenero(ListText);
				filme.setOndeAssistir(textoSelecionado);
				filme.setAssistido(assistido);
				filme.setAvaliacao(estrelasStr);

				ProdutoDao dao = new ProdutoDao();
				dao.cadastrar(filme);
							
				JOptionPane.showMessageDialog(null, filme.getTitulo() + " salvo!");

				}
			};
				
		button1.addActionListener(listenerSalvar);
				
		janela.setIconImage(imagemTituloJanela.getImage());
		janela.setSize(700, 400);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void carregarDados() {
		tableModel.setRowCount(0);
		ProdutoDao dao = new ProdutoDao();
		List<Filme> lista = dao.listarTodos();
		lista.forEach(filme -> tableModel.addRow(filme.getData()));
	}

}
