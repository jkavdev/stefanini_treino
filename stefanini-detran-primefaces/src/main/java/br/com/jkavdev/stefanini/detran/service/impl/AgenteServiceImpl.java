package br.com.jkavdev.stefanini.detran.service.impl;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.jkavdev.stefanini.detran.model.Agente;
import br.com.jkavdev.stefanini.detran.repository.IAgenteDao;
import br.com.jkavdev.stefanini.detran.service.AgenteService;
import br.com.jkavdev.stefanini.detran.service.ServiceException;

@Stateless
public class AgenteServiceImpl extends GenericServiceImpl<Agente, Long, IAgenteDao> implements AgenteService {

	@Inject
	private IAgenteDao agenteDao;

	@Override
	protected IAgenteDao getDao() {
		return agenteDao;
	}

	@Override
	public void salvar(Agente agente) throws ServiceException {

		if (agente.getNome() == null || "".equals(agente.getNome().trim())) {
			throw new ServiceException("Nome do agente é obrigatório!");
		}

		if (agente.getId() == null) {
			super.alterar(agente);
		} else {
			super.salvar(agente);
		}

	}

	@Override
	public void remover(Agente agente) throws ServiceException {
		try {
			agente = super.buscarPorId(agente.getId());

			super.remover(agente);
		} catch (PersistenceException e) {
			throw new ServiceException("Agente não pôde ser excluído!: " + e.getMessage());
		}
	}
	
	public boolean verificaData(Date dataContratacao) {
		Calendar dataAVerificar = Calendar.getInstance();
		dataAVerificar.setTime(dataContratacao);
		
		Calendar dataAtualMenosUmAno = Calendar.getInstance();
		dataAtualMenosUmAno.add(Calendar.YEAR, -1);
		
		if (dataAVerificar.compareTo(dataAtualMenosUmAno) == -1) {
			return true;
		}
		
		return false;
	}

}
