<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<c:forEach items="${errors}" var="error">
	  		<li>${error.category} - ${error.message} - ${error.severity}</li>
		</c:forEach>
	</ul>

	<h2>Login</h2>
	
	<form action="<c:url value="/autentica" />" method="POST">
		Login: <input type="text" name="usuario.email" /> <br />
		Senha: <input type="password" name="usuario.senha" /> <br />
		<input type="submit" value="Entrar" />
	</form>

</body>
</html>