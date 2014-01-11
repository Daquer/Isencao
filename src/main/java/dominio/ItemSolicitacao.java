package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemSolicitacao {

	@Id
	@GeneratedValue
	private long itemSolicitacaoId;
	
	@ManyToOne
	@JoinColumn(name="solicitacaoId",nullable=false)
	private Solicitacao solicitacao;
	
	@ManyToOne
	@JoinColumn(name="disciplinaId",nullable=false)
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name="disciplinaExtId",nullable=false)
	private DisciplinaExterna disciplinaExterna;

	public long getItemSolicitacaoId() {
		return itemSolicitacaoId;
	}

	public void setItemSolicitacaoId(long itemSolicitacaoId) {
		this.itemSolicitacaoId = itemSolicitacaoId;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public DisciplinaExterna getDisciplinaExterna() {
		return disciplinaExterna;
	}

	public void setDisciplinaExterna(DisciplinaExterna disciplinaExterna) {
		this.disciplinaExterna = disciplinaExterna;
	}
}
