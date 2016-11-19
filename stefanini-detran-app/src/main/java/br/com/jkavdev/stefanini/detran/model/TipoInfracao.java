package br.com.jkavdev.stefanini.detran.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_infracoes")
public class TipoInfracao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private BigDecimal valorInfracao;

	@Column(name = "descricao_infracao", length = 50, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "valor_infracao", nullable = false)
	public BigDecimal getValorInfracao() {
		return valorInfracao;
	}

	public void setValorInfracao(BigDecimal valorInfracao) {
		this.valorInfracao = valorInfracao;
	}

}
