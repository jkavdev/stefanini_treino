package com.stefanini.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Proprietario;

public class ProprietarioRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Proprietario proprietario) {
		this.manager.persist(proprietario);
	}

}
