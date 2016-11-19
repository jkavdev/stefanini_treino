package br.com.jkavdev.stefanini.detran.bean.veiculo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.ModeloVeiculo;
import br.com.jkavdev.stefanini.detran.model.Veiculo;
import br.com.jkavdev.stefanini.detran.service.ModeloVeiculoService;
import br.com.jkavdev.stefanini.detran.service.VeiculoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroVeiculoBean {

	@Inject
	private VeiculoService veiculoService;
	@Inject
	private ModeloVeiculoService modeloVeiculoService;

	@Inject
	private Veiculo veiculo;
	private List<ModeloVeiculo> modelos;
	
	private Long modeloId;

	@PostConstruct
	public void init() {
		this.modelos = this.modeloVeiculoService.buscarTodos();
	}

	public void salvar() {
		try {
			this.veiculo.setModelo(this.cadastraModelo());
			this.veiculoService.salvar(veiculo);
			FacesUtil.addSuccessMessage("Veículo salvo com sucesso!");
			this.limparFormulario();
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void limparFormulario() {
		this.veiculo = new Veiculo();
	}
	
	private ModeloVeiculo cadastraModelo(){
		for (ModeloVeiculo modeloVeiculo : modelos) {
			if(modeloVeiculo.getId().equals(modeloId)){
				return modeloVeiculo;
			}
		}
		
		return null;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo Veiculo) {
		this.veiculo = Veiculo;
	}
	
	public List<ModeloVeiculo> getModelos() {
		return modelos;
	}

	public Long getModeloId() {
		return modeloId;
	}

	public void setModeloId(Long modeloId) {
		this.modeloId = modeloId;
	}

}
