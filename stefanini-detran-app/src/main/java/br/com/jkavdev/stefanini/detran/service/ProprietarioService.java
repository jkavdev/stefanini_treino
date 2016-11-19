package br.com.jkavdev.stefanini.detran.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jkavdev.stefanini.detran.model.Proprietario;
import br.com.jkavdev.stefanini.detran.repository.IProprietarioDao;

@Stateless
public class ProprietarioService {

	@Inject
	private IProprietarioDao proprietarioDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Proprietario proprietario) throws Exception {
		try {
			this.proprietarioDao.salvar(proprietario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Proprietario> buscarTodos() {
		return this.proprietarioDao.buscarTodos();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Proprietario proprietario) throws Exception {
		try {
			proprietario = this.proprietarioDao.buscarPorId(proprietario.getId());
			this.proprietarioDao.remover(proprietario);
		} catch (Exception e) {
			throw new Exception("Proprietário não pôde ser excluído!" + e.getMessage());
		}

	}

}
