package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.domain.Objetivo;
import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.domain.TodosObjetivos;

@RestController
public class ObjetivoController {
	
	private TodosObjetivos todosObj;
	
	@Autowired
	public void ObjetivosController(TodosObjetivos to) {
		
		this.todosObj = to;
		
	}

	@PostMapping("/objetivos")
	public ResponseEntity<String> cadastrarObjetivo(@RequestBody Objetivo objetivo) {
		// TODO Auto-generated method stub
		
		todosObj.save(objetivo);
				
		return ResponseEntity.ok("Sucesso");
				
	}
	
	@GetMapping("/objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> listarObjetivos(@PathVariable("data") String date) {
		// TODO Auto-generated method stubW
		
		List<Objetivo> objetivosLista = todosObj.ate(LocalDate.parse(date));
		
		if(objetivosLista.isEmpty()) {
			
			return ResponseEntity.noContent().build();
			
		}
		
		return ResponseEntity.ok(objetivosLista);
		
				
		//return ResponseEntity.ok("Sucesso");
				
	}
	
}
