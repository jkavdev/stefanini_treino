package br.com.jkavdev.stefanini.detran.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "proprietarios")
public class Proprietario extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Endereco endereco;
	private Sexo sexo;
	private Date dataNascimento;
	private List<Telefone> telefones;

	@Column(name = "nome", length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Column(name = "sexo", length = 15, nullable = false)
	@Enumerated(EnumType.STRING)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Column(name = "data_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public void adicionarTelefone(Telefone telefone) {
		if (telefones == null) {
			telefones = new ArrayList<Telefone>();
		}

		this.telefones.add(telefone);
		telefone.setProprietario(this);
	}

}
