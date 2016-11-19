package br.com.jkavdev.stefanini.detran.bean.infracao.tipo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.TipoInfracao;
import br.com.jkavdev.stefanini.detran.service.TipoInfracaoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTipoInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoInfracaoService tipoInfracaoService;

	private List<TipoInfracao> tipoInfracoes;
	private TipoInfracao tipoInfracaoSelecionado;

	@PostConstruct
	public void init() {
		this.tipoInfracoes = this.tipoInfracaoService.buscarTodos();
	}

	public void excluir() {
		try {
			this.tipoInfracaoService.remover(tipoInfracaoSelecionado);
			this.tipoInfracoes.remove(tipoInfracaoSelecionado);

			FacesUtil.addSuccessMessage("Tipo da infração excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public TipoInfracao getTipoInfracaoSelecionado() {
		return tipoInfracaoSelecionado;
	}

	public void setTipoInfracaoSelecionado(TipoInfracao TipoInfracaoSelecionado) {
		this.tipoInfracaoSelecionado = TipoInfracaoSelecionado;
	}

	public List<TipoInfracao> getTipoInfracoes() {
		return tipoInfracoes;
	}

}
