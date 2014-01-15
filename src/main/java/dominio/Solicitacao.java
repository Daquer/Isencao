package dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Solicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long solicitacaoId;
	
	private Date dataRealizacao;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@ManyToOne
	@JoinColumn(name="alunoId",nullable=false)
	private Aluno aluno;
	
	@OneToMany(targetEntity=ItemSolicitacao.class,mappedBy="solicitacao")
	private List<ItemSolicitacao> itensSolicitacao;

	public long getSolicitacaoId() {
		return solicitacaoId;
	}

	public void setSolicitacaoId(long solicitacaoId) {
		this.solicitacaoId = solicitacaoId;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<ItemSolicitacao> getItensSolicitacao() {
		return itensSolicitacao;
	}

	public void setItensSolicitacao(List<ItemSolicitacao> itensSolicitacao) {
		this.itensSolicitacao = itensSolicitacao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
}
