package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.TipoInfracao;
import com.stefanini.service.TipoService;

@Named
@ViewScoped
public class TipoInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoInfracao tipo;
	@Inject
	private TipoService tipoService;
	private List<TipoInfracao> tipos;

	public void cadastrar() {
		tipoService.incluir(tipo);
	}

	public void limparFormulario() {
		tipo = new TipoInfracao();
		tipos = null;
	}
	
//	public void excluir(){
//		tipoService.e
//	}

	public List<TipoInfracao> getTipos() {
		if (tipos == null) {
			tipos = tipoService.lista();
		}
		return tipos;
	}

	public TipoInfracao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInfracao tipo) {
		this.tipo = tipo;
	}

}
