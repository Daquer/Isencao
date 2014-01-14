package infra;

import dominio.Solicitacao;

public class SolicitacaoDaoJpa extends GenericDaoJpa<Solicitacao> implements SolicitacaoDao {

	@Override
	public Solicitacao adicionarSolicitacao(Solicitacao solicitacao) {
		return super.incluirComRetorno(solicitacao);
	}
	
	@Override
	public Solicitacao obterSolicitacaoPorId(long solicitacaoId) {
		String consulta = "SELECT a from Solicitacao a WHERE a.solicitacaoId = ?";
		Object array[] = { solicitacaoId };
		return super.obterEntidade(consulta, array);
	}

}
