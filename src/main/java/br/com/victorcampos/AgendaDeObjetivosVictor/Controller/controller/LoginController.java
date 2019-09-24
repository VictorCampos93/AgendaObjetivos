package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.domain.TodosUsuarios;

@RestController
public class LoginController {
	
	private TodosUsuarios todosUsuarios;
	
	//public LoginController() { }
	
	@Autowired
	public LoginController(TodosUsuarios tu) {
		
		this.todosUsuarios = tu;
		
	}

	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		// TODO Auto-generated method stub
		
		if(todosUsuarios.existe(credenciais) != null) {
		
			return ResponseEntity.ok("Sucesso");
		
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
		
	}
	
	
}
