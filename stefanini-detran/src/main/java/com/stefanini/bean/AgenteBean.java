package com.stefanini.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;
import com.stefanini.util.jsf.FacesUtil;

@Named
@SessionScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgenteService agenteService;
	@Inject
	private Agente agente;
	private Agente agenteSelecionado;
	private List<Agente> agentes;
	private boolean verificado;
	private Date dataContratacao;

	@PostConstruct
	public void init() {
		agentes = agenteService.todos();
	}

	public void salva() {
		try {
			agente.setDataContratacao(dataContratacao);
			agenteService.incluir(agente);
			FacesUtil.adicionarMensagemInfo("Agente " + agente.getNome() + " cadastrado com sucesso!");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}

		limparFormulario();
	}

	public void excluir() {
		try {
			agenteService.remover(agenteSelecionado);
			FacesUtil.adicionarMensagemInfo("Agente " + agenteSelecionado.getNome() + " excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
		}

		limparFormulario();
	}

	private void limparFormulario() {
		agente = new Agente();
		agentes = null;
		dataContratacao = null;
		verificado = false;
	}

	public void verificar() {
		Calendar c = Calendar.getInstance();
		c.setTime(dataContratacao);
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.YEAR, -1);
		if (c.compareTo(c2) == -1) {
			verificado = true;
		}
		agente.setDataContratacao(dataContratacao);
	}

	public List<Agente> getAgentes() {
		if (agentes == null) {
			agentes = agenteService.todos();
		}
		return agentes;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Agente getAgenteSelecionado() {
		return agenteSelecionado;
	}

	public void setAgenteSelecionado(Agente agenteSelecionado) {
		this.agenteSelecionado = agenteSelecionado;
	}

}
