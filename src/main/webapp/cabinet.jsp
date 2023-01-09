<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cabinet</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-grid.css">
	<link rel="stylesheet" href="css/bootstrap-reboot.css">
	<link rel="stylesheet" href="css/bootstrap-utilities.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<c:import url="add/menu.jsp"/>

	<div class="container" style="height: 1000px;">
		<div class="row">
			<div class="col-md-12 m_corr">
				<h2>Добро пожаловать ${user.login}</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="main_news">
					<div class="row">
						<div class="col-3">
							<c:choose>
								<c:when test="${not empty user.image.name}">
									<img src="image/${user.image.name}" class="img-fluid">
								</c:when>
								<c:otherwise>
									<img src="image/user.png" class="img-fluid">
								</c:otherwise>
							</c:choose>
							<form method="post" enctype="multipart/form-data" action="<c:url value="<%= AppConstant.FILE_UPLOAD_CONT%>"/>">
								<input type="file" name="<%= AppConstant.FILE_PARAMETER%>" class="form-control"><br>
								<input type="submit" class="btn btn-success" value="Загрузить">
							</form>
						</div>
						<div class="col-9">
							<h3>Личные данные:</h3><hr>
							<p>Текущая почта: ${user.email}</p>
							<form>
								<input type="text" class="form-control" placeholder="Имя"><br>
								<input type="email" class="form-control" placeholder="Почта"><br>
								<input type="password" class="form-control" placeholder="Новый пароль"><br>
								<input type="password" class="form-control" placeholder="Подтвердить новый пароль"><br>
								<input type="submit" class="btn btn-success" value="Поменять">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<c:import url="add/footer.jsp"/>

	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>