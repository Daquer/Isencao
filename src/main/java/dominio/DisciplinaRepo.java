package dominio;

import java.util.List;

import infra.DisciplinaDao;
import infra.DisciplinaDaoJpa;

public class DisciplinaRepo {
	private DisciplinaDao dao = new DisciplinaDaoJpa();
	
	public List<Disciplina> obterDisciplinasPorCurso(long cursoId) {
		return dao.obterDisciplinasPorCurso(cursoId);
	}
	
	public Disciplina obterDisciplinaPorId(long disciplinaId) {
		return dao.obterDisciplinaPorId(disciplinaId);
	}
}
