package br.com.jkavdev.stefanini.detran.service.impl;

import java.io.Serializable;
import java.util.List;

import br.com.jkavdev.stefanini.detran.repository.GenericDao;
import br.com.jkavdev.stefanini.detran.service.GenericService;
import br.com.jkavdev.stefanini.detran.service.ServiceException;

public abstract class GenericServiceImpl<T, ID extends Serializable, D extends GenericDao<T, ID>>
		implements GenericService<T, ID> {

	protected abstract D getDao();

	@Override
	public void salvar(T entidade) throws ServiceException {
		getDao().salvar(entidade);
	}

	@Override
	public void remover(T entidade) throws ServiceException {
		getDao().remover(entidade);
	}

	@Override
	public T buscarPorId(ID id) {
		return getDao().buscarPorId(id);
	}

	@Override
	public List<T> buscarTodos() {
		return getDao().buscarTodos();
	}

	@Override
	public void alterar(T entidade) {
		getDao().alterar(entidade);
	}

}
