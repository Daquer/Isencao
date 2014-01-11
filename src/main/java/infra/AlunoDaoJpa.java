package infra;

import dominio.Aluno;

public class AlunoDaoJpa extends GenericDaoJpa<Aluno> implements AlunoDao {

	@Override
	public Aluno obterAlunoPorMatricula(String matricula) {
		String consulta = "SELECT a from Aluno a WHERE a.matricula = ?";
		Object array[] = { matricula };
		return super.obterEntidade(consulta, array);
	}
}
