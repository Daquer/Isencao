package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IsencaoService;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IsencaoService service = new IsencaoService();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		
		if(service.autenticaAluno(matricula, password)){
			session.setAttribute("aluno", service.obterAlunoPorMatricula(matricula));
			request.getRequestDispatcher("index-restrita.jsp").forward(request,response);
		} else {
			request.setAttribute("message", "Login inexistente");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
