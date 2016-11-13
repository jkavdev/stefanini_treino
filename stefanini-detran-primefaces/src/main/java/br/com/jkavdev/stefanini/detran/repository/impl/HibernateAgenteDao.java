package br.com.jkavdev.stefanini.detran.repository.impl;

import javax.ejb.Stateless;

import br.com.jkavdev.stefanini.detran.model.Agente;
import br.com.jkavdev.stefanini.detran.repository.IAgenteDao;

@Stateless
public class HibernateAgenteDao extends HibernateGenericDao<Agente, Long> implements IAgenteDao {

}
