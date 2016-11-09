package com.stefanini.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.repository.ProprietarioRepository;

@Stateless
public class ProprietarioService {

	@Inject
	private ProprietarioRepository proprietarioRepository;  

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Proprietario proprietario) {
		proprietarioRepository.incluir(proprietario);
	}

}
