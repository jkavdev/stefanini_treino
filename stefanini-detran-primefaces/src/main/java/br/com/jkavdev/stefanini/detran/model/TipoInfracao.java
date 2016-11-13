package br.com.jkavdev.stefanini.detran.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_infracoes")
public class TipoInfracao extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "descricao_infracao", length = 50, nullable = false)
	private String descricao;
	@Column(name = "valor_infracao", nullable = false)
	private BigDecimal valorInfracao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorInfracao() {
		return valorInfracao;
	}

	public void setValorInfracao(BigDecimal valorInfracao) {
		this.valorInfracao = valorInfracao;
	}

}
