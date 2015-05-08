package br.upis.sel.view.mb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.upis.sel.controller.facade.SELFacade;
import br.upis.sel.enums.PerfilDescricao;
import br.upis.sel.model.entity.Participante;
import br.upis.sel.model.entity.Perfil;

@Component
@Scope("view")
//@ManagedBean
public class ManterParticipanteMB extends AbstractMB {
	
	private String pesquisaNome;
	private String pesquisaCPF;
	
	@Autowired
	private SELFacade facade;
	
	@Autowired
	private Participante participante;
	
	private List<Participante> listaAdministradores = null;
	private List<Participante> listaComitentes = null;
	private List<Participante> listaLeiloeiros = null;
	private List<Participante> listaArrematantes = null;

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public String getPesquisaCPF() {
		return pesquisaCPF;
	}

	public void setPesquisaCPF(String pesquisaCPF) {
		this.pesquisaCPF = pesquisaCPF;
	}
	
	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Perfil getPerfilAdministrador() {
		return this.facade.recuperarPerfilPorDescricao(PerfilDescricao.ROLE_ADMINISTRADOR);
	}
	
	public Perfil getPerfilLeiloeiro() {
		return this.facade.recuperarPerfilPorDescricao(PerfilDescricao.ROLE_LEILOEIRO);
	}
	
	public Perfil getPerfilArrematante() {
		return this.facade.recuperarPerfilPorDescricao(PerfilDescricao.ROLE_ARREMATANTE);
	}
	
	public Perfil getPerfilComitente() {
		return this.facade.recuperarPerfilPorDescricao(PerfilDescricao.ROLE_COMITENTE);
	}

	public List<Participante> getListaAdministradores() {
		if (listaAdministradores == null) {
			listaAdministradores = this.facade.recuperarParticipantesPorPerfil(getPerfilAdministrador());
		}
		return listaAdministradores;
	}

	public void setListaAdministradores(List<Participante> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	public List<Participante> getListaComitentes() {
		if (listaComitentes == null) {
			listaComitentes = this.facade.recuperarParticipantesPorPerfil(getPerfilComitente());
		}
		return listaComitentes;
	}

	public void setListaComitentes(List<Participante> listaComitentes) {
		this.listaComitentes = listaComitentes;
	}

	public List<Participante> getListaLeiloeiros() {
		if (listaLeiloeiros == null) {
			listaLeiloeiros = this.facade.recuperarParticipantesPorPerfil(getPerfilLeiloeiro());
		}
		return listaLeiloeiros;
	}

	public void setListaLeiloeiros(List<Participante> listaLeiloeiros) {
		this.listaLeiloeiros = listaLeiloeiros;
	}

	public List<Participante> getListaArrematantes() {
		if (listaArrematantes == null) {
		listaArrematantes = this.facade.recuperarParticipantesPorPerfil(getPerfilArrematante());
		}
		return listaArrematantes;
	}

	public void setListaArrematantes(List<Participante> listaArrematantes) {
		this.listaArrematantes = listaArrematantes;
	}
	
}
