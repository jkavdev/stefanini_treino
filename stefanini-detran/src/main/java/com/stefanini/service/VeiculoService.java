package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

import com.stefanini.model.Veiculo;
import com.stefanini.repository.VeiculoRepository;

@Stateless
public class VeiculoService {

	@Inject
	private VeiculoRepository veiculoRepository;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Veiculo> todos() {
		return this.veiculoRepository.todos();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Veiculo porPlaca(String placa) {
		return this.veiculoRepository.porPlaca(placa);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Veiculo porId(Long id) {
		return this.veiculoRepository.porId(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluir(Veiculo veiculo) throws Exception {
		try {
			veiculo = porId(veiculo.getId());
			
			if (veiculo != null) {
				veiculoRepository.excluir(veiculo);
			}
		} catch (PersistenceException e) {
			throw new Exception("Não pode excluir o veiculo: " + e.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Veiculo veiculo) throws Exception {
//		Veiculo veiculoDoBanco = porPlaca(veiculo.getPlaca());
//
//		if (veiculoDoBanco != null && veiculoDoBanco.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
//			throw new Exception("Já existe um veiculo cadastrado com esta placa!");
//		}

		veiculoRepository.incluir(veiculo);
	}

}
