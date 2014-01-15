package dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue
	private long alunoId;
	
	@Column(columnDefinition="TEXT")
	private String nome;
	
	@Column(columnDefinition="TEXT")
	private String matricula;
	
	@Column(columnDefinition="TEXT")
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="cursoId", nullable=false)
	private Curso curso;

	@OneToMany(targetEntity=Solicitacao.class,mappedBy="aluno")
	private List<Solicitacao> solicitacoes;

	public long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(long alunoId) {
		this.alunoId = alunoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
}