package br.com.jkavdev.stefanini.detran.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jkavdev.stefanini.detran.model.ModeloVeiculo;
import br.com.jkavdev.stefanini.detran.repository.IModeloVeiculoDao;

@Stateless
public class ModeloVeiculoService {

	@Inject
	private IModeloVeiculoDao modeloVeiculoDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(ModeloVeiculo modeloVeiculo) {
		this.modeloVeiculoDao.salvar(modeloVeiculo);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ModeloVeiculo> buscarTodos() {
		return this.modeloVeiculoDao.buscarTodos();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(ModeloVeiculo modeloVeiculo) throws Exception {
		try {
			modeloVeiculo = this.modeloVeiculoDao.buscarPorId(modeloVeiculo.getId());
			this.modeloVeiculoDao.remover(modeloVeiculo);
		} catch (Exception e) {
			throw new Exception("Modelo do veículo não pôde ser excluído!" + e.getMessage());
		}

	}

}
