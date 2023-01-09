package by.itclass.model.dao.userDAO;

import by.itclass.model.beans.User;
import by.itclass.model.exceptions.DAOException;
import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.io.InputStream;

public interface IUserDAO {
    User get(String login, String password) throws DAOException;

    void set(String login, String email, String password) throws DAOException;

    boolean repeatLoginOrEmail(String login, String email) throws DAOException;

    boolean saveImage(User user) throws DAOException;
}
