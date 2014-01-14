<%@page import="dominio.ItemSolicitacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dominio.Disciplina" %>
<%@page import="dominio.Solicitacao" %>
<%@page import="dominio.ItemSolicitacao" %>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>
	Resultado de Solicitacao
</title>
<link rel="stylesheet" type="text/css" href="site.css" />
</head>
<body>
<%
Solicitacao solicitacao = (Solicitacao) request.getAttribute("solicitacao");
%>
	<div class="caixa">
		<div>
			<form action="ResultadoDeSolicitacao.do" method="POST">
					<h1>Resultado de Solicita&ccedil;&atilde;o</h1>
					<h2>Solicita&ccedil;&otilde;es</h2>
					Código <input type="text" name="codigo" id="codigo" />
					<input type="submit" value="Buscar" class="button_left" />
					<table border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<th>
										</th>
										<th colspan="2">
											Disciplinas Externas
										</th>
										<th colspan="2">
											Disciplinas Internas
										</th>
									</tr>
									<tr>
										<th>
											Numero da Solicitacao
										</th>
										<th>
											Nome
										</th>
										<th>
											Codigo
										</th>
										<th>
											Nome
										</th>
										<th>
											Codigo
										</th>
										<th>
											Situação
										</th>
									</tr>
									<%
									if(solicitacao != null && !solicitacao.getItensSolicitacao().isEmpty()) {
										for(int i=0; i < solicitacao.getItensSolicitacao().size(); i++) {
											ItemSolicitacao itemAtual = solicitacao.getItensSolicitacao().get(i);
											out.write("<tr><td>" + itemAtual.getItemSolicitacaoId() + "</td>" );
											out.write("<td>"+ itemAtual.getDisciplina().getNome() +"</td>");
											out.write("<td>"+ itemAtual.getDisciplina().getCodigo() + "</td>");
											out.write("<td>"+ itemAtual.getNomeDisExterna() + "</td>");
											out.write("<td>"+ itemAtual.getCodDisExterna() +"</td>");
											out.write("<td>" + itemAtual.getSituacao() + "</td>" );//deferido ou indeferido 
											out.write("</tr>");
										}
									}
									%>
					</table>
			</form>
		</div>
	</div>
</body>