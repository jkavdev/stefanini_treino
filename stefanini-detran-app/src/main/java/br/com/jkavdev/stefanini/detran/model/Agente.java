package br.com.jkavdev.stefanini.detran.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "agentes")
public class Agente extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Date dataContratacao;
	private Integer tempoServico;

	@NotBlank(message = "Campo obrigatório")
	@Column(name = "nome", length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "Campo obrigatório")
	@Column(name = "data_contratacao")
	@Temporal(TemporalType.DATE)
	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	@NotNull(message = "Campo obrigatório")
	@Column(name = "tempo_servico")
	public Integer getTempoServico() {
		return tempoServico;
	}

	public void setTempoServico(Integer tempoServico) {
		this.tempoServico = tempoServico;
	}

}
