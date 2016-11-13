package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "infracoes")
public class Infracao extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "agente_id", nullable = false)
	private Agente agente;
	@ManyToOne
	@JoinColumn(name = "local_infracao_id", nullable = false)
	private LocalInfracao localInfracao;
	@ManyToOne
	@JoinColumn(name = "tipo_infracao_id", nullable = false)
	private TipoInfracao tipoInfracao;
	@ManyToOne
	@JoinColumn(name = "veiculo_id", nullable = false)
	private Veiculo veiculo;
	@Column(name = "velocidade", nullable = false)
	private Double velocidade;

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public LocalInfracao getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(LocalInfracao localInfracao) {
		this.localInfracao = localInfracao;
	}

	public TipoInfracao getTipoInfracao() {
		return tipoInfracao;
	}

	public void setTipoInfracao(TipoInfracao tipoInfracao) {
		this.tipoInfracao = tipoInfracao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}

}
