package by.itclass.controllers.userControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.AbstractController;
import by.itclass.model.beans.User;
import by.itclass.model.exceptions.DAOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationController", value = AppConstant.REGISTRATION_CONT)
public class RegistrationController extends AbstractUserController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter(AppConstant.LOGIN_PARAMETER);
        String password=request.getParameter(AppConstant.PASSWORD_PARAMETER);
        String passwordRepeated=request.getParameter(AppConstant.PASSWORD_REPEATED_PARAMETER);
        String email=request.getParameter(AppConstant.EMAIL_PARAMETER);
        try {
            if(!login.isEmpty() || !password.isEmpty() || !passwordRepeated.isEmpty() || !email.isEmpty() ){
                if(password.equals(passwordRepeated)){
                    if (!userDAO.repeatLoginOrEmail(login, email)) {

                            userDAO.set(login,email,password);

                        redirect(response,AppConstant.AUTH_JSP);

                    }else {
                        forward(request,response,AppConstant.REG_JSP,AppConstant.REPEAT_LOGIN_OR_EMAIL);
                    }
                }else{
                    forward(request,response,AppConstant.REG_JSP,AppConstant.INCORRECT_LOGIN_OR_PASSWORD_MESSAGE);
                }
            }else{
                forward(request,response,AppConstant.REG_JSP,AppConstant.INCORRECT_LOGIN_OR_PASSWORD_MESSAGE);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
