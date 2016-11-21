package br.com.jkavdev.stefanini.detran.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jkavdev.stefanini.detran.model.TipoInfracao;
import br.com.jkavdev.stefanini.detran.repository.ITipoInfracaoDao;

@Stateless
public class TipoInfracaoService {

	@Inject
	private ITipoInfracaoDao tipoInfracaoDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(TipoInfracao tipoInfracao) {
		this.tipoInfracaoDao.salvar(tipoInfracao);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TipoInfracao> buscarTodos() {
		return this.tipoInfracaoDao.buscarTodos();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(TipoInfracao TipoInfracao) throws Exception {
		try {
			TipoInfracao = this.tipoInfracaoDao.buscarPorId(TipoInfracao.getId());
			this.tipoInfracaoDao.remover(TipoInfracao);
		} catch (Exception e) {
			throw new Exception("Tipo da infracao não pôde ser excluído!" + e.getMessage());
		}
	}

	public List<TipoInfracao> infracoesComValor() {
		return this.tipoInfracaoDao.infracoesComValorAlto();
	}

}
