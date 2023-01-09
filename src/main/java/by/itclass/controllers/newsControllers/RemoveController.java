package by.itclass.controllers.newsControllers;



import by.itclass.constants.AppConstant;
import by.itclass.model.beans.User;
import by.itclass.model.exceptions.DAOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RemoveController", value = AppConstant.REMOVE_CONT)
public class RemoveController extends AbstractNewsControllers {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idNews=request.getParameter(AppConstant.ID_PARAMETER);

        HttpSession session=request.getSession();

        User user= (User) session.getAttribute(AppConstant.USER_ATTR);
        try {
            newsDAO.remove(idNews, user);

        redirect(response,AppConstant.USER_NEWS_LIST_CONT);
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }


}
