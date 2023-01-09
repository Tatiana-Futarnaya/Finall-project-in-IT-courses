package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.exceptions.DAOException;
import by.itclass.model.files.ImageManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserNewsListController", value = AppConstant.USER_NEWS_LIST_CONT)
public class UserNewsListController extends AbstractNewsControllers {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        User user= (User) session.getAttribute(AppConstant.USER_ATTR);
        System.out.println(user);
        try {
            if(user!=null){
                List<News> newsList= newsDAO.getNewsList(user.getId());


                for(News news : newsList){
                    //Обработка картинки
                    Image image=news.getImage();
                    if(image.getName()!=null){
                        ImageManager.createImage(
                                getServletContext().getRealPath("/image"),
                                image);
                    }
                }

                request.setAttribute(AppConstant.NEWS_LIST_ATTR,newsList);
                forward(request,response,AppConstant.MYNEWS_JSP);
            }else{
                forward(request,response,AppConstant.AUTH_JSP,AppConstant.SESSION_TIMEOUT_MESSAGE);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
