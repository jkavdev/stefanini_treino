package com.stefanini.bean.proprietario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.service.ProprietarioService;
import com.stefanini.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProprietarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProprietarioService proprietarioService;
	
	private Proprietario proprietarioSelecionado;
	private Proprietario proprietarioSelecionadoAExcluir;
	private List<Proprietario> proprietarios;

	@PostConstruct
	public void init() {
		proprietarios = proprietarioService.todos();
	}

	public void excluir() {
		try {
			proprietarioService.remover(proprietarioSelecionado);
			FacesUtil.adicionarMensagemInfo(
					"Proprietario " + proprietarioSelecionado.getNome() + " excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void buscarProprietarioComTelefone() {
		try {
			proprietarioSelecionado = this.proprietarioService.comTelefone(proprietarioSelecionado.getId());
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public Proprietario getProprietarioSelecionado() {
		return proprietarioSelecionado;
	}

	public void setProprietarioSelecionado(Proprietario proprietarioSelecionado) {
		this.proprietarioSelecionado = proprietarioSelecionado;
	}
	
	public Proprietario getProprietarioSelecionadoAExcluir() {
		return proprietarioSelecionadoAExcluir;
	}
	
	public void setProprietarioSelecionadoAExcluir(Proprietario proprietarioSelecionadoAExcluir) {
		this.proprietarioSelecionadoAExcluir = proprietarioSelecionadoAExcluir;
	}

	public List<Proprietario> getProprietarios() {
//		if (proprietarios == null) {
//			proprietarios = proprietarioService.todos();
//		}
		return proprietarios;
	}

}
