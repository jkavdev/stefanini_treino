package br.com.jkavdev.stefanini.detran.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "endereco", length = 100, nullable = false)
	private String endereco;
	@Column(name = "bairro", length = 100, nullable = false)
	private String bairro;
	@Column(name = "cidade", length = 100, nullable = false)
	private String cidade;
	@ManyToOne
	@JoinColumn(name = "estado_id", nullable = false)
	private Estado estado;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
