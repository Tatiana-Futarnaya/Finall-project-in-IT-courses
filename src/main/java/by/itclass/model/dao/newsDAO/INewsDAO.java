package by.itclass.model.dao.newsDAO;

import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.enums.ActionNews;
import by.itclass.model.enums.RatingNews;
import by.itclass.model.exceptions.DAOException;


import java.sql.SQLException;
import java.util.List;

public interface INewsDAO {
    List<News> getNewsList(int idUser) throws DAOException;
    void remove(String id, User user) throws DAOException;
    void removeImageNews(String id, User user) throws DAOException;
    News getNewById(int id) throws DAOException;
    void setNews(News news) throws DAOException;
    void addNews(News news,ActionNews action) throws SQLException, DAOException;

    void insertLike(int idNews, int idUser)  throws SQLException;
    void deleteLike(int idNews, int idUser) throws SQLException;

    void updateRating(News news, User user, RatingNews rating) throws SQLException;

   boolean existsRating(int id, int idUser) throws SQLException;

    List<News> getAllNews() throws DAOException;
    List<News> getTopNews() throws DAOException;
    void saveImage(int idNews, Image image) throws SQLException;



}
