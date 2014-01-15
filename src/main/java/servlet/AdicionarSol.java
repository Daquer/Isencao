package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IsencaoService;
import dominio.Aluno;
import dominio.Disciplina;
import dominio.ItemSolicitacao;
import dominio.Situacao;
import dominio.SituacaoItem;
import dominio.Solicitacao;


public class AdicionarSol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IsencaoService isencaoService = new IsencaoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String metodo = request.getParameter("method");
		
		HttpSession session = request.getSession();
		
		Aluno aluno = (Aluno) session.getAttribute("aluno");
		List<ItemSolicitacao> itens = new ArrayList<ItemSolicitacao>();
		
		if(session.getAttribute("itensSolicitacao") != null)
			itens = (ArrayList<ItemSolicitacao>) session.getAttribute("itensSolicitacao");
		
		if (metodo.equals("exibir")) {
			
			request.setAttribute("disciplinas", isencaoService.obterDisciplinasPorCurso(aluno.getCurso().getCursoId()));
			request.getRequestDispatcher("Adicionar Solicitacao.jsp").forward(request,response);
		}
		
		if (metodo.equals("adicionar")) {
			
			
			Disciplina disciplina = new Disciplina();
			
			ItemSolicitacao itemSolicitacao = new ItemSolicitacao();
			
			String codExterna = request.getParameter("codExterna");
			String nomeExterna = request.getParameter("nomeExterna");
			
			disciplina = isencaoService.obterDisciplinaPorId(Integer.parseInt(request.getParameter("disciplinaInt")));
			
			disciplina.setCodigo(disciplina.getCodigo());
			disciplina.setNome(disciplina.getNome());
			
			itemSolicitacao.setDisciplina(disciplina);
			
			itemSolicitacao.setNomeDisExterna(nomeExterna);
			itemSolicitacao.setCodDisExterna(codExterna);
	
			itens.add(itemSolicitacao);
			
			session.setAttribute("itensSolicitacao", itens);
			request.getRequestDispatcher("PopupCloser.jsp").forward(request,response);
		}
		
		if(metodo.equals("remover")) {
			itens.remove(Integer.parseInt(request.getParameter("id"))); 
			session.setAttribute("itensSolicitacao", itens);
			request.getRequestDispatcher("Solicitacoes de Isencao.jsp").forward(request,response);
		}
		
		if(metodo.equals("registrar")) {
			Solicitacao solicitacao = new Solicitacao();
			solicitacao.setAluno(aluno);
			solicitacao.setDataRealizacao(new Date());
			solicitacao.setItensSolicitacao(itens); 
			
			solicitacao.setSituacao(Situacao.EMANALISE);
			
			solicitacao = isencaoService.adicionarSolicitacao(solicitacao);
			
			for(int i=0; i <itens.size();i++) {
				itens.get(i).setSolicitacao(solicitacao);
				itens.get(i).getSolicitacao().setSolicitacaoId(solicitacao.getSolicitacaoId());
				itens.get(i).setSituacaoItem(SituacaoItem.INDEFINIDO);
			}
			
			isencaoService.adicionarItensDeSolicitacao(itens);
			
			request.setAttribute("idSolicitacao", solicitacao.getSolicitacaoId());
			session.removeAttribute("itensSolicitacao");
			request.getRequestDispatcher("Solicitacoes de Isencao.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
