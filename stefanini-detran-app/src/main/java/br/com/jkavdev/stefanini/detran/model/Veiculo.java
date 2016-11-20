package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String placa;
	private ModeloVeiculo modelo;
	private String uf;
	private Proprietario proprietario;

	@Column(name = "placa", length = 9, nullable = false, unique = true)
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@ManyToOne
	@JoinColumn(name = "modelo_id", nullable = false)
	public ModeloVeiculo getModelo() {
		return modelo;
	}

	public void setModelo(ModeloVeiculo modelo) {
		this.modelo = modelo;
	}

	@Column(name = "uf", length = 10, nullable = false)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@ManyToOne
	@JoinColumn(name = "proprietario_id", nullable = false)
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}
