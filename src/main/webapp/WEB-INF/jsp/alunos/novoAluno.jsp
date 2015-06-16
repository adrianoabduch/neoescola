<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="<c:url value="/jquery/chosen/chosen.css" />" rel="stylesheet">
	<script src="<c:url value="/jquery/jquery1_6_4.min.js"/>"></script>
    <script src="<c:url value="/jquery/chosen/chosen.jquery.min.js" />"></script>
</head>
<body>
	<form action="/alunos/salvar" method="get">
		<fieldset>
		    <legend>Novo aluno:</legend>
		    
		    <label for="nome">Unidade:</label>
            <select class="my_select_box" data-placeholder="Selecione uma unidade">
            	<option value=""></option>
   				<option value="1">Amazonas</option>
   				<option value="2">Minas Gerais</option>
   				<option value="3">São Paulo</option>
    			<option value="4">Rio Grande do Sul</option>
			</select>

		    <label for="nome">Nome:</label>
		    <input id="nome" type="text" name="aluno.primeiroNome" 
		        value="${aluno.primeiroNome}"/>
		    
		    <label for="nome">Sobrenome:</label>    
		    <input id="sobrenome" type="text" name="aluno.sobrenome" 
		        value="${aluno.primeiroNome}"/>
		        
		    
		
		    <button type="submit">Enviar</button>
		  </fieldset>
		</form>
		
		<script type="text/javascript">
			$(function() {
	
			    $(".my_select_box").chosen({
			    	no_results_text: "Nenhum resultado encontrado.",
			    	allow_single_deselect: true
			    });
	
			});
		</script>

</body>
</html>