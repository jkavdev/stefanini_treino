package br.com.jkavdev.stefanini.detran.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_infracoes")
public class TipoInfracao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String descricao;
	private String amparoLegal;
	private Integer pontos;
	private BigDecimal valorInfracao;

	@Column(name = "descricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "valor", nullable = false, precision = 7, scale = 2)
	public BigDecimal getValorInfracao() {
		return valorInfracao;
	}

	public void setValorInfracao(BigDecimal valorInfracao) {
		this.valorInfracao = valorInfracao;
	}

	@Column(name = "codigo", length = 25, nullable = false, unique = true)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "amparo_legal", length = 25)
	public String getAmparoLegal() {
		return amparoLegal;
	}

	public void setAmparoLegal(String amparoLegal) {
		this.amparoLegal = amparoLegal;
	}

	@Column(name = "pontos", nullable = false)
	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

}
