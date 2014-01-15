package dominio;

import java.util.List;
import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {

	@Id
	@GeneratedValue
	private long cursoId;
	
	@Column(columnDefinition="TEXT")
	private String nome;
	
	@OneToMany(targetEntity=Aluno.class, 
			mappedBy="curso")	
	private List<Aluno> alunos;
	
	@OneToMany(targetEntity=Disciplina.class,
			mappedBy="curso")
	private List<Disciplina> disciplinas;

	public long getCursoId() {
		return cursoId;
	}

	public void setCursoId(long cursoId) {
		this.cursoId = cursoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}	
}