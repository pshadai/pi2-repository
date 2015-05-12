package br.upis.sel.controller;

import java.util.List;

import br.upis.sel.enums.ParticipanteStatus;
import br.upis.sel.model.entity.Participante;
import br.upis.sel.model.entity.Perfil;

public interface ManterParticipanteBO {
	
	List<Participante> buscarPorPerfil(Perfil... perfil);
	
	List<Participante> buscarTodosParticipantes();
	
	Participante buscarPorId(Long id);
	
	void incluirParticipante(Participante p);
	
	void alterarParticipante(Participante p, ParticipanteStatus ps);
}
