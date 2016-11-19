package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "infracoes")
public class Infracao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Agente agente;
	private LocalInfracao localInfracao;
	private TipoInfracao tipoInfracao;
	private Veiculo veiculo;
	private Double velocidade;

	@ManyToOne
	@JoinColumn(name = "agente_id", nullable = false)
	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	@ManyToOne
	@JoinColumn(name = "local_infracao_id", nullable = false)
	public LocalInfracao getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(LocalInfracao localInfracao) {
		this.localInfracao = localInfracao;
	}

	@ManyToOne
	@JoinColumn(name = "tipo_infracao_id", nullable = false)
	public TipoInfracao getTipoInfracao() {
		return tipoInfracao;
	}

	public void setTipoInfracao(TipoInfracao tipoInfracao) {
		this.tipoInfracao = tipoInfracao;
	}

	@ManyToOne
	@JoinColumn(name = "veiculo_id", nullable = false)
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Column(name = "velocidade", nullable = false)
	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}

}
