package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telefone extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String numero;
	private String ddd;
	private Proprietario proprietario;
	private TipoTelefone tipo;

	@Column(name = "numero", length = 15, nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "ddd", length = 5, nullable = false)
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Column(name = "tipo_telefone", length = 20)
	@Enumerated(EnumType.STRING)
	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

}
