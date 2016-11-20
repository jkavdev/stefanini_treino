package br.com.jkavdev.stefanini.detran.bean.infracao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.stefanini.detran.model.Agente;
import br.com.jkavdev.stefanini.detran.model.Infracao;
import br.com.jkavdev.stefanini.detran.model.LocalInfracao;
import br.com.jkavdev.stefanini.detran.model.TipoInfracao;
import br.com.jkavdev.stefanini.detran.model.Veiculo;
import br.com.jkavdev.stefanini.detran.service.AgenteService;
import br.com.jkavdev.stefanini.detran.service.InfracaoService;
import br.com.jkavdev.stefanini.detran.service.LocalInfracaoService;
import br.com.jkavdev.stefanini.detran.service.TipoInfracaoService;
import br.com.jkavdev.stefanini.detran.service.VeiculoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private InfracaoService infracaoService;
	@Inject
	private AgenteService agenteService;
	@Inject
	private LocalInfracaoService localInfracaoService;
	@Inject
	private TipoInfracaoService tipoInfracaoService;
	@Inject
	private VeiculoService veiculoService;

	private List<Agente> agentes;
	private List<LocalInfracao> locais;
	private List<TipoInfracao> tipos;
	private List<Veiculo> veiculos;

	@Inject
	private Infracao infracao;

	private Long agenteId;
	private Long localId;
	private Long tipoId;
	private Long veiculoId;

	@PostConstruct
	public void init() {
		agentes = agenteService.buscarTodos();
		locais = localInfracaoService.buscarTodos();
		tipos = tipoInfracaoService.buscarTodos();
		veiculos = veiculoService.buscarTodos();
	}

	public void salvar() {
		try {
			infracao.setAgente(cadastrarAgente());
			infracao.setLocalInfracao(cadastrarLocal());
			infracao.setTipoInfracao(cadastrarTipo());
			infracao.setVeiculo(cadastrarVeiculo());

			infracaoService.salvar(infracao);
			FacesUtil.addSuccessMessage("Infração salva com sucesso!");

			limpaFormulario();
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void limpaFormulario() {
		infracao = new Infracao();
		agenteId = null;
		localId = null;
		tipoId = null;
		veiculoId = null;
	}

	public Agente cadastrarAgente() {
		for (Agente agente : agentes) {
			if (agente.getId().equals(agenteId)) {
				return agente;
			}
		}

		return null;
	}

	public LocalInfracao cadastrarLocal() {
		for (LocalInfracao local : locais) {
			if (local.getId().equals(localId)) {
				return local;
			}
		}

		return null;
	}

	public TipoInfracao cadastrarTipo() {
		for (TipoInfracao tipo : tipos) {
			if (tipo.getId().equals(tipoId)) {
				return tipo;
			}
		}

		return null;
	}

	public Veiculo cadastrarVeiculo() {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getId().equals(veiculoId)) {
				return veiculo;
			}
		}

		return null;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	public Long getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(Long agenteId) {
		this.agenteId = agenteId;
	}

	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public Long getTipoId() {
		return tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	public List<Agente> getAgentes() {
		return agentes;
	}

	public List<LocalInfracao> getLocais() {
		return locais;
	}

	public List<TipoInfracao> getTipos() {
		return tipos;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

}
