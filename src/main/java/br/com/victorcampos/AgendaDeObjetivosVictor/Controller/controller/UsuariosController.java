package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class UsuariosController {
	
	private List<Usuario> usuarios;
	
	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}
	
	@GetMapping("/usuarios/idade/{idadeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idade){
		
		List<Usuario> usuariosPorIdade = new ArrayList<Usuario>();
		
		for(Usuario u: usuarios) {
			//if(u.getIdade().equals(idade)) {
				//usuariosPorIdade.add(u);
			//}
		}
		
		if(usuariosPorIdade.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuariosPorIdade);
	}
	
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome){
		
		List<Usuario> usuariosPorNome = new ArrayList<Usuario>();
		
		for(Usuario u: usuarios) {
			//if(u.().equals(nome)) {
				//usuariosPorNome.add(u);
			//}
		}
		
		if(usuariosPorNome.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuariosPorNome);
	}
	
	private List<Usuario> obterTodosUsuarios(){
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		//usuarios.add(new Usuario("Rodrigo", 39));
		//usuarios.add(new Usuario("Rodrigo", 30));
		//usuarios.add(new Usuario("Michele", 39));
		
		return usuarios;
		
		/*return Arrays.asList(
				new Usuario("Rodrigo", 39),
				new Usuario("Rodrigo", 30),
				new Usuario("Michele", 39)
				);*/
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		
		this.usuarios.add(usuario);
		
		return ResponseEntity.ok(usuario);
		
	}

}
