package br.upis.sel.controller;

import java.util.List;

import br.upis.sel.model.entity.Participante;
import br.upis.sel.model.entity.Perfil;

public interface ManterParticipanteBO {
	
	List<Participante> buscarPorPerfil(Perfil... perfil);
}
