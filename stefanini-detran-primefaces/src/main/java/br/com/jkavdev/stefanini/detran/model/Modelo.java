package br.com.jkavdev.stefanini.detran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "modelos_veiculos")
public class Modelo extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "descricao_modelo", length = 50, nullable = false)
	private String descricao;
	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
