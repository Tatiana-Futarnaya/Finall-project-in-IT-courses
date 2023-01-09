package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.News;
import by.itclass.model.exceptions.DAOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewNewsController", value = AppConstant.VIEW_CONT)
public class ViewNewsController extends AbstractNewsControllers {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idNews=request.getParameter(AppConstant.ID_PARAMETER);
        System.out.println("idNews: "+idNews);
        String  action=request.getParameter("action");
        System.out.println("action: "+action);

        News newsOne= null;
        try {
            newsOne = newsDAO.getNewById(Integer.parseInt(idNews));
            System.out.println("newsOne: "+newsOne);
            request.setAttribute(AppConstant.NEWS_ONE_ATTR,newsOne);


        } catch (DAOException e) {
            e.printStackTrace();
        }



        if(action!=null){
            forward(request,response,AppConstant.NEWS_JSP);
        }else{
            forward(request,response,AppConstant.ADD_NEWS_JSP);
        }



    }
}
