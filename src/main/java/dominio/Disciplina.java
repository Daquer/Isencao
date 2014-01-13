package dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue
	private long disciplinaId;
	
	private String nome;
	
	private String codigo;
	
	private int periodo;
		
	@ManyToOne
	@JoinColumn(name="cursoId",nullable=false)
	private Curso curso;
	
	@OneToMany(targetEntity=ItemSolicitacao.class,mappedBy="disciplina")
	private List<ItemSolicitacao> itensSolicitacao;

	public long getDiscplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(long disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
