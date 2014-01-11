package service;

import javax.persistence.NoResultException;

import dominio.Aluno;
import dominio.AlunoRepo;


public class IsencaoService {
	
	private AlunoRepo alunoRepo = new AlunoRepo();
	
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
}
