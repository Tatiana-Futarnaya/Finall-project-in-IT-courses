package by.itclass.model.dao.userDAO;

import by.itclass.model.beans.Image;
import by.itclass.model.beans.User;
import by.itclass.model.db.jdbc.ConnectionManager;
import by.itclass.model.db.jdbc.SQLRequest;
import by.itclass.model.exceptions.DAOException;
import org.apache.commons.fileupload.FileItem;

import java.io.IOException;
import java.sql.*;

public class UserMySqlDAOImpl implements IUserDAO {
    @Override
    public User get(String login, String password) throws DAOException {
        User user=null;
        try(Connection cn= ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.SELECT_USER_BY_LOGIN_AND_PASSWORD)){
            //сколько вопросов столько и позиций
            pst.setString(1,login);
            pst.setString(2, password);


            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                int id=rs.getInt(SQLRequest.ID);
                String email=rs.getString(SQLRequest.EMAIL);
                String name=rs.getString(SQLRequest.NAME);
                byte[] content=rs.getBytes(SQLRequest.CONTENT);
                Image image=new Image(name,content);
                user=new User(id,login,email,image);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return user;
    }

    @Override
    public void set(String login, String email, String password) throws DAOException {
        try(Connection cn= ConnectionManager.getConnection();
        PreparedStatement pst=cn.prepareStatement(SQLRequest.INSERT_USER_BY_LOGIN_AND_PASSWORD_AND_EMAIL)) {

            pst.setString(1,login);
            pst.setString(2,password);
            pst.setString(3,email);

            pst.executeUpdate();


        } catch (SQLException e) {
            throw new DAOException(e);
        }
        setUserImage();
    }


    public void setUserImage() throws DAOException {
        try(Connection cn= ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.INSERT_USER_IMAGE)) {
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean repeatLoginOrEmail(String login, String email) throws DAOException {
        boolean result=false;

        String loginNew=login;
        String emailNew=email;

        try(Connection cn= ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.SELECT_USER_BY_LOGIN_AND_EMAIL)){
            //сколько вопросов столько и позиций
            pst.setString(1,login);
            pst.setString(2, email);

            ResultSet rs=pst.executeQuery();

            if (rs.next()){
                System.out.println(loginNew);
                if(login.equals(loginNew) || email.equals(emailNew)){
                    result=true;
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return result;
    }

    @Override
    public boolean saveImage(User user) throws DAOException {
        boolean isSave=false;
        Image image=user.getImage();
        try (Connection cn=ConnectionManager.getConnection();
        PreparedStatement pst=cn.prepareStatement(SQLRequest.UPDATE_IMAGE_BY_ID_USER)){
            pst.setString(1, image.getName());
            pst.setBytes(2, image.getContent());
            pst.setInt(3, user.getId());
            isSave=pst.executeUpdate()>0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return isSave;
    }
}
