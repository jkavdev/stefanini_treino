package br.com.jkavdev.stefanini.detran.bean.infracao.tipo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.TipoInfracao;
import br.com.jkavdev.stefanini.detran.service.TipoInfracaoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroTipoInfracaoBean {

	@Inject
	private TipoInfracaoService tipoInfracaoService;

	@Inject
	private TipoInfracao tipoInfracao;

	public void salvar() {
		try {
			this.tipoInfracaoService.salvar(tipoInfracao);
			FacesUtil.addSuccessMessage("Tipo da infracao salvo com sucesso!");
			this.limparFormulario();
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void limparFormulario() {
		this.tipoInfracao = new TipoInfracao();
	}

	public TipoInfracao getTipoInfracao() {
		return tipoInfracao;
	}

	public void setTipoInfracao(TipoInfracao TipoInfracao) {
		this.tipoInfracao = TipoInfracao;
	}

}
