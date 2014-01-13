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
import dominio.DisciplinaExterna;
import dominio.ItemSolicitacao;
import dominio.Solicitacao;


public class AdicionarSol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IsencaoService isencaoService = new IsencaoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeInterna = request.getParameter("nomeInterna");
		String nomeExterna = request.getParameter("nomeExterna");
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
			
			DisciplinaExterna disciplinaExterna = new DisciplinaExterna();
			
			ItemSolicitacao itemSolicitacao = new ItemSolicitacao();
			
			disciplina = isencaoService.obterDisciplinaPorId(Integer.parseInt(request.getParameter("disciplinaInt")));
			
			String codInterna = request.getParameter("codInterna");
			String codExterna = request.getParameter("codExterna");
			
			disciplina.setCodigo(disciplina.getCodigo());
			disciplina.setNome(disciplina.getNome());
			
			disciplinaExterna.setCodigo(codExterna);
			disciplinaExterna.setNome(nomeExterna);
			
			
			itemSolicitacao.setDisciplina(disciplina);
			itemSolicitacao.setDisciplinaExterna(disciplinaExterna);
	
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
			DisciplinaExterna disciplinaExterna = new DisciplinaExterna();
			
			Solicitacao solicitacao = new Solicitacao();
			solicitacao.setAluno(aluno);
			solicitacao.setDataRealizacao(new Date());
			solicitacao.setItensSolicitacao(itens);
			solicitacao.setSituacao("Aguardando Analise");
			
			itens.get(1).set
			
			isencaoService.adicionarSolicitacao(solicitacao);
			isencaoService.adicionarItensSolicitacao(itens);
			isencaoService.adicionarDisciplinaExterna(itens);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
