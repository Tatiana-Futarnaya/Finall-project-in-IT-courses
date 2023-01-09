<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>New news</title>
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
				<c:choose>
					<c:when test="${not empty newsOne}">
						<h2>Редактировать новость</h2>
					</c:when>
					<c:otherwise>
						<h2>Добавить новость</h2>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<c:choose>
			<c:when test="${not empty newsOne}">
				<div class="row">
					<div class="col-md-12">
						<div class="main_news">
							<form method="post" accept-charset="UTF-8"   enctype="multipart/form-data" action="<c:url value="<%= AppConstant.SAVE_NEWS_CONT%>"/>">
								<input type="text" class="form-control" name="<%= AppConstant.TITLE_PARAMETER%>" value="${newsOne.title}" placeholder="Введите заголовок"><br>
								<textarea rows="10" class="form-control" name="<%= AppConstant.TEXT_PARAMETER%>" placeholder="Введите текст новости">${newsOne.text}</textarea><br>
								<input type="hidden" name="<%= AppConstant.ID_PARAMETER%>" value="${newsOne.id}">
								<input type="hidden" name="<%= AppConstant.ACTION_PARAMETER%>" value="<%= AppConstant.EDIT_ACTION_VALUE%>">
								<input type="file" name="<%= AppConstant.FILE_PARAMETER%>" name="${newsOne.image.name}" accept="image/*" class="form-control"><br>
								<input type="submit" class="btn btn-success" value="Редактировать новость">
							</form>

						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col-md-12">
						<div class="main_news">
							<form method="post" accept-charset="UTF-8"  enctype="multipart/form-data" action="<c:url value="<%= AppConstant.SAVE_NEWS_CONT%>"/>">
								<input type="text" class="form-control" name="<%= AppConstant.TITLE_PARAMETER%>"  placeholder="Введите заголовок"><br>
								<textarea rows="10" class="form-control" name="<%= AppConstant.TEXT_PARAMETER%>" placeholder="Введите текст новости"></textarea><br>
								<input type="hidden" name="<%= AppConstant.ACTION_PARAMETER%>" value="<%= AppConstant.ADD_ACTION_VALUE%>">
								<input type="file" name="<%= AppConstant.FILE_PARAMETER%>" class="form-control"><br>
								<input type="submit" class="btn btn-success" value="Добавить новость">
							</form>

						</div>
					</div>
				</div>
			</c:otherwise>

		</c:choose>

	</div>

<c:import url="add/footer.jsp"/>


	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>