package br.com.jkavdev.stefanini.detran.bean.agente;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.Agente;
import br.com.jkavdev.stefanini.detran.service.AgenteService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAgenteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private AgenteService agenteService;

	private List<Agente> agentes;
	private Agente agenteSelecionado;

	@PostConstruct
	public void init() {
		this.agentes = this.agenteService.buscarTodos();
	}

	public void excluir() {
		try {
			this.agenteService.remover(agenteSelecionado);
			this.agentes.remove(agenteSelecionado);

			FacesUtil.addSuccessMessage("Agente " + agenteSelecionado.getNome() + " excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Agente getAgenteSelecionado() {
		return agenteSelecionado;
	}

	public void setAgenteSelecionado(Agente agenteSelecionado) {
		this.agenteSelecionado = agenteSelecionado;
	}

	public List<Agente> getAgentes() {
		return agentes;
	}

}
