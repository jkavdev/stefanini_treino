package br.com.jkavdev.stefanini.detran.bean.veiculo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.ModeloVeiculo;
import br.com.jkavdev.stefanini.detran.model.Proprietario;
import br.com.jkavdev.stefanini.detran.model.Veiculo;
import br.com.jkavdev.stefanini.detran.service.ModeloVeiculoService;
import br.com.jkavdev.stefanini.detran.service.ProprietarioService;
import br.com.jkavdev.stefanini.detran.service.VeiculoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroVeiculoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private VeiculoService veiculoService;
	@Inject
	private ModeloVeiculoService modeloVeiculoService;
	@Inject
	private ProprietarioService proprietarioService;

	@Inject
	private Veiculo veiculo;
	private List<ModeloVeiculo> modelos;
	private List<Proprietario> proprietarios;

	private Long modeloId;
	private Long proprietarioId;

	@PostConstruct
	public void init() {
		this.modelos = this.modeloVeiculoService.buscarTodos();
		this.proprietarios = this.proprietarioService.buscarTodos();
	}

	public void salvar() {
		try {
			this.veiculo.setModelo(this.cadastraModelo());
			this.veiculo.setProprietario(this.cadastraProprietario());
			
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

	private ModeloVeiculo cadastraModelo() {
		for (ModeloVeiculo modeloVeiculo : modelos) {
			if (modeloVeiculo.getId().equals(modeloId)) {
				return modeloVeiculo;
			}
		}

		return null;
	}
	
	private Proprietario cadastraProprietario() {
		for (Proprietario proprietario : proprietarios) {
			if (proprietario.getId().equals(proprietarioId)) {
				return proprietario;
				
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

	public List<Proprietario> getProprietarios() {
		return proprietarios;
	}

	public Long getModeloId() {
		return modeloId;
	}

	public void setModeloId(Long modeloId) {
		this.modeloId = modeloId;
	}

	public Long getProprietarioId() {
		return proprietarioId;
	}

	public void setProprietarioId(Long proprietarioId) {
		this.proprietarioId = proprietarioId;
	}

}
