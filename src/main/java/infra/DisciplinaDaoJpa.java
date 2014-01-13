package infra;

import java.util.List;

import dominio.Disciplina;

public class DisciplinaDaoJpa extends GenericDaoJpa<Disciplina> implements DisciplinaDao {

	@Override
	public List<Disciplina> obterDisciplinasPorCurso(long cursoId) {
		String consulta = "SELECT a from Disciplina a WHERE a.curso.cursoId = ?";
		Object array[] = { cursoId };
		return super.obterEntidades(consulta, array);
	}
	
	@Override
	public Disciplina obterDisciplinaPorId(long disciplinaId) {
		String consulta = "SELECT a from Disciplina a WHERE a.disciplinaId = ?";
		Object array[] = { disciplinaId };
		return super.obterEntidade(consulta, array);
	}
}
