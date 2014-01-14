package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IsencaoService;

public class ResultadoDeSolicitacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IsencaoService isencaoService = new IsencaoService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("codigo"));
				
		request.setAttribute("solicitacao", isencaoService.obterSolicitacaoPorId(id));
		request.getRequestDispatcher("Resultado de Solicitacao.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
