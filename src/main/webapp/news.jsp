<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>News</title>
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
			<div class="col-lg-12 m_corr">
				<div class="main_news">
					<center>
						<c:choose>
							<c:when test="${not empty newsOne.image.name}">
								<img src="image/${newsOne.image.name}"  class="img-fluid" style="max-height: 400px;">
							</c:when>
							<c:otherwise>
								<img src="image/img1.jpg" class="img-fluid" style="max-height: 400px;">
							</c:otherwise>
						</c:choose>

					</center>
					<br><hr>
					<h2> <button onclick="JavaScript:updateRating('upp')" class="like_button">&#128077;</button>
						${newsOne.rating}
						<button onclick="JavaScript:updateRating('down')"  class="like_button" >&#128078;</button>
						${newsOne.title}</h2>
					<p>${newsOne.text}</p>
					<p> &nbsp;
						<span class="right_date">${newsOne.timestamp}</span>
					</p>
					<br><br>
					<a href="<c:url value="<%= AppConstant.MAIN_PAGE_CONT %>"/>">Назад</a>
				</div>
			</div>
		</div>
		<form id="ratingForm" action="<c:url value="<%= AppConstant.RATING_NEWS_CONT %>"/>" method="post">
			<input type="hidden" name="<%= AppConstant.ID_PARAMETER %>" value="${newsOne.id}">
			<input type="hidden" name="<%= AppConstant.ID_USER_PARAMETER %>" value="${newsOne.idUser}">
			<input type="hidden" id="<%= AppConstant.RATING_PARAMETER %>" name="<%= AppConstant.RATING_PARAMETER %>">
			<input type="hidden" name="action">
		</form>
	</div>


<c:import url="add/footer.jsp"/>

	<script src="js/main.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>