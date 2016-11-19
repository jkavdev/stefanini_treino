package br.com.jkavdev.stefanini.detran.bean.infracao.local;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.LocalInfracao;
import br.com.jkavdev.stefanini.detran.service.LocalInfracaoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroLocalInfracaoBean {

	@Inject
	private LocalInfracaoService localInfracaoService;

	@Inject
	private LocalInfracao localInfracao;

	public void salvar() {
		try {
			this.localInfracaoService.salvar(localInfracao);
			FacesUtil.addSuccessMessage("Local da infração salvo com sucesso!");
			this.limparFormulario();
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void limparFormulario() {
		this.localInfracao = new LocalInfracao();
	}

	public LocalInfracao getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(LocalInfracao LocalInfracao) {
		this.localInfracao = LocalInfracao;
	}

}
