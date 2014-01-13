<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dominio.Disciplina" %>
<%@page import="dominio.Aluno" %>
<%@page import="dominio.Solicitacao" %>	
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
Disciplina disciplina = new Disciplina();
Aluno aluno = (Aluno) session.getAttribute("aluno");
%>
	<div class="caixa">
		<div>
			<form action="#" method="POST">
					<h1>Resultado de Solicita&ccedil;&atilde;o</h1>
					<h2>Solicita&ccedil;&otilde;es</h2>
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
									if(!aluno.getSolicitacoes().isEmpty() && aluno.getSolicitacoes() != null) {
										for(int i=0; i < aluno.getSolicitacoes().size(); i++) {
											Solicitacao solAtual = aluno.getSolicitacoes().get(i);
											out.write("<tr><td>" + solAtual.getSolicitacaoId() + "</td>" );
											out.write("<td>"+"</td>");
											out.write("<td>"+"</td>");
											out.write("<td>"+"</td>");
											out.write("<td>"+"</td>");
											out.write("<td>" + solAtual.getSituacao() + "</td>" );//deferido ou indeferido 
											out.write("</tr>");
										}
									}	
									%>
									<tr>
										<td><% %></td>
										<td><% %></td>
										<td><% %></td>
										<td><% %></td>	
										<td><% %></td>
										<td><% %></td>
									</tr>
					</table>
					<input type="submit" value="Buscar" class="button_left" />
			</form>
		</div>
	</div>
</body>