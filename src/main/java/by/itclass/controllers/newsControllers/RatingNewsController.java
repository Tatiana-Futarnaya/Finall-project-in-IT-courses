package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.enums.EnumManager;
import by.itclass.model.enums.RatingNews;
import by.itclass.model.exceptions.DAOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RatingNewsController", value =AppConstant.RATING_NEWS_CONT)
public class RatingNewsController extends AbstractNewsControllers {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter(AppConstant.ID_PARAMETER);
        String rating=request.getParameter(AppConstant.RATING_PARAMETER);

        HttpSession session=request.getSession();
        User user= (User) session.getAttribute(AppConstant.USER_ATTR);

        try {
            int idNews = Integer.parseInt(id);
            News news=newsDAO.getNewById(idNews);
            RatingNews ratingNews = EnumManager.getKindRatingNews(rating);
            newsDAO.updateRating(news,user, ratingNews);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        forward(request,response, AppConstant.VIEW_CONT);
    }
}
