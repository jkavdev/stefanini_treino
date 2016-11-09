package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Veiculo;
import com.stefanini.service.VeiculoService;

@Named
@SessionScoped
public class VeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private VeiculoService veiculoService;
	@Inject
	private Veiculo veiculo;
	private List<Veiculo> veiculos;

	@PostConstruct
	public void init() {
		veiculos = veiculoService.todos();
	}

	public void salva() {
		veiculoService.incluir(veiculo);
		limparFormulario();
	}

	private void limparFormulario() {
		veiculo = new Veiculo();
		veiculos = null;
	}

	public List<Veiculo> getVeiculos() {
		if (veiculos == null) {
			veiculos = veiculoService.todos();
		}
		return veiculos;
	}

}
