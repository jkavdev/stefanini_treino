package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.TipoInfracao;
import com.stefanini.model.Veiculo;

public class TipoInfracaoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(TipoInfracao tipo) {
		this.manager.persist(tipo);
	}

	public void altera(TipoInfracao tipo) {
		this.manager.merge(tipo);
	}

	public TipoInfracao busca(Integer id) {
		return this.manager.find(TipoInfracao.class, id);
	}

	public List<TipoInfracao> lista() {
		return this.manager.createQuery("select t from TipoInfracao t", TipoInfracao.class).getResultList();
	}

	public void excluir(TipoInfracao tipo) {
		this.manager.remove(tipo);
	}
}
