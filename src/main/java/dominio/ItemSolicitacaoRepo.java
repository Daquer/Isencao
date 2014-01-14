package dominio;

import infra.ItemSolicitacaoDao;
import infra.ItemSolicitacaoDaoJpa;

import java.util.List;

public class ItemSolicitacaoRepo {
	ItemSolicitacaoDao dao = new ItemSolicitacaoDaoJpa();
	
	public void adicionarItensDeSolicitacao(List<ItemSolicitacao> itensSolicitacao) {
		dao.adicionarItensDeSolicitacao(itensSolicitacao);
	}
}
