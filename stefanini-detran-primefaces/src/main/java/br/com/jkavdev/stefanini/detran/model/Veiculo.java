package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "placa", length = 7, nullable = false)
	private String placa;
	@ManyToOne
	@JoinColumn(name = "modelo_id", nullable = false)
	private Modelo modelo;
	@ManyToOne
	@JoinColumn(name = "estado_id", nullable = false)
	private Estado estado;
	@ManyToOne
	@JoinColumn(name = "proprietario_id", nullable = false)
	private Proprietario proprietario;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}
