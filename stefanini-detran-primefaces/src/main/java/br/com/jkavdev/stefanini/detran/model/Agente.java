package br.com.jkavdev.stefanini.detran.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "agentes")
public class Agente extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@Column(name = "data_contratacao")
	@Temporal(TemporalType.DATE)
	private Date dataContratacao;
	@Column(name = "tempo_servico")
	private Integer tempoServico;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Integer getTempoServico() {
		return tempoServico;
	}

	public void setTempoServico(Integer tempoServico) {
		this.tempoServico = tempoServico;
	}

}
