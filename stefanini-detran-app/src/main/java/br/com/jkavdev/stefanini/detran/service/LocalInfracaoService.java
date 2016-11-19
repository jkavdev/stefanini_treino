package br.com.jkavdev.stefanini.detran.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jkavdev.stefanini.detran.model.LocalInfracao;
import br.com.jkavdev.stefanini.detran.repository.ILocalInfracaoDao;

@Stateless
public class LocalInfracaoService {

	@Inject
	private ILocalInfracaoDao localInfracaoDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(LocalInfracao localInfracao) {
		this.localInfracaoDao.salvar(localInfracao);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<LocalInfracao> buscarTodos() {
		return this.localInfracaoDao.buscarTodos();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(LocalInfracao localInfracao) throws Exception {
		try {
			localInfracao = this.localInfracaoDao.buscarPorId(localInfracao.getId());
			this.localInfracaoDao.remover(localInfracao);
		} catch (Exception e) {
			throw new Exception("Local da infracao não pôde ser excluído!" + e.getMessage());
		}

	}

}
