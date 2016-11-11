package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Infracao;
import com.stefanini.repository.InfracaoRepository;

@Stateless
public class InfracaoService {

	@Inject
	private InfracaoRepository infracaoRepositorio;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Infracao i) {
		infracaoRepositorio.incluir(i);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Infracao> lista() {
		return this.infracaoRepositorio.lista();
	}

	public Infracao porId(Long id) {
		return this.infracaoRepositorio.busca(id);
	}

	public void excluir(Infracao infracaoSelecionado) {
		infracaoSelecionado = porId(infracaoSelecionado.getId());
		
		if (infracaoSelecionado != null) {
			this.infracaoRepositorio.excluir(infracaoSelecionado);
		}

	}

}
