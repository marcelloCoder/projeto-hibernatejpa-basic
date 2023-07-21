package br.com.mcoder.HibernateJPATeste.entities;

import br.com.mcoder.HibernateJPATeste.interfaces.ILojaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LojaDAO implements ILojaDAO{

	@Override
	public Cliente cadastrar(Cliente cli) {

		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(cli);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		
		return cli;
	}

}
