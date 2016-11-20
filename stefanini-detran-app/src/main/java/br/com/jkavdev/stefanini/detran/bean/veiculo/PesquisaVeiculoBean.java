package br.com.jkavdev.stefanini.detran.bean.veiculo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.Veiculo;
import br.com.jkavdev.stefanini.detran.service.VeiculoService;

@Named
@ViewScoped
public class PesquisaVeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private VeiculoService veiculoService;

	private List<Veiculo> veiculos;

	@PostConstruct
	public void init() {
		this.veiculos = this.veiculoService.buscarTodos();
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

}
