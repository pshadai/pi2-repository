package br.upis.sel.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.upis.sel.model.entity.Participante;
import br.upis.sel.model.entity.Perfil;


public interface ParticipanteDAO extends CrudRepository<Participante, Long> {
	
	Participante findByUsernameAndPassword(String nome, String password);

	Participante findByUsername(String nome);
	
	@Query(value = "SELECT p FROM Participante p INNER JOIN p.perfis e WHERE e IN (:perfis)")
	List<Participante> findByPerfis(@Param("perfis") List<Perfil> perfis);
}
