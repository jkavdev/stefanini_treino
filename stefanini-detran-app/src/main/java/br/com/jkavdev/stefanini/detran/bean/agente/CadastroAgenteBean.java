package br.com.jkavdev.stefanini.detran.bean.agente;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.Agente;
import br.com.jkavdev.stefanini.detran.service.AgenteService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroAgenteBean {

	@Inject
	private AgenteService agenteService;

	@Inject
	private Agente agente;

	public void salvar() {
		try {
			this.agenteService.salvar(agente);
			FacesUtil.addSuccessMessage("Agente " + agente.getNome() + " salvo com sucesso!");
			this.limparFormulario();
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void limparFormulario() {
		this.agente = new Agente();
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

}
