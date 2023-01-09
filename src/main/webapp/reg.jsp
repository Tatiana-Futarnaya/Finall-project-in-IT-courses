<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-grid.css">
	<link rel="stylesheet" href="css/bootstrap-reboot.css">
	<link rel="stylesheet" href="css/bootstrap-utilities.css">
	<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<c:import url="add/menu.jsp"/>


	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>	
			<div class="col-md-4 m_corr text_center">
				<h2>Регистрация</h2>
				<c:if test="${not empty message}">
					<p style="color: red">${message}</p>
				</c:if>
				<br>
				<form method="post" action="<c:url value="<%= AppConstant.REGISTRATION_CONT %>"/>">
					<input type="text" class="form-control" name="<%= AppConstant.LOGIN_PARAMETER %>" placeholder="Введите имя"><br>
					<input type="password" class="form-control" name="<%= AppConstant.PASSWORD_PARAMETER %>" placeholder="Введите пароль"><br>
					<input type="password" class="form-control" name="<%= AppConstant.PASSWORD_REPEATED_PARAMETER%>" placeholder="Введите подтверждение пароля"><br>
					<input type="email" class="form-control" name="<%= AppConstant.EMAIL_PARAMETER%>" placeholder="Введите почту"><br>
					<input type="submit" class="btn btn-success" value="Регистрация">
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	



	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>