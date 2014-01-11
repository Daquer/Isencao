package dominio;

import infra.AlunoDao;
import infra.AlunoDaoJpa;

public class AlunoRepo {
	
	private AlunoDao dao = new AlunoDaoJpa();
	
	public Aluno obterAlunoPorMatricula(String matricula) {
		return dao.obterAlunoPorMatricula(matricula);//TODO username deve ser definido como único no hibernate
	}

	public AlunoDao getDao() {
		return dao;
	}

	public void setDao(AlunoDao dao) {
		this.dao = dao;
	}

}
