package br.com.jkavdev.stefanini.detran.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.jkavdev.stefanini.detran.model.Agente;
import br.com.jkavdev.stefanini.detran.repository.IAgenteDao;

@Stateless
public class AgenteService {

	@Inject
	private IAgenteDao agenteDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Agente agente) throws NegocioException {

		if (agente.getNome() == null || "".equals(agente.getNome().trim())) {
			throw new NegocioException("Nome do agente é obrigatório!");
		}

		this.agenteDao.salvar(agente);
	}

	public List<Agente> buscarTodos() {
		return agenteDao.buscarTodos();
	}

	public Agente buscarPorId(Long id) {
		return agenteDao.buscarPorId(id);
	}

	public void remover(Agente agenteSelecionado) throws NegocioException {
		try {
			agenteSelecionado = buscarPorId(agenteSelecionado.getId());
			
			agenteDao.remover(agenteSelecionado);
		} catch (PersistenceException e) {
			throw new NegocioException("Agente não pôde ser excluído!: " + e.getMessage());
		}
	}

}
