package br.com.jkavdev.stefanini.detran.service;

import java.util.Date;

import br.com.jkavdev.stefanini.detran.model.Agente;

public interface AgenteService extends GenericService<Agente, Long> {
	
	boolean verificaData(Date dataContratacao);

}
