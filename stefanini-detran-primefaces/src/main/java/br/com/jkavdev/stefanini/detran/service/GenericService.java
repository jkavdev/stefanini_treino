package br.com.jkavdev.stefanini.detran.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {
	
	public void salvar(T entidade) throws ServiceException;
	public void alterar(T entidade);
	public void remover(T entidade) throws ServiceException;
	public T buscarPorId(ID id);
	public List<T> buscarTodos();

}
