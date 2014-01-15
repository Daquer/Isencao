package dominio;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	private String nomeDisExterna;
	
	private String codDisExterna;
	
	@Enumerated(EnumType.STRING)
	private SituacaoItem situacaoItem;

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

	public String getNomeDisExterna() {
		return nomeDisExterna;
	}

	public void setNomeDisExterna(String nomeDisExterna) {
		this.nomeDisExterna = nomeDisExterna;
	}

	public String getCodDisExterna() {
		return codDisExterna;
	}

	public void setCodDisExterna(String codDisExterna) {
		this.codDisExterna = codDisExterna;
	}

	public SituacaoItem getSituacaoItem() {
		return situacaoItem;
	}

	public void setSituacaoItem(SituacaoItem situacaoItem) {
		this.situacaoItem = situacaoItem;
	}
}
