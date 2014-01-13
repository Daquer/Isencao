package service;

import java.util.List;

import javax.persistence.NoResultException;

import dominio.Aluno;
import dominio.AlunoRepo;
import dominio.Disciplina;
import dominio.DisciplinaRepo;
import dominio.Solicitacao;
import dominio.SolicitacaoRepo;


public class IsencaoService {
	
	private AlunoRepo alunoRepo = new AlunoRepo();
	private DisciplinaRepo disciplinaRepo = new DisciplinaRepo();
	private SolicitacaoRepo solicitacaoRepo = new SolicitacaoRepo();
	
	public boolean autenticaAluno(String matricula, String password){
		try {
			Aluno aluno = alunoRepo.obterAlunoPorMatricula(matricula);
			if(aluno.getSenha().equals(password))
				return true;
			else
				return false;
		} catch(NoResultException e) {
			return false;
		}
	}

	public Aluno obterAlunoPorMatricula(String matricula){
		
		try {
			return alunoRepo.obterAlunoPorMatricula(matricula);
		} catch(NoResultException e) {
			return null;
		}
	}
	
	public List<Disciplina> obterDisciplinasPorCurso(long cursoId){
		try {
			return disciplinaRepo.obterDisciplinasPorCurso(cursoId);
		} catch(NoResultException e) {
			return null;
		}
	}
	
	public Disciplina obterDisciplinaPorId(long disciplinaId) {
		try {
			return disciplinaRepo.obterDisciplinaPorId(disciplinaId);
		} catch(NoResultException e) {
			return null;
		}
	}
	
	public void adicionarSolicitacao(Solicitacao solicitacao) {
			solicitacaoRepo.adicionarSolicitacao(solicitacao);
	}
}
