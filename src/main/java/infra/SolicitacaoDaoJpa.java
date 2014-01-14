package infra;

import dominio.Solicitacao;

public class SolicitacaoDaoJpa extends GenericDaoJpa<Solicitacao> implements SolicitacaoDao {

	@Override
	public void adicionarSolicitacao(Solicitacao solicitacao) {
		super.incluir(solicitacao);
	}
	
	@Override
	public Solicitacao obterSolicitacaoPorId(long solicitacaoId) {
		String consulta = "SELECT a from Solicitacao a WHERE a.solicitacaoId = ?";
		Object array[] = { solicitacaoId };
		return super.obterEntidade(consulta, array);
	}

}
