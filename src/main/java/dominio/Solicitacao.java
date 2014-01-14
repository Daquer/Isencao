package dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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
	
	private String situacao;
	
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
}
