package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Modelo;
import com.stefanini.repository.ModeloRepository;

@Stateless
public class ModeloService {

	@Inject
	private ModeloRepository modeloRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Modelo modelo) {
		modeloRepository.incluir(modelo);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Modelo> todos() {
		return this.modeloRepository.todos();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Modelo porId(Long id) {
		return this.modeloRepository.porId(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Modelo modelogente) throws Exception {
		try {
			modelogente = porId(modelogente.getId());
			if (modelogente != null) {
				this.modeloRepository.excluir(modelogente);
			}
		} catch (Exception e) {
			throw new Exception("Modelo não pode ser excluído!");
		}
	}

}
