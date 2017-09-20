<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cartoon Details</title>
</head>
<body>
	<h2>${cartoon.name}</h2>
	<ul>
		<li>Age - ${cartoon.age}</li>
		<li>Color - ${cartoon.color}</li>
		<li>Sex - 	<c:choose>
						<c:when test="${cartoon.sex=='true'}">Male</c:when>
						<c:when test="${cartoon.sex=='false'}">Female</c:when>
					</c:choose></li>
		<li>Category - ${cartoon.category.name}</li>
	</ul>
	<a href="/SpringHibernate/cartoon/modify/${cartoon.id}">Modyfikuj</a>
	<br>
	<a href="/SpringHibernate/cartoon/list">Wróć</a>
</body>
</html>