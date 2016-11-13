package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "locais_infracoes")
public class LocalInfracao extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "descricao_local", length = 100, nullable = false)
	private String descricaoLocal;
	@Column(name = "velocidade_permitida", nullable = false)
	private Double velocidadePermitida;

	public String getDescricaoLocal() {
		return descricaoLocal;
	}

	public void setDescricaoLocal(String descricaoLocal) {
		this.descricaoLocal = descricaoLocal;
	}

	public Double getVelocidadePermitida() {
		return velocidadePermitida;
	}

	public void setVelocidadePermitida(Double velocidadePermitida) {
		this.velocidadePermitida = velocidadePermitida;
	}

}
