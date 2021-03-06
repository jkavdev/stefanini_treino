package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Modelo;

public class ModeloRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Modelo modelo) {
		this.manager.persist(modelo);
	}

	public List<Modelo> todos() {
		return this.manager.createQuery("from Modelo", Modelo.class).getResultList();
	}

	public Modelo porId(Long id) {
		return this.manager.find(Modelo.class, id);
	}

	public void excluir(Modelo modelo) {
		this.manager.remove(modelo);
	}

}
