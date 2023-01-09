package by.itclass.model.dao.newsDAO;

import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.enums.ActionNews;
import by.itclass.model.enums.RatingNews;
import by.itclass.model.exceptions.DAOException;
import by.itclass.model.memory.NewsMemory;
import org.apache.commons.fileupload.FileItem;

import java.sql.SQLException;
import java.util.List;

public class NewsInMemoryDAOImpl implements INewsDAO{
    @Override
    public List<News> getNewsList(int idUser) {
        return NewsMemory.selectNewsByIdUser(idUser);
    }

    @Override
    public void remove(String id, User user) throws DAOException {

    }

    @Override
    public void removeImageNews(String id, User user) throws DAOException {

    }


    @Override
    public News getNewById(int id) {
        return NewsMemory.editNewById(id);
    }

    @Override
    public void setNews(News news) {
        NewsMemory.setNews(news);
    }


    @Override
    public void addNews(News news,  ActionNews action) {
        NewsMemory.addNews(news);//реализация с памятью
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



}
