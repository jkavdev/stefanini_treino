package br.com.jkavdev.stefanini.detran.bean.veiculo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.ModeloVeiculo;
import br.com.jkavdev.stefanini.detran.service.ModeloVeiculoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaVeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloVeiculoService modeloVeiculoService;

	private List<ModeloVeiculo> modelos;
	private ModeloVeiculo modeloVeiculoSelecionado;

	@PostConstruct
	public void init() {
		this.modelos = this.modeloVeiculoService.buscarTodos();
	}

	public void excluir() {
		try {
			this.modeloVeiculoService.remover(modeloVeiculoSelecionado);
			this.modelos.remove(modeloVeiculoSelecionado);

			FacesUtil.addSuccessMessage("Modelo veículo excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public ModeloVeiculo getModeloVeiculoSelecionado() {
		return modeloVeiculoSelecionado;
	}

	public void setModeloVeiculoSelecionado(ModeloVeiculo ModeloVeiculoSelecionado) {
		this.modeloVeiculoSelecionado = ModeloVeiculoSelecionado;
	}

	public List<ModeloVeiculo> getModelos() {
		return modelos;
	}

}
