package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Infracao;

public class InfracaoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Infracao infracao) {
		this.manager.persist(infracao);
	}

	public void altera(Infracao infracao) {
		this.manager.merge(infracao);
	}

	public Infracao busca(Long id) {
		return this.manager.find(Infracao.class, id);
	}

	public List<Infracao> lista() {
		return this.manager.createQuery("select l from Infracao l", Infracao.class).getResultList();
	}

	public void excluir(Infracao infracaoSelecionado) {
		this.manager.remove(infracaoSelecionado);
	}

}
