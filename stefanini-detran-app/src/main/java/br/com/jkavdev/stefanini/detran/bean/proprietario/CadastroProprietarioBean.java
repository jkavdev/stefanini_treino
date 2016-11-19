package br.com.jkavdev.stefanini.detran.bean.proprietario;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.Endereco;
import br.com.jkavdev.stefanini.detran.model.Proprietario;
import br.com.jkavdev.stefanini.detran.model.Sexo;
import br.com.jkavdev.stefanini.detran.model.Telefone;
import br.com.jkavdev.stefanini.detran.model.TipoTelefone;
import br.com.jkavdev.stefanini.detran.service.ProprietarioService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProprietarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProprietarioService proprietarioService;

	private Proprietario proprietario;
	private Telefone telefone;

	@PostConstruct
	public void init() {
		this.limpaFormulario();
	}

	public void salvar() {
		try {
			this.proprietarioService.salvar(this.proprietario);
			FacesUtil.addSuccessMessage("Proprietário " + this.proprietario.getNome() + " salvo com sucesso");

			this.limpaFormulario();
		} catch (Exception e) {
			FacesUtil.addSuccessMessage(e.getMessage());
		}
	}

	public void salvarTelefone() {
		if (this.proprietario != null) {
			this.proprietario.adicionarTelefone(telefone);
			FacesUtil.addSuccessMessage("Telefone " + telefone.getNumero() + " salvo com sucesso");

			this.telefone = new Telefone();
		}
	}

	private void limpaFormulario() {
		this.telefone = new Telefone();
		this.proprietario = new Proprietario();
		this.proprietario.setEndereco(new Endereco());
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

	public List<TipoTelefone> getTipoTelefones() {
		return Arrays.asList(TipoTelefone.values());
	}

}
