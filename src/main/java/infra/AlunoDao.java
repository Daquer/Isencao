package infra;

import dominio.Aluno;

public interface AlunoDao {

	public abstract Aluno obterAlunoPorMatricula(String username);
}
