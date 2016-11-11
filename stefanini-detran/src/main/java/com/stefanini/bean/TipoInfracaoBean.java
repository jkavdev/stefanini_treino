package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
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
	private TipoInfracao tipoSelecionado;
	
	@PostConstruct
	public void init(){
		tipos = tipoService.lista();
	}

	public void cadastrar() {
		tipoService.incluir(tipo);

		limparFormulario();
	}

	public void limparFormulario() {
		tipo = new TipoInfracao();
		tipos = null;
	}

	public void excluir() {
		tipoService.excluir(tipoSelecionado);
		
		limparFormulario();
	}

	public List<TipoInfracao> getTipos() {
		if (tipos == null) {
			tipos = tipoService.lista();
		}
		return tipos;
	}

	public TipoInfracao getTipoSelecionado() {
		return tipoSelecionado;
	}

	public void setTipoSelecionado(TipoInfracao tipoSelecionado) {
		this.tipoSelecionado = tipoSelecionado;
	}

	public TipoInfracao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInfracao tipo) {
		this.tipo = tipo;
	}

}
