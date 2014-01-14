package dominio;

import javax.persistence.NoResultException;

import infra.SolicitacaoDao;
import infra.SolicitacaoDaoJpa;

public class SolicitacaoRepo {

	private SolicitacaoDao dao = new SolicitacaoDaoJpa();

	public Solicitacao adicionarSolicitacao(Solicitacao solicitacao) {
		return dao.adicionarSolicitacao(solicitacao);
	}
	
	public Solicitacao obterSolicitacaoPorId(long solicitacaoId) {
		return dao.obterSolicitacaoPorId(solicitacaoId);
	}
}
