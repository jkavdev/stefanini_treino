package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "locais_infracoes")
public class LocalInfracao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String descricaoLocal;
	private Double velocidadePermitida;

	@Column(name = "descricao_local", length = 100, nullable = false)
	public String getDescricaoLocal() {
		return descricaoLocal;
	}

	public void setDescricaoLocal(String descricaoLocal) {
		this.descricaoLocal = descricaoLocal;
	}

	@Column(name = "velocidade_permitida", nullable = false)
	public Double getVelocidadePermitida() {
		return velocidadePermitida;
	}

	public void setVelocidadePermitida(Double velocidadePermitida) {
		this.velocidadePermitida = velocidadePermitida;
	}

}
