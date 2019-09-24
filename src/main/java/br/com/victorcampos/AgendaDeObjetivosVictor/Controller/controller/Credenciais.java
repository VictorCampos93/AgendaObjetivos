package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller;

import javax.persistence.Embeddable;

@Embeddable
public class Credenciais {
	
	private String login;
	
	private String senha;
	
	public Credenciais() {}

	public Credenciais(String login, String senha) {
		// TODO Auto-generated constructor stub
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		// TODO Auto-generated method stub
		return login;
	}

	public String getSenha() {
		// TODO Auto-generated method stub
		return senha;
	}

}
