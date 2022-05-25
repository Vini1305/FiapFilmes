package br.com.fiap.filme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.filme.model.Filme;

public class ProdutoDao {
	
	// criar um gerente de entidades
	EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("filme");
	EntityManager manager = factory.createEntityManager();
	
	public void cadastrar(Filme filme) {
		// iniciar transação
		manager.getTransaction().begin();
		
		// salvar o produto
		manager.persist(filme);
		
		// terminar transação
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Filme> listarTodos() {
		
			return manager
				.createQuery("SELECT f FROM Filme f", Filme.class)
				.getResultList();

	}
	
	public List<Filme> buscarPorNome(String nome){
		
			TypedQuery<Filme> query = manager
					.createQuery("SELECT f FROM Filme f WHERE nome=:nome", Filme.class);
			
			query.setParameter("nome", nome);
			
			return query.getResultList();
		
	}
	
	public void apagar(Long id) {
		Filme filme = manager.find(Filme.class, id);
		
		manager.getTransaction().begin();
		manager.remove(filme);
		manager.getTransaction().commit();

}


}
