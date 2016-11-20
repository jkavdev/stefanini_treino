package br.com.jkavdev.stefanini.detran.repository.hibernate;

import br.com.jkavdev.stefanini.detran.model.Proprietario;
import br.com.jkavdev.stefanini.detran.repository.IProprietarioDao;

public class HibernateProprietarioDao extends HibernateGenericDao<Proprietario, Long> implements IProprietarioDao {

	private static final long serialVersionUID = 1L;

	@Override
	public Proprietario buscaComTelefones(Long id) {
		String jpql = "select p from Proprietario p inner join fetch p.telefones where p.id = :codigo";
		return manager.createQuery(jpql, Proprietario.class)
				.setParameter("codigo", id)
				.getSingleResult();
	}
}
