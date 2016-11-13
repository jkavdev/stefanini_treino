package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telefone extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "numero", length = 15, unique = true, nullable = false, updatable = false)
	private String numero;
	@Column(name = "ddd", length = 5, unique = true, nullable = false, updatable = false)
	private String ddd;
	@ManyToOne
	@JoinColumn(name = "proprietario_id", nullable = false, unique = true, updatable = false)
	private Proprietario proprietario;
	@Column(name = "tipo_telefone", length = 20)
	private TipoTelefone tipo;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

}
