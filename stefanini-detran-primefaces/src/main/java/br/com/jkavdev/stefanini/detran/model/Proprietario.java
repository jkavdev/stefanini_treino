package br.com.jkavdev.stefanini.detran.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "proprietarios")
public class Proprietario extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@Embedded
	private Endereco endereco;
	@Column(name = "sexo", length = 15, nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Column(name = "data_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
