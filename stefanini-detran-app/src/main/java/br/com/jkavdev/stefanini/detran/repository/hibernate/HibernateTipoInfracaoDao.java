package br.com.jkavdev.stefanini.detran.repository.hibernate;

import java.util.List;

import br.com.jkavdev.stefanini.detran.model.TipoInfracao;
import br.com.jkavdev.stefanini.detran.repository.ITipoInfracaoDao;

public class HibernateTipoInfracaoDao extends HibernateGenericDao<TipoInfracao, Long> implements ITipoInfracaoDao {

	private static final long serialVersionUID = 1L;

	@Override
	public List<TipoInfracao> infracoesComValorAlto() {
		return manager.createQuery("select t from TipoInfracao t order by t.valorInfracao desc", TipoInfracao.class)
				.setMaxResults(7)
				.getResultList();
	}

}
