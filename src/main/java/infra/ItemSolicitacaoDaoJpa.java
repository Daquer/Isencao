package infra;

import java.util.List;

import dominio.ItemSolicitacao;

public class ItemSolicitacaoDaoJpa extends GenericDaoJpa<ItemSolicitacao> implements ItemSolicitacaoDao  {

	@Override
	public void adicionarItensDeSolicitacao(
			List<ItemSolicitacao> itensSolicitacao) {
		for(int i = 0; i<itensSolicitacao.size();i++){
			super.incluir(itensSolicitacao.get(i));
		}
	}

	
}
