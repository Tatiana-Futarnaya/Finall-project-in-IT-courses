package by.itclass.model.dao.newsDAO;

import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.db.hibernate.HQLRequest;
import by.itclass.model.db.hibernate.HibernateManager;
import by.itclass.model.enums.ActionNews;
import by.itclass.model.enums.RatingNews;
import by.itclass.model.exceptions.DAOException;
import org.apache.commons.fileupload.FileItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class NewsHibernateMySqlDAOImpl implements INewsDAO{
    @Override
    public List<News> getNewsList(int idUser) throws DAOException {
        List<News> newsList=null;
        try(Session session= HibernateManager.getSession()){
            Query<News> query=session.createQuery(HQLRequest.SELECT_NEWS_BY_ID_USER,News.class);
            query.setParameter(1, idUser);
            newsList=query.list();
        }
        return newsList;
    }

    @Override
    public void removeImageNews(String id, User user) throws DAOException {

    }

    @Override
    public News getNewById(int id) throws DAOException {
        return null;
    }

    @Override
    public void setNews(News news) throws DAOException {

    }

    @Override
    public void addNews(News news,ActionNews action) throws SQLException, DAOException {

    }

    @Override
    public void deleteLike(int idNews, int idUser) throws SQLException {

    }

    @Override
    public void updateRating(News news, User user, RatingNews rating) throws SQLException {

    }


    @Override
    public boolean existsRating(int id, int idUser) throws SQLException {
        return false;
    }

    @Override
    public void insertLike(int idNews, int idUser) throws SQLException {

    }


    @Override
    public List<News> getAllNews() throws DAOException {
        return null;
    }

    @Override
    public List<News> getTopNews() throws DAOException {
        return null;
    }

    @Override
    public void saveImage(int idNews, Image image) throws SQLException {

    }





    @Override
    public void remove(String id, User user) throws DAOException {
        try(Session session= HibernateManager.getSession()){
            Transaction transaction=session.beginTransaction();
            int idNews=Integer.parseInt(id);
            News news=session.get(News.class, idNews);
            session.delete(news);
            transaction.commit();
        }

    }

}
