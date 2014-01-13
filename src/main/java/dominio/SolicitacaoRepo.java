package dominio;

import infra.SolicitacaoDao;
import infra.SolicitacaoDaoJpa;

public class SolicitacaoRepo {

	private SolicitacaoDao dao = new SolicitacaoDaoJpa();

	public void adicionarSolicitacao(Solicitacao solicitacao) {
		dao.adicionarSolicitacao(solicitacao);
	}
}
