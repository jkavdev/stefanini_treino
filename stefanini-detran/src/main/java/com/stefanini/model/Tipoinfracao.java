package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tipoinfracao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int idTipoInfracao;
	private String descricaoTipoInfracao;
	private double valor;

	public Tipoinfracao() {
	}

	public int getIdTipoInfracao() {
		return this.idTipoInfracao;
	}

	public void setIdTipoInfracao(int idTipoInfracao) {
		this.idTipoInfracao = idTipoInfracao;
	}

	public String getDescricaoTipoInfracao() {
		return this.descricaoTipoInfracao;
	}

	public void setDescricaoTipoInfracao(String descricaoTipoInfracao) {
		this.descricaoTipoInfracao = descricaoTipoInfracao;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}