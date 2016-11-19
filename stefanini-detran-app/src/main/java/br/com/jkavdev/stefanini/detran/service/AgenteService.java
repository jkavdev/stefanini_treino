package br.com.jkavdev.stefanini.detran.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jkavdev.stefanini.detran.model.Agente;
import br.com.jkavdev.stefanini.detran.repository.IAgenteDao;

@Stateless
public class AgenteService {

	@Inject
	private IAgenteDao agenteDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Agente agente) {
		this.agenteDao.salvar(agente);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Agente> buscarTodos() {
		return this.agenteDao.buscarTodos();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Agente agente) throws Exception {
		try {
			agente = this.agenteDao.buscarPorId(agente.getId());
			this.agenteDao.remover(agente);
		} catch (Exception e) {
			throw new Exception("Agente não pôde ser excluído!" + e.getMessage());
		}

	}

}
