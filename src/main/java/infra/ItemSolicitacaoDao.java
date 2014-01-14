package infra;

import java.util.List;

import dominio.ItemSolicitacao;

public interface ItemSolicitacaoDao {
	
	public abstract void adicionarItensDeSolicitacao(List<ItemSolicitacao> itensSolicitacao);
}
