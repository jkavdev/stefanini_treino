package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Veiculo;

public class VeiculoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Veiculo veiculo) {
		this.manager.persist(veiculo);
	}

	public List<Veiculo> todos() {
		return this.manager.createQuery("from Veiculo", Veiculo.class).getResultList();
	}
	
	public Veiculo porId(Long id){
		return this.manager.find(Veiculo.class, id);
	}
	
	public Veiculo porPlaca(String placa){
		String jpql = "select v from Veiculo v where v.placa = :placa";
		return this.manager.createQuery(jpql, Veiculo.class)
				.setParameter("placa", placa)
				.getSingleResult();
	}
	
	public void excluir(Veiculo veiculo){
		this.manager.remove(veiculo);
	}

}
