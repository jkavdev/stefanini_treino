package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Localinfracao.findAll", query = "SELECT l FROM Localinfracao l")
public class Localinfracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLocalInfracao;

	private String descricaoLocalInfracao;

	private double velocidadePermitida;

	public Localinfracao() {
	}

	public int getIdLocalInfracao() {
		return this.idLocalInfracao;
	}

	public void setIdLocalInfracao(int idLocalInfracao) {
		this.idLocalInfracao = idLocalInfracao;
	}

	public String getDescricaoLocalInfracao() {
		return this.descricaoLocalInfracao;
	}

	public void setDescricaoLocalInfracao(String descricaoLocalInfracao) {
		this.descricaoLocalInfracao = descricaoLocalInfracao;
	}

	public double getVelocidadePermitida() {
		return this.velocidadePermitida;
	}

	public void setVelocidadePermitida(double velocidadePermitida) {
		this.velocidadePermitida = velocidadePermitida;
	}

}