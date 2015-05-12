package br.upis.sel.controller.facade;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.upis.sel.controller.ManterParticipanteBO;
import br.upis.sel.controller.PerfilBO;
import br.upis.sel.controller.bo.RealizarLoginBO;
import br.upis.sel.enums.ParticipanteStatus;
import br.upis.sel.enums.PerfilDescricao;
import br.upis.sel.model.entity.Participante;
import br.upis.sel.model.entity.Perfil;

@Service
@Transactional
public class SELFacade implements Serializable {
	
	private static final long serialVersionUID = -6701772516498933248L;

	@Autowired
	private RealizarLoginBO loginBO;
	
	@Autowired
	private PerfilBO perfilBO;
	
	@Autowired
	private ManterParticipanteBO manterParticipanteBO;
	
	public Participante realizarLogin(String cpf, String password) {
		return this.loginBO.login(cpf, password);
	}
	
	public Perfil recuperarPerfilPorDescricao(PerfilDescricao descricao) {
		return this.perfilBO.obterPorDescricao(descricao);
	}
	
	public List<Participante> recuperarParticipantesPorPerfil(Perfil perfil) {
		return this.manterParticipanteBO.buscarPorPerfil(perfil);
	}
	
	public List<Participante> recuperarTodosParticipantes() {
		return this.manterParticipanteBO.buscarTodosParticipantes();
	}
	
	public List<Perfil> recuperarTodosPerfis() {
		return this.perfilBO.buscarTodosPerfis();
	}
	
	public Participante recuperarParticipantePorId(Long id) {
		return this.manterParticipanteBO.buscarPorId(id);
	}
	
	public void incluirParticipante(Participante p) {
		this.manterParticipanteBO.incluirParticipante(p);
	}
	
	public void alterarParticipante(Participante p, ParticipanteStatus ps) {
		this.manterParticipanteBO.alterarParticipante(p, ps);
	}
}
