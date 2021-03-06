<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Cartoons</title>
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/cart/css/cartoonStyle.css"/>'>
</head>
<body>
	<table>
		<tr>
			<th>	Nr</th>
			<th>Cartoon name</th>
			<th colspan="2">Links</th>
		</tr>
		<c:forEach items="${cartoons}" var="cart" varStatus="count">
			<tr>
				<td>${count.count}</td>
				<td>${cart.name}</td>
				<td><a href="details/${cart.id}">Szczegóły</a></td>
				<td><a href="delete/${cart.id}" class="confirm">Usuń</a></td>
			</tr>
		</c:forEach>
		<tr><td colspan="4">
			<button><a href="/SpringHibernate/cartoon/add" style="text-decoration: none">Dodaj</a></button>
		</td></tr>
	</table>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src='<c:url value="/resources/cart/js/del.js"/>'></script>
</body>
</html>