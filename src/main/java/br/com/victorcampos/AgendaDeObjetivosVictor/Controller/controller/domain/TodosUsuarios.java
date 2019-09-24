package br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.Credenciais;
import br.com.victorcampos.AgendaDeObjetivosVictor.Controller.controller.Usuario;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {
	
	@Query("select o from Usuario o where o.credenciais = :credenciais")
	public Usuario existe(@Param("credenciais") Credenciais credenciais);

}
