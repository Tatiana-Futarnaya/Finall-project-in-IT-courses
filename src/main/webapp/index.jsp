<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My news</title>
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
        <div class="col-lg-8 m_corr">
            <div class="main_news">
                <c:choose>
                    <c:when test="${not empty newsList.getFirst().image.name}">
                        <img src="image/${newsList.getFirst().image.name}"  class="img-fluid">
                    </c:when>
                    <c:otherwise>
                        <img src="image/img1.jpg" class="img-fluid">
                    </c:otherwise>
                </c:choose>

                <h2>${newsList.getFirst().title}</h2>
                <p>${newsList.getFirst().text}
                    <a href="<c:url value="<%= AppConstant.VIEW_CONT %>"/>?id=${newsList.getFirst().id}&action=<%= AppConstant.NEWS_PARAMETER%>">читать далее...</a>
                </p>
                <p> &nbsp;
                    <span class="right_date">${newsList.getFirst().timestamp}</span>
                </p>
            </div>
        </div>
        <div class="col-lg-4 m_corr">
            <iframe frameborder="0" height="131" marginheight="0" marginwidth="0" scrolling="no" src="https://admin.myfin.by/outer/informer/brest/full" width="100%"></iframe>

            <hr>

            <h3>Топ новости за неделю:</h3>
            <!-- сделать вывод 3 лучших новостей за последнюю неделю - JAVA -->
            <c:forEach var="news" items="${newsTop}">
            <div class="top_news">
                <h4> &#128077; ${news.rating}- ${news.title}</h4>
                <p>${news.text}
                    <a href="<c:url value="<%= AppConstant.VIEW_CONT %>"/>?id=${news.id}&action=<%= AppConstant.NEWS_PARAMETER%>">читать далее...</a>
                </p>
                <!-- В этой новости в превью выводится до 150 символов - JAVA -->
            </div>
            </c:forEach>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12 m_corr">

        <c:forEach var="news" items="${newsList}">
            <div class="regular_news">
                <div class="row">
                    <div class="col-4">
                        <c:choose>
                            <c:when test="${not empty news.image.name}">
                                <img src="image/${news.image.name}"  class="img-fluid">
                            </c:when>
                            <c:otherwise>
                                <img src="image/img1.jpg" class="img-fluid">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col-8">
                        <h4> ${news.title}</h4>
                        <p>${news.text}
                            <a href="<c:url value="<%= AppConstant.VIEW_CONT %>"/>?id=${news.id}&action=<%= AppConstant.NEWS_PARAMETER%>">читать далее...</a></p>
                        <p> &nbsp;
                            <span class="right_date">${news.timestamp}</span>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>


        </div>
    </div>
</div>

<c:import url="add/footer.jsp"/>

<script src="js/bootstrap.js"></script>
<script src="js/jquery-3.6.0.js"></script>
</body>
</html>
