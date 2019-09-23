package br.com.victorcampos.AgendaDeObjetivosVictor.Controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.Credenciais;
import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.LoginController;

public class LoginControllerTest {
	
	private LoginController controller;
	
	@Before
	public void setup() {
		
		LoginController controller = new LoginController();
		
	}
	
	@Test
	public void loginComSucesso() {
		
		LoginController controller = new LoginController();
		
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login","login"));
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode()); //Comparando Strings
		
		assertEquals("Sucesso", resposta.getBody());
	}
	
	@Test
	public void loginComFalha() {
		
		LoginController controller = new LoginController();
		
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login","senha"));
		
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode()); //Comparando Strings
		
		assertEquals("Erro", resposta.getBody());
		
	}
}
