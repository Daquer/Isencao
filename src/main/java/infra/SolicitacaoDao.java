package infra;

import dominio.Solicitacao;

public interface SolicitacaoDao {
	public void adicionarSolicitacao(Solicitacao solicitacao);
	
	public Solicitacao obterSolicitacaoPorId(long solicitacaoId);
}
