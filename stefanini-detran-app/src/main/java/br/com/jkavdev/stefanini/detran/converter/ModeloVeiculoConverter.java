package br.com.jkavdev.stefanini.detran.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.stefanini.detran.model.ModeloVeiculo;
import br.com.jkavdev.stefanini.detran.repository.hibernate.HibernateModeloVeiculoDao;
import br.com.jkavdev.stefanini.detran.util.cdi.CDIServiceLocator;

//@FacesConverter(forClass = ModeloVeiculo.class)
//public class ModeloVeiculoConverter implements Converter {
//
//	private HibernateModeloVeiculoDao modeloVeiculoDao;
//
//	public ModeloVeiculoConverter() {
//		this.modeloVeiculoDao = CDIServiceLocator.getBean(HibernateModeloVeiculoDao.class);
//	}
//
//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		ModeloVeiculo retorno = null;
//
//		if (value != null) {
//			retorno = modeloVeiculoDao.buscarPorId(new Long(value));
//		}
//
//		return retorno;
//	}
//
//	@Override
//	public String getAsString(FacesContext context, UIComponent component, Object value) {
//		if (value != null) {
//			Long codigo = ((ModeloVeiculo) value).getId();
//			String retorno = codigo == null ? null : codigo.toString();
//
//			return retorno;
//		}
//
//		return "";
//	}
//
//}
