package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.LocalInfracao;
import com.stefanini.service.LocalInfracaoService;

@Named
@ViewScoped
public class LocalInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LocalInfracaoService service;
	@Inject
	private LocalInfracao local;
	private LocalInfracao localSelecionado;
	private List<LocalInfracao> locais;

	@PostConstruct
	public void init() {
		locais = service.lista();
	}

	public void cadastrar() {
		service.incluir(local);
		
		limparFormulario();
	}

	public void excluir() {
		service.excluir(localSelecionado);
		
		limparFormulario();
	}

	public void limparFormulario() {
		local = new LocalInfracao();
		locais = null;
	}

	public LocalInfracao getLocalSelecionado() {
		return localSelecionado;
	}

	public void setLocalSelecionado(LocalInfracao localSelecionado) {
		this.localSelecionado = localSelecionado;
	}

	public List<LocalInfracao> getLocais() {
		if (locais == null) {
			locais = service.lista();
		}
		return locais;
	}

	public LocalInfracao getLocal() {
		return local;
	}

	public void setLocal(LocalInfracao local) {
		this.local = local;
	}

}
