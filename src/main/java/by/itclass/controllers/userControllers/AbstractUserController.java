package by.itclass.controllers.userControllers;

import by.itclass.controllers.AbstractController;
import by.itclass.model.dao.userDAO.IUserDAO;
import by.itclass.model.dao.userDAO.UserHibernateMySqlDAOImpl;
import by.itclass.model.dao.userDAO.UserInMemoryDAOImpl;
import by.itclass.model.dao.userDAO.UserMySqlDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AbstractUserController")
public abstract class AbstractUserController extends AbstractController {
    protected IUserDAO userDAO;

    public AbstractUserController() {
       userDAO = new UserMySqlDAOImpl();
        //userDAO=new UserHibernateMySqlDAOImpl();
    }
}
