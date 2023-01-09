package by.itclass.controllers.userControllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.Image;
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

@WebServlet(name = "AuthorizationController", value = AppConstant.AUTHORIZATION_CONT)
public class AuthorizationController extends AbstractUserController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_PARAMETER);
        String password = request.getParameter(AppConstant.PASSWORD_PARAMETER);

        User user = null;
        try {
            user = userDAO.get(login, password);

            if (user != null) {
                //Обработка картинки
                Image image=user.getImage();
                if(image.getName()!=null){
                    ImageManager.createImage(getServletContext().getRealPath("/image"),image);
                }
                //cabinet.jsp
                HttpSession session = request.getSession();//30
                session.setAttribute(AppConstant.USER_ATTR, user);
                redirect(response, AppConstant.CABINET_JSP);
            } else {
                //auth.jsp
                forward(request, response, AppConstant.AUTH_JSP, AppConstant.INCORRECT_LOGIN_OR_PASSWORD_MESSAGE);
            }
        } catch (DAOException e) {
           forward(request,response,AppConstant.AUTH_JSP, e.getMessage());
           e.printStackTrace();
        }
    }
}
