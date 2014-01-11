package dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DisciplinaExterna {
	
	@Id
	@GeneratedValue
	private long discplinaExtId;
	
	private String nome;
	
	private String codigo;
	
	private int periodo;
		
	private String curso;
	
	@OneToMany(targetEntity=ItemSolicitacao.class,mappedBy="disciplinaExterna")
	private List<ItemSolicitacao> itensSolicitacao;

	public long getDiscplinaId() {
		return discplinaExtId;
	}

	public void setDiscplinaId(long discplinaExtId) {
		this.discplinaExtId = discplinaExtId;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<ItemSolicitacao> getItensSolicitacao() {
		return itensSolicitacao;
	}

	public void setItensSolicitacao(List<ItemSolicitacao> itensSolicitacao) {
		this.itensSolicitacao = itensSolicitacao;
	}
}
