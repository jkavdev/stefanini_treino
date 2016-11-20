package br.com.jkavdev.stefanini.detran.repository.hibernate;

import java.util.List;

import br.com.jkavdev.stefanini.detran.model.Veiculo;
import br.com.jkavdev.stefanini.detran.repository.IVeiculoDao;

public class HibernateVeiculoDao extends HibernateGenericDao<Veiculo, Long> implements IVeiculoDao {

	private static final long serialVersionUID = 1L;
	
	@Override
	public List<Veiculo> buscarTodos() {
		String jpql = "select v from Veiculo v inner join fetch v.proprietario inner join fetch v.modelo";
		return manager.createQuery(jpql, Veiculo.class).getResultList();
	}

}
