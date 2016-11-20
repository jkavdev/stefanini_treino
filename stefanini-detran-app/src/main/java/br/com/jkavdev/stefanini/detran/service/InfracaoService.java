package br.com.jkavdev.stefanini.detran.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jkavdev.stefanini.detran.model.Infracao;
import br.com.jkavdev.stefanini.detran.repository.IInfracaoDao;

@Stateless
public class InfracaoService {

	@Inject
	private IInfracaoDao infracaoDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Infracao infracao) {
		this.infracaoDao.salvar(infracao);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Infracao> buscarTodos() {
		return this.infracaoDao.buscarTodos();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Infracao infracao) throws Exception {
		try {
			infracao = this.infracaoDao.buscarPorId(infracao.getId());
			this.infracaoDao.remover(infracao);
		} catch (Exception e) {
			throw new Exception("Infracao não pôde ser excluído!" + e.getMessage());
		}
	}

}
