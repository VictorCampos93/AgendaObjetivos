package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller;

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
	private Integer id;
	
	@JsonProperty
	private String login;
	
	@JsonProperty
	private String senha;

	public Usuario(Integer id, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	
	


}
