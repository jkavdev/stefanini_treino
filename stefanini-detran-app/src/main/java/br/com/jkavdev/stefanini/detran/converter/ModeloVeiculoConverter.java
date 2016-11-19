package br.com.jkavdev.stefanini.detran.converter;

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
