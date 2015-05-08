package br.upis.sel.controller.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.upis.sel.controller.ManterParticipanteBO;
import br.upis.sel.model.dao.ParticipanteDAO;
import br.upis.sel.model.entity.Participante;
import br.upis.sel.model.entity.Perfil;

@Service
@Transactional
public class ManterParticipanteBOImpl implements ManterParticipanteBO {
	
	@Autowired
	private ParticipanteDAO participanteDAO;

	/* (non-Javadoc)
	 * @see br.upis.sel.controller.ManterParticipanteBO#buscarPorPerfil(br.upis.sel.model.entity.Perfil)
	 */
	@Override
	public List<Participante> buscarPorPerfil(Perfil... perfil) {
		List<Perfil> perfilParam = new ArrayList<Perfil>();
		
		for (int i = 0; i < perfil.length; i++) {
			perfilParam.add(perfil[i]);
		}
		return this.participanteDAO.findByPerfis(perfilParam);
	}

}
