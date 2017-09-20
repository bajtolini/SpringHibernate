<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dodaj nowego Cartoon-a</title>
	<style type="text/css">
	.error {
		color: red;
	}
	</style>
</head>
<body>
	<form:form method="post" modelAttribute="cartoon">
		Nazwa : <form:input path="name"/><br>
		Wiek : <form:input path="age"/><br>
		Kolor : <form:checkboxes path="color" items="${colors}"/><br>
		Sex : <form:checkbox path="sex" label="Male" id="maleCheckbox" class="sex"/>
			<input type="checkbox" class="sex" id="femaleCheckbox"><label for="female_checkbox">Female</label><br>
		Category:<form:select itemValue="id" itemLabel="name"
			path="category" items="${categories}"/><br>
		<input type="submit" value="Save"><br>
		<form:errors path="*" cssClass="error"/>
	</form:form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src='<c:url value="/resources/cart/js/add.js"/>'></script>
</body>
</html>