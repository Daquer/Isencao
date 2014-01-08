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
	
	private String nomeDiscExterna;
	
	private String codDiscExterna;
	
	@ManyToOne
	@JoinColumn(name="solicitacaoId",nullable=false)
	private Solicitacao solicitacao;
	
	@ManyToOne
	@JoinColumn(name="disciplinaId",nullable=false)
	private Disciplina disciplina;

	public long getItemSolicitacaoId() {
		return itemSolicitacaoId;
	}

	public void setItemSolicitacaoId(long itemSolicitacaoId) {
		this.itemSolicitacaoId = itemSolicitacaoId;
	}

	public String getNomeDiscExterna() {
		return nomeDiscExterna;
	}

	public void setNomeDiscExterna(String nomeDiscExterna) {
		this.nomeDiscExterna = nomeDiscExterna;
	}

	public String getCodDiscExterna() {
		return codDiscExterna;
	}

	public void setCodDiscExterna(String codDiscExterna) {
		this.codDiscExterna = codDiscExterna;
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
}
