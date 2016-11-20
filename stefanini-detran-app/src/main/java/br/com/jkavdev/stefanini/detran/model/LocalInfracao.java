package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "locais_infracoes")
public class LocalInfracao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String descricaoLocal;
	private Double velocidadePermitida;
	private Double longitude;
	private Double latitude;

	@NotBlank(message = "Campo obrigatório!")
	@Column(name = "descricao_local", length = 100, nullable = false)
	public String getDescricaoLocal() {
		return descricaoLocal;
	}

	public void setDescricaoLocal(String descricaoLocal) {
		this.descricaoLocal = descricaoLocal;
	}

	@NotNull(message = "Campo obrigatório!")
	@Column(name = "velocidade_permitida", nullable = false)
	public Double getVelocidadePermitida() {
		return velocidadePermitida;
	}

	public void setVelocidadePermitida(Double velocidadePermitida) {
		this.velocidadePermitida = velocidadePermitida;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}
