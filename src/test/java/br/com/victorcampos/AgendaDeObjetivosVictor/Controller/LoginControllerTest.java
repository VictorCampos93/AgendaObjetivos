package br.com.victorcampos.AgendaDeObjetivosVictor.Controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.Credenciais;
import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.LoginController;
import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.Usuario;
import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.domain.TodosUsuarios;

public class LoginControllerTest {
	
	private LoginController controller;
	
	private TodosUsuarios todosUsuarios;
	
	@Before
	public void setup() {
		
		todosUsuarios = Mockito.mock(TodosUsuarios.class);
		
		controller = new LoginController(todosUsuarios);
		
	}
	
	@Test
	public void loginComSucesso() {
		
		Credenciais c = new Credenciais("igual", "igual");
		
		Mockito.when(todosUsuarios.existe(c)).thenReturn(new Usuario("nome", 40));
		
		ResponseEntity<String> resposta = controller.validarLogin(c);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode()); //Comparando Strings
		
		assertEquals("Sucesso", resposta.getBody());
	}
	
	@Test
	public void loginComFalha() {
		
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login","senha"));
		
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode()); //Comparando Strings
		
		assertEquals("Erro", resposta.getBody());
		
	}
}
