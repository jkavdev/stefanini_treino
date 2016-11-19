package br.com.jkavdev.stefanini.detran.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceUnit(unitName="detran")
	private EntityManagerFactory factory;

	@Produces @RequestScoped
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}

	public void close(@Disposes EntityManager manager){
		manager.close();
	}
}
