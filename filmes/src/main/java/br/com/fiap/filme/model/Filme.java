package br.com.fiap.filme.model;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//POJO
//BO
@Entity @Table(name = "apmd_filmes")
public class Filme {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filme")
	@SequenceGenerator(sequenceName = "filme", allocationSize = 1, name = "filme")
	private Long codigo;
	
	private String titulo;
	private String sinopse;
	private String genero;
	private String ondeAssistir;
	private String assistido;
	private String avaliacao;
	
	public Filme() {
		
	}
		
	public Filme(String titulo, String sinopse, String genero, String ondeAssistir, String assistido, String avaliacao ) {
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.genero = genero;
		this.ondeAssistir = ondeAssistir;
		this.assistido = assistido;
		this.avaliacao = avaliacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getOndeAssistir() {
		return ondeAssistir;
	}

	public void setOndeAssistir(String ondeAssistir) {
		this.ondeAssistir = ondeAssistir;
	}

	public String getAssistido() {
		return assistido;
	}

	public void setAssistido(String assistido) {
		this.assistido = assistido;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public Vector<String> getData() {
		Vector<String> data = new Vector<String>();
		data.add(codigo.toString());
		data.add(titulo);
		data.add(sinopse);
		data.add(genero);
		data.add(ondeAssistir);
		data.add(assistido);
		data.add(avaliacao);

		return data;
		
	}

}
