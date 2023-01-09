package by.itclass.model.dao.userDAO;


import by.itclass.model.beans.User;
import by.itclass.model.db.hibernate.HQLRequest;
import by.itclass.model.db.hibernate.HibernateManager;
import by.itclass.model.exceptions.DAOException;
import org.apache.commons.fileupload.FileItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;

public class UserHibernateMySqlDAOImpl implements IUserDAO {
    @Override
    public User get(String login, String password) throws DAOException {
        User user=null;
        try(Session session= HibernateManager.getSession()){
            Query<User> query=session.createQuery(HQLRequest.SELECT_USER_BY_LOGIN_AND_PASSWORD, User.class);
            query.setParameter(1, login);
            query.setParameter(2, password);
            user=  query.uniqueResult();


        }
        return user ;
    }

    @Override
    public void set(String login, String email, String password) throws DAOException {

    }

    @Override
    public boolean repeatLoginOrEmail(String login, String email) throws DAOException {
        return false;
    }

    @Override
    public boolean saveImage(User user) throws DAOException {
        return false;
    }

    /*@Override
    public boolean saveImage(int idUser, FileItem file, String path) throws DAOException {
        boolean isSave=false;
        try(Session session= HibernateManager.getSession()){
            Transaction transaction=session.beginTransaction();
            Query query=session.createQuery(HQLRequest.UPDATE_IMAGE_BY_ID_USER);
            query.setParameter(1, file.getName());
            query.setParameter(2, file.getString());
            query.setParameter(3, idUser);

            isSave =query.executeUpdate()>0;
            transaction.commit();
        }
        System.out.println(isSave);
        return isSave;
    }*/
}
