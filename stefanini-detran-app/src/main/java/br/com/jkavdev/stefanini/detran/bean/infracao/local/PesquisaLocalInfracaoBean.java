package br.com.jkavdev.stefanini.detran.bean.infracao.local;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.LocalInfracao;
import br.com.jkavdev.stefanini.detran.service.LocalInfracaoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaLocalInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LocalInfracaoService localInfracaoService;

	private List<LocalInfracao> localInfracoes;
	private LocalInfracao localInfracaoSelecionado;

	@PostConstruct
	public void init() {
		this.localInfracoes = this.localInfracaoService.buscarTodos();
	}

	public void excluir() {
		try {
			this.localInfracaoService.remover(localInfracaoSelecionado);
			this.localInfracoes.remove(localInfracaoSelecionado);

			FacesUtil.addSuccessMessage("Local da infração excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public LocalInfracao getLocalInfracaoSelecionado() {
		return localInfracaoSelecionado;
	}

	public void setLocalInfracaoSelecionado(LocalInfracao LocalInfracaoSelecionado) {
		this.localInfracaoSelecionado = LocalInfracaoSelecionado;
	}

	public List<LocalInfracao> getLocalInfracoes() {
		return localInfracoes;
	}

}
