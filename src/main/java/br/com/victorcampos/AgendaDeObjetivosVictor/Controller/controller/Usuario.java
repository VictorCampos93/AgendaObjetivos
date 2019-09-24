package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private Credenciais credenciais;
	
	private String nome;
	private Integer idade;

//	public Usuario(Integer id, Credenciais credenciais) {
//		this.id = id;
//		this.credenciais = credenciais;
//	}
	
	public Usuario() {}
	
	public Usuario(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	
	public String getNome() { return nome; }

	public Integer getIdade() { return idade; }

}
