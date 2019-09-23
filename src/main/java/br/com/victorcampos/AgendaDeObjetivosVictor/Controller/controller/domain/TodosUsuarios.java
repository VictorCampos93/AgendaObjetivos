package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.Usuario;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {
	
	//Estamos procurando em objetos, nao em tabelas
	@Query("select o from Usuario o where o.login = :login AND o.senha = :senha")
	public Usuario existe(@Param("login") String login, @Param("senha") String Senha);

}
