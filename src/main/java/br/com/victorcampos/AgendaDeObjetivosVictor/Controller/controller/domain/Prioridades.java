package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Prioridades {
	
	private String nome;
	private String observacoes;
	
	protected Prioridades() {}

	public Prioridades(String nome, String observacoes) {
		super();
		this.nome = nome;
		this.observacoes = observacoes;
	}

	public String getNome() {
		return nome;
	}

	public String getObservacoes() {
		return observacoes;
	}

}
