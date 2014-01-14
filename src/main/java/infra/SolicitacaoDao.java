package infra;

import dominio.Solicitacao;

public interface SolicitacaoDao {
	public Solicitacao adicionarSolicitacao(Solicitacao solicitacao);
	
	public Solicitacao obterSolicitacaoPorId(long solicitacaoId);
}
