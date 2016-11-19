package br.com.jkavdev.stefanini.detran.model;

public enum TipoTelefone {

	RESIDENCIAL("Residencial"), 
	COMERCIAL("Comercial"), 
	CELULAR("Celular");

	private String descricao;

	private TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
