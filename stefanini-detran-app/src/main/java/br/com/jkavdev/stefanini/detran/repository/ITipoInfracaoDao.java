package br.com.jkavdev.stefanini.detran.repository;

import java.util.List;

import br.com.jkavdev.stefanini.detran.model.TipoInfracao;

public interface ITipoInfracaoDao extends GenericDao<TipoInfracao, Long> {
	
	List<TipoInfracao> infracoesComValorAlto();

}
