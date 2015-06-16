<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<ul>
		<c:forEach items="${sucess}" var="sucesso">
  			<li>${sucesso.category} - ${sucesso.message} - ${sucesso.severity}</li>
		</c:forEach>
		<c:forEach items="${errors}" var="error">
  			<li>${error.category} - ${error.message} - ${error.severity}</li>
		</c:forEach>
	</ul>

	<c:forEach items="${alunoList}" var="aluno">
		${aluno.nomeCompleto}<br />
	</c:forEach>
	
	${string}
	
	${nome}

</body>
</html>