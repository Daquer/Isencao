package infra;

import java.util.List;

import dominio.Disciplina;

public interface DisciplinaDao {
	
	public abstract List<Disciplina> obterDisciplinasPorCurso(long cursoId);
	
	public abstract Disciplina obterDisciplinaPorId(long disciplinaId);
}
