package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="objetivos") //sem o @table o JPA funciona, mas sem o nome objetivos
public class Objetivo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonProperty
	private String titulo;
	
	@JsonProperty
	private String descricao;
	
	@Embedded
	@JsonProperty
	private Prioridades prioridade;
	
	@Column(name = "data_maxima_para_execucao")
	@JsonProperty
	private LocalDate dataMaximaParaExecucao;
	
	public Objetivo() {}
	
	public Objetivo(String titulo, String descricao, LocalDate dataMaximaParaExecucao, Prioridades prioridade) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
				+ dataMaximaParaExecucao + "]";
	}

	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}

	/*
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataMaximaParaExecucao() {
		return dataMaximaParaExecucao;
	}*/
}
