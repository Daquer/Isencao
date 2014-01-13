package infra;

import dominio.Solicitacao;

public class SolicitacaoDaoJpa extends GenericDaoJpa<Solicitacao> implements SolicitacaoDao {

	@Override
	public void adicionarSolicitacao(Solicitacao solicitacao) {
		super.incluir(solicitacao);
	}

}
