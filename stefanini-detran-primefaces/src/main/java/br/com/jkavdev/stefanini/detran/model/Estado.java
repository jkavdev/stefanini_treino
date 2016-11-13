package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 10, nullable = false)
	private String uf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
