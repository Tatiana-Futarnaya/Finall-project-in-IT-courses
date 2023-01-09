package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.exceptions.DAOException;
import by.itclass.model.files.ImageManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "OutputMainPage", value = AppConstant.MAIN_PAGE_CONT)
public class OutputMainPage extends AbstractNewsControllers {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> news=new LinkedList<>();


        try {
            List<News> newsList= newsDAO.getAllNews();
            List<News> newsListSort= newsDAO.getAllNews();


            Collections.sort(newsListSort, new Comparator<News>() {
                @Override
                public int compare(News news1, News news2) {
                    return news2.getRating()-news1.getRating();
                }
            });

            for (News item: newsListSort) {
                if(news.size()<=AppConstant.LIMIT_VIEW_TOP_NEWS){
                    news.add(item);
                }
            }


            for(int i=0; i< news.size(); i++){
                if(news.get(i).getImage().getName()!=null){
                    Image image=news.get(i).getImage();
                    ImageManager.createImage(getServletContext().getRealPath("/image"),image);
                }
            }


            request.setAttribute(AppConstant.NEWS_LIST_ATTR,newsList);
            request.setAttribute(AppConstant.NEWS_TOP_ATTR,news);

            forward(request,response,AppConstant.INDEX_JSP);
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }
}
