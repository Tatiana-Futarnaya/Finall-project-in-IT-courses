package by.itclass.model.dao.userDAO;

import by.itclass.model.beans.User;
import by.itclass.model.exceptions.DAOException;
import by.itclass.model.memory.UserMemory;
import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.io.InputStream;

public class UserInMemoryDAOImpl implements IUserDAO {
    @Override
    public User get(String login, String password) {
        return UserMemory.selectByLoginAndPassword(login, password);
    }

    @Override
    public void set(String login, String email, String password) {
        UserMemory.addUser(login, email, password);
    }

    @Override
    public boolean repeatLoginOrEmail(String login, String email) {
        return UserMemory.findRepeat(login, email);
    }

    @Override
    public boolean saveImage(User user) throws DAOException {
        return false;
    }


}
