package br.upis.sel.view.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.upis.sel.enums.ParticipanteStatus;
import br.upis.sel.model.entity.Participante;
import br.upis.sel.model.entity.Perfil;

@Component
@Scope("view")
@ManagedBean
public class ManterParticipanteMB extends AbstractMB {
	
	private static final long serialVersionUID = 7859756109388467543L;
	
	private String pesquisaNome;
	private String pesquisaCPF;
	
//	@Autowired
	private Participante participante;
	
	private List<Perfil> perfis = null;
	private List<Participante> listaParticipantes = null;
	private Perfil[] perfisSelecionados;
	
	
	public ManterParticipanteMB() {
		this.participante = new Participante();
	}

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

	public List<Perfil> getPerfis() {
		if (perfis == null) {
			perfis = this.facade.recuperarTodosPerfis();
		}
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<Participante> getListaParticipantes() {
		if (listaParticipantes == null) {
			listaParticipantes = this.facade.recuperarTodosParticipantes();
		}
		return listaParticipantes;
	}

	public void setListaParticipantes(List<Participante> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}

	public Perfil[] getPerfisSelecionados() {
		return perfisSelecionados;
	}

	public void setPerfisSelecionados(Perfil[] perfisSelecionados) {
		this.perfisSelecionados = perfisSelecionados;
	}

	public void zerarParticipante() {
		System.out.println(participante.getNome());
		this.participante = new Participante();
	}
	
	public void salvarOuAlterarParticipante() {
		try {
			if (this.participante.getIdParticipante() == null) {
				this.facade.incluirParticipante(this.participante);
				this.getMessage("Participante adicionado com sucesso");
			} else {
				this.facade.alterarParticipante(this.participante, ParticipanteStatus.ATIVO);
				this.getMessage("Participante alterado com sucesso");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.getError("Erro ao adicionar ou alterar participante");
		}
	}
	
	@Override
	public void recuperarObjeto() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String param = request.getParameter("participanteId");
		Long participanteId = Long.parseLong(param);
		this.participante = this.facade.recuperarParticipantePorId(participanteId);
	}
}
