package br.com.jkavdev.stefanini.detran.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jkavdev.stefanini.detran.model.Veiculo;
import br.com.jkavdev.stefanini.detran.repository.IVeiculoDao;

@Stateless
public class VeiculoService {

	@Inject
	private IVeiculoDao veiculoDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Veiculo veiculo) {
		this.veiculoDao.salvar(veiculo);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Veiculo> buscarTodos() {
		return this.veiculoDao.buscarTodos();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Veiculo veiculo) throws Exception {
		try {
			veiculo = this.veiculoDao.buscarPorId(veiculo.getId());
			this.veiculoDao.remover(veiculo);
		} catch (Exception e) {
			throw new Exception("Veículo não pôde ser excluído!" + e.getMessage());
		}

	}

}
