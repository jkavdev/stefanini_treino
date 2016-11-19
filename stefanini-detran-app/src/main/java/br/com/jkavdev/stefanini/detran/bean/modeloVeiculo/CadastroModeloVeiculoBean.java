package br.com.jkavdev.stefanini.detran.bean.modeloVeiculo;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.Categoria;
import br.com.jkavdev.stefanini.detran.model.ModeloVeiculo;
import br.com.jkavdev.stefanini.detran.service.ModeloVeiculoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroModeloVeiculoBean {

	@Inject
	private ModeloVeiculoService modeloVeiculoService;

	@Inject
	private ModeloVeiculo modeloVeiculo;

	public void salvar() {
		try {
			this.modeloVeiculoService.salvar(modeloVeiculo);
			FacesUtil.addSuccessMessage("Modelo do veículo salvo com sucesso!");
			this.limparFormulario();
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void limparFormulario() {
		this.modeloVeiculo = new ModeloVeiculo();
	}

	public ModeloVeiculo getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(ModeloVeiculo ModeloVeiculo) {
		this.modeloVeiculo = ModeloVeiculo;
	}

	public List<Categoria> getCategorias() {
		return Arrays.asList(Categoria.values());
	}

}
