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
<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js" ></script>
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
					C�digo <input type="text" name="codigo" id="codigo" />
					<input type="submit" value="Buscar" class="button_left" id="Buscar" name="Buscar"/>
					<table border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<th colspan="2">
											Disciplinas Externas
										</th>
										<th colspan="2">
											Disciplinas Internas
										</th>
									</tr>
									<tr>
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
											Situa��o
										</th>
									</tr>
									<%
									if(solicitacao != null && !solicitacao.getItensSolicitacao().isEmpty()) {
										for(int i=0; i < solicitacao.getItensSolicitacao().size(); i++) {
											ItemSolicitacao itemAtual = solicitacao.getItensSolicitacao().get(i);
											
											out.write("<td>"+ itemAtual.getDisciplina().getNome() +"</td>");
											out.write("<td>"+ itemAtual.getDisciplina().getCodigo() + "</td>");
											out.write("<td>"+ itemAtual.getNomeDisExterna() + "</td>");
											out.write("<td>"+ itemAtual.getCodDisExterna() +"</td>");
											out.write("<td>" + itemAtual.getSituacaoItem().getValue() + "</td>" );
											out.write("</tr>");
										}
									}
									%>
					</table>
			</form>
		</div>
	</div>
	<script>
	$("#Buscar").click(function() {
		if($("#codigo").val() == "") {
			alert('Insira um valor.');
			return false;
		}
	});
	</script>
</body>