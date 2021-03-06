package br.com.jkavdev.stefanini.detran.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.Agente;
import br.com.jkavdev.stefanini.detran.service.AgenteService;
import br.com.jkavdev.stefanini.detran.util.FacesUtil;

@Named
@ViewScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgenteService agenteService;

	@Inject
	private Agente agente;
	private List<Agente> agentes;
	private Agente agenteSelecionado;

	private Date dataContratacao;
	private boolean habilitarTempoServico;

	@PostConstruct
	public void init() {
		agentes = agenteService.buscarTodos();
		dataContratacao = new Date();
	}

	public void salvar() {
		try {
			agenteService.salvar(agente);

			FacesUtil.addInfoMessage("Agente " + agente.getNome() + " cadastrado com sucesso!");

			limpaFormulario();
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	public void excluir() {
		try {
			agenteService.remover(agenteSelecionado);
			agentes.remove(agenteSelecionado);

			FacesUtil.addWarnMessage("Agente " + agenteSelecionado.getNome() + " removido com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	private void limpaFormulario() {
		this.agente = new Agente();
		dataContratacao = new Date();
		buscarLista();
	}

	public void verificaDataDeContratacao() {
		habilitarTempoServico = agenteService.verificaData(dataContratacao);
		agente.setDataContratacao(dataContratacao);
	}

	private void buscarLista() {
		agentes = null;
	}

	public List<Agente> getAgentes() {
		if (agentes == null) {
			agentes = agenteService.buscarTodos();
		}

		return agentes;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public boolean isHabilitarTempoServico() {
		return habilitarTempoServico;
	}

	public void setHabilitarTempoServico(boolean habilitarTempoServico) {
		this.habilitarTempoServico = habilitarTempoServico;
	}

	public Agente getAgenteSelecionado() {
		return agenteSelecionado;
	}

	public void setAgenteSelecionado(Agente agenteSelecionado) {
		this.agenteSelecionado = agenteSelecionado;
	}

}
