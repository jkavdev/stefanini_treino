package com.stefanini.bean.proprietario;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Sexo;
import com.stefanini.model.Telefone;
import com.stefanini.model.TipoTelefone;
import com.stefanini.service.ProprietarioService;
import com.stefanini.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProprietarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProprietarioService proprietarioService;
	@Inject
	private Proprietario proprietario;
	@Inject
	private Telefone telefone;

	public void salvar() {
		try {
			proprietarioService.incluir(proprietario);
			FacesUtil.adicionarMensagemInfo("Proprietário " + proprietario.getNome() + " cadastrado com sucesso!");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
		}

		limparFormulario();
	}

	public void salvarTelefone() {
		if (this.proprietario != null) {
			this.proprietario.adicionarTelefone(telefone);			
			this.telefone = new Telefone();
		}
	}

	private void limparFormulario() {
		proprietario = new Proprietario();
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Sexo> getSexos() {
		return Arrays.asList(Sexo.values());
	}

	public List<TipoTelefone> getTipoTelefone() {
		return Arrays.asList(TipoTelefone.values());
	}

}
