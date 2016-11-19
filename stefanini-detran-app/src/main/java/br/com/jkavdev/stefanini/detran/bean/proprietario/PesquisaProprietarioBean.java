package br.com.jkavdev.stefanini.detran.bean.proprietario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.Proprietario;
import br.com.jkavdev.stefanini.detran.service.ProprietarioService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProprietarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProprietarioService proprietarioService;

	private List<Proprietario> proprietarios;
	private Proprietario proprietarioSelecionado;
	private Proprietario proprietarioSelecionadoParaExclusao;

	@PostConstruct
	public void init() {
		this.proprietarios = this.proprietarioService.buscarTodos();
	}

	public void excluir() {
		try {
			this.proprietarioService.remover(proprietarioSelecionadoParaExclusao);
			this.proprietarios.remove(proprietarioSelecionadoParaExclusao);

			FacesUtil.addSuccessMessage("Proprietário " + proprietarioSelecionadoParaExclusao.getNome() + " excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void buscaProprietarioComTelefone(){
		this.proprietarioSelecionado = this.proprietarioService.buscaComTelefones(proprietarioSelecionado.getId());
	}

	public Proprietario getProprietarioSelecionado() {
		return proprietarioSelecionado;
	}

	public void setProprietarioSelecionado(Proprietario proprietarioSelecionado) {
		this.proprietarioSelecionado = proprietarioSelecionado;
	}

	public List<Proprietario> getProprietarios() {
		return proprietarios;
	}

	public Proprietario getProprietarioSelecionadoParaExclusao() {
		return proprietarioSelecionadoParaExclusao;
	}

	public void setProprietarioSelecionadoParaExclusao(Proprietario proprietarioSelecionadoParaExclusao) {
		this.proprietarioSelecionadoParaExclusao = proprietarioSelecionadoParaExclusao;
	}

}
